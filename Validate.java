import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Checks the well-formedness and validity of a given XML document.
 * Invoke from command line as:
 * 
 * java -v document.xml
 * java -s document.xml
 * java document.xml
 * 
 * Without the -v option only well-formedness is checked. With it, both
 * well-formedness and validity are checked.
 *
 * The -s option does validation with respect to an XML Schema.
 *
 * @author jaf@it.uc3m.es
 *
 */
public class Validate {

	class ValidationErrorHandler implements ErrorHandler {
		protected boolean errors = false;
		
		@Override
		public void error(SAXParseException exception) throws SAXException {
			System.err.println("Error: " + exception.getMessage());
			errors = true;
		}

		@Override
		public void fatalError(SAXParseException exception) throws SAXException {
			System.err.println("Fatal error: " + exception.getMessage());
			errors = true;
		}

		@Override
		public void warning(SAXParseException exception) throws SAXException {
			// Do nothing...
		}
		
	}
	
    public boolean validate(String fileName, boolean xmlSchema) {
		boolean valid = false;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		if (xmlSchema) {
		    factory.setAttribute(
		      "http://java.sun.com/xml/jaxp/properties/schemaLanguage",
		      "http://www.w3.org/2001/XMLSchema");
		    factory.setNamespaceAware(true);
		}
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		}
		try {
			ValidationErrorHandler handler = new ValidationErrorHandler();
			builder.setErrorHandler(handler);
			Document document = builder.parse(new InputSource(fileName));
			valid = !handler.errors;
		} catch (SAXException e) {
			valid = false;
		} catch (IOException e) {
			valid = false;
			e.printStackTrace();
		}
		
		return valid;
	}
	
	public boolean checkWellFormedness(String fileName) {
		boolean wellFormed = false;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return false;
		}
		try {
			Document document = builder.parse(new InputSource(fileName));
			wellFormed = true;
		} catch (SAXException e) {
			wellFormed = false;
		} catch (IOException e) {
			wellFormed = false;
			e.printStackTrace();
		}
		
		return wellFormed;
	}

	public static void main(String[] args) {
		boolean validate;
		boolean schema;
		String xmlFileName;
		if (args.length < 1 || args.length > 2 ||
		    (args.length == 2 && !("-v".equals(args[0])
					   || "-s".equals(args[0])))) {
			printHelp();
			System.exit(1);
		}
		if (args.length == 2) {
			validate = true;
			xmlFileName = args[1];
			if ("-s".equals(args[0])) {
			    schema = true;
			} else {
			    schema = false;
			}
		} else {
			validate = false;
			schema = false;
			xmlFileName = args[0];
		}
		Validate validator = new Validate();
		if (validate) {
		    if (validator.validate(xmlFileName, schema)) {
				System.out.println("The document is well-formed and valid");
			} else {
				System.out.println("The document is not valid");
			}
		} else {
			if (validator.checkWellFormedness(xmlFileName)) {
				System.out.println("The document is well-formed");
			} else {
				System.out.println("The document is not well-formed");
			}			
		}
	}

	private static void printHelp() {
		System.err.println("Error: wrong command-line arguments");
		System.err.println("java Validate [-v|-s] file");
	}

}
