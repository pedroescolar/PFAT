package AST;

import Errors.*;
import Compiler.*;

public class Exp11 implements Exp{
	public Exp exp;

	public Exp11(Exp exp){
		this.exp = exp;
	}

	public int computeTyp() throws CompilerExc{

		if (exp.computeTyp() == Typ.tint) {

			return Typ.treal;
			
		}else{

			throw new TypExc(TypExc.INTTOREAL);
		}

	}
}