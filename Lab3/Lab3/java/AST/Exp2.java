package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Exp2 implements Exp{
	public Exp exp;

	public Exp2(Exp exp){
		this.exp = exp;
	}

	public int computeTyp() throws CompilerExc{

		return exp.computeTyp();
	}

	public String generateCode(){

		return "(" + exp.generateCode() + ")";

	}
}