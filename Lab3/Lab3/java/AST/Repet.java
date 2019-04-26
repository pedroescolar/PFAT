package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Repet{
	public Exp exp;
	public Sent sent;

	public Repet(Exp exp, Sent sent){
		this.exp = exp;
		this.sent = sent;
	}

	public void computeTyp() throws CompilerExc{

		if (exp.computeTyp() != Typ.tbool) {

			throw new TypExc(TypExc.INCOMPATIBLEREPET);
			
		}

		sent.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		w.write(tab + "while" + exp.generateCode() + "{");
		w.newLine();
		sent.generateCode(w, tab + "\t");
		w.newLine();
		w.write(tab + "}");
		w.newLine();

	}
}