package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Cond2 implements Cond{
	public Exp exp;
	public Sent sent1;
	public Sent sent2;

	public Cond2(Exp exp, Sent sent1, Sent sent2){
		this.exp = exp;
		this.sent1 = sent1;
		this.sent2 = sent2;
	}

	public void computeTyp() throws CompilerExc{

		if(exp.computeTyp() != Typ.tbool){

			throw new TypExc(TypExc.IFNOTBOOL); //La condición debe de ser bool
		}

		sent1.computeTyp();
		sent2.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		w.write(tab + "if(" + exp.generateCode() + "){");
		w.newLine();
		sent1.generateCode(w, tab + "\t");
		w.newLine();
		w.write(tab + "}else{");
		w.newLine();
		sent2.generateCode(w, tab + "\t");
		w.newLine();
		w.write(tab + "}");
		w.newLine();

	}
}