package AST;

import Errors.*;
import Compiler.*;

//Opuesto de un número

public class Exp8 implements Exp{
	public Exp exp;

	public Exp8(Exp exp){
		this.exp = exp;
	}

	public int computeTyp() throws CompilerExc{

		if((exp.computeTyp() == Typ.tint)){

			return Typ.tint;

		}else if((exp.computeTyp() == Typ.treal)){

			return Typ.treal;

		}else{

			throw new TypExc(TypExc.UMENOS);
			
		}
	}

}