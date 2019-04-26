package AST;

import Errors.*;
import Compiler.*;

public class Cond1 implements Cond{
	public Exp exp;
	public Sent sent;

	public Cond1(Exp exp, Sent sent){
		this.exp = exp;
		this.sent = sent;
	}

	public void computeTyp() throws CompilerExc{

			if(exp.computeTyp() != Typ.tbool){

				throw new TypExc(TypExc.IFNOTBOOL);
			}

			sent.computeTyp();
	}
}