package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Exp1 implements Exp{
	public String i;

	public Exp1(String i){
		this.i = i;
	}

	public int computeTyp() throws CompilerExc{

		return SymbolTable.getType(i);	// Se comprueba que este declarada la variable
	}

	public String generateCode(){

		return i;

	}
}