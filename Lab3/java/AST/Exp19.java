package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Exp19 implements Exp{
	public Exp exp1;
	public Exp exp2;

	public Exp19(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int computeTyp() throws CompilerExc{

		if ((exp1.computeTyp() == Typ.tint) && (exp2.computeTyp() == Typ.tint)) {

			return Typ.tbool;
			
		}else if ((exp1.computeTyp() == Typ.treal) && (exp2.computeTyp() == Typ.treal)) {
			
			return Typ.tbool;

		}else{

			throw new TypExc(TypExc.INCOMPATIBLEMENOR);

		}
	}

	public String generateCode(){

		return exp1.generateCode() + " < " + exp2.generateCode();

	}
}