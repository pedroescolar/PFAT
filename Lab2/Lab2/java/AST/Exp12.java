package AST;

import Errors.*;
import Compiler.*;

public class Exp12 implements Exp{
	public Exp exp;

	public Exp12(Exp exp){
		this.exp = exp;
	}

	public int computeTyp() throws CompilerExc{

		if (exp.computeTyp() == Typ.treal) {

			return Typ.treal;
			
		}else{

			throw new TypExc(TypExc.REALSIN);

		}

	}
}