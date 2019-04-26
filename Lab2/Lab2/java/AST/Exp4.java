package AST;

import Errors.*;
import Compiler.*;

public class Exp4 implements Exp{
	public Exp exp1;
	public Exp exp2;

	public Exp4(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int computeTyp() throws CompilerExc{

		if((exp1.computeTyp() == Typ.tint) && (exp2.computeTyp() == Typ.tint)){
			
			return Typ.tint;

		}else if((exp1.computeTyp() == Typ.treal) && (exp2.computeTyp() == Typ.treal)){

			return Typ.treal;

		}else{

			throw new TypExc(TypExc.INCOMPATIBLESUM);
		} 
	}
}