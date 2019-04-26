package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Exp10 implements Exp{
	public double creal;

	public Exp10(double creal){
		this.creal = creal;
	}

	public int computeTyp() throws CompilerExc{

		return Typ.treal;

	}

	public String generateCode(){

		return "" + creal;

	}
}