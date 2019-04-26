package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Exp15 implements Exp{
	public Exp exp1;
	public Exp exp2;

	public Exp15(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int computeTyp() throws CompilerExc{

		if ((exp1.computeTyp() == Typ.tbool) && (exp2.computeTyp() == Typ.tbool)) {

			return Typ.tbool;
			
		}else{

			throw new TypExc(TypExc.INCOMPATIBLEAND);

		}

	}

	public String generateCode(){

		return exp1.generateCode() + " && " + exp2.generateCode();

	}
}