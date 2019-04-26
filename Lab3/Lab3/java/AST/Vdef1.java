package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Vdef1 implements Vdef{
	public Decl decl;

	public Vdef1(Decl decl){
		this.decl = decl;
	}

	public void computeTyp() throws CompilerExc{

		decl.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		String vars = decl.generateCode(w, tab);
		w.newLine();
		w.newLine();
		String aux [] = vars.split(" ");
		String tipo = aux[0];
		String variables = aux[1];
		String lvar [] = aux[1].split(",");

		if (tipo.equals("int")) {

			for (int i = 0; i < lvar.length; i++) {

				w.write(tab + lvar[i] + " = 0;");
				w.newLine();
				
			}
			
		}else if (tipo.equals("double")) {

			for (int i = 0; i < lvar.length; i++) {

				w.write(tab + lvar[i] + " = 0.0;");
				w.newLine();
				
			}
			
		}else if (tipo.equals("boolean")) {

			for (int i = 0; i < lvar.length; i++) {

				w.write(tab + lvar[i] + " = false;");
				w.newLine();
				
			}
			
		}

	}
}