package AST;

import Errors.*;
import Compiler.*;

public class Exp17 implements Exp{
	public Exp exp;

	public Exp17(Exp exp){
		this.exp = exp;
	}

	public int computeTyp() throws CompilerExc{

		if (exp.computeTyp() == Typ.tbool) {

			return Typ.tbool;
			
		}else{

			throw new TypExc(TypExc.INCOMPATIBLENOT);

		}

	}
}