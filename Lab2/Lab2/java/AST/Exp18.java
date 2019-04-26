package AST;

import Errors.*;
import Compiler.*;

public class Exp18 implements Exp{
	public Exp exp1;
	public Exp exp2;

	public Exp18(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int computeTyp() throws CompilerExc{

		if ((exp1.computeTyp() == exp2.computeTyp()) && ((exp1.computeTyp() != Typ.treal) || (exp2.computeTyp() != Typ.treal))) {

			return Typ.tbool;
			
		}else{

			throw new TypExc(TypExc.INCOMPATIBLEIGUAL);

		}

	}
}