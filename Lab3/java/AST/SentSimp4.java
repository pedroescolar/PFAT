package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class SentSimp4 implements SentSimp{
	public Plot plot;

	public SentSimp4(Plot plot){
		this.plot = plot;
	}

	public void computeTyp() throws CompilerExc{

		plot.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		plot.generateCode(w, tab);

	}
}