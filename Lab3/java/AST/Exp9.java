package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Exp9 implements Exp{
	public Exp exp;

	public Exp9(Exp exp){
		this.exp = exp;
	}

	public int computeTyp() throws CompilerExc{

		if (exp.computeTyp() == Typ.treal) {

			return Typ.tint;
			
		}else{

			throw new TypExc(TypExc.REALTOINT);
		}

	}

	public String generateCode(){

		return "(int)(" + exp.generateCode() + ")";

	}
}