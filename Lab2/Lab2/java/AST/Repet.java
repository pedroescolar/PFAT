package AST;

import Errors.*;
import Compiler.*;

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
}