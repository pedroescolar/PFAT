package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Exp3 implements Exp{
	public int cent;

	public Exp3(int cent){
		this.cent = cent;
	}

	public int computeTyp() throws CompilerExc{

		return Typ.tint;
	}

	public String generateCode(){

		return "" + cent;

	}
}