package AST;

import Errors.*;
import Compiler.*;

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
}