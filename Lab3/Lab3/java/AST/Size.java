package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Size{
	public Exp exp1;
	public Exp exp2;

	public Size(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public void computeTyp() throws CompilerExc{

		if ((exp1.computeTyp() != Typ.tint) || (exp2.computeTyp() != Typ.tint)) {

			throw new TypExc(TypExc.INCOMPATIBLESIZE);
			
		}

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		w.write("\t\tif((" + exp1.generateCode() + "< 0) || (" + exp2.generateCode() + "< 0)){");
		w.newLine();
		w.write("\t\t\tSystem.out.println(\"No se puede generar una figura con dimensiones negativas.\");");
		w.newLine();
		w.write("\t\t\tSystem.exit(-1);");
		w.newLine();
		w.write("\t\t}");
		w.newLine();
		w.newLine();
		w.write("\t\tint [][] dibujo = new int [" + exp1.generateCode() + "] [" + exp2.generateCode() + "];");
		w.newLine();
		w.write("\t\tint [] pixels = new int[dibujo.length * dibujo[0].length];");
		w.newLine();
	}
}