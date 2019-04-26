import Parser.*;
import Lexer.*;
import java.io.*;
import AST.*;
import Compiler.*;


public class Main
{

  private static void codeGenerator(String className, Prog program){

    try{

      BufferedWriter w = new BufferedWriter(new FileWriter(className + ".java"));

      w.write("import GeneratedCodeLib.*;");
      w.newLine();
      w.write("import java.util.*;");
      w.newLine();
      w.newLine();
      w.write("public class " + className + " {");
      w.newLine();
      program.generateCode(w);
      w.newLine();
      w.write("}");
      w.newLine();
      w.close();
      System.out.println("Código generado en el fichero " + className + ".java");

    } catch (Exception e){

      System.out.println("IOException al generar el código.");

    }

  }

  public static void main(String args[]) throws Exception{
    java.io.BufferedReader in;
    Yylex sc;
    parser p;
    Prog programa;
    java_cup.runtime.Symbol sroot;
    boolean error=false;

    //El primer parametro es el nombre del fichero con el programa
    if (args.length < 1) {
      System.out.println(
        "Uso: java Main <nombre_fichero>");
      error=true;
    }

    //Analisis lexico y sintactico

    if (!error) 
    {  
    	try 
      {
    	    in = new java.io.BufferedReader(new java.io.FileReader(args[0]));
    	    sc = new Yylex(in);
    	    p = new parser(sc);
    	    sroot = p.parse();
    	    System.out.println("Analisis lexico y sintactico correctos");
          programa = (Prog) sroot.value;
          programa.computeTyp();
          System.out.println("Análisis semántico correcto.");
          String className = args[1];
          codeGenerator(className, programa);
          in.close();
	   } catch(IOException e) 
        {
    	    System.out.println("Error abriendo fichero: " + args[0]);
    	    error= true;
	       }
  }

    

  }
}
