package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Vdef2 implements Vdef{
	public Decl decl;
	public Vdef vdef;

	public Vdef2(Decl decl, Vdef vdef){
		this.decl = decl;
		this.vdef = vdef;
	}

	public void computeTyp() throws CompilerExc{

		decl.computeTyp();
		vdef.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		String vars = decl.generateCode(w, tab);
		w.newLine();
		String aux [] = vars.split(" ");
		String tipo = aux[0];
		String lvar [] = aux[1].split(",");

		if (tipo.equals("int")) {

			for (int i = 0; i < lvar.length; i++) {

				w.write(tab + lvar[i] + " = 0;");
				w.newLine();
				
			}
			w.newLine();
			
		}else if (tipo.equals("double")) {

			for (int i = 0; i < lvar.length; i++) {

				w.write(tab + lvar[i] + " = 0.0;");
				w.newLine();
				
			}
			w.newLine();
			
		}else if (tipo.equals("boolean")) {

			for (int i = 0; i < lvar.length; i++) {

				w.write(tab + lvar[i] + " = false;");
				w.newLine();
				
			}
			w.newLine();
			
		}

		vdef.generateCode(w, tab);

		
	}
}