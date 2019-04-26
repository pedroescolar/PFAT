package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Lvar1 implements Lvar{
	public String i;

	public Lvar1(String i){
		this.i = i;
	}

	public void computeTyp(int tipo) throws CompilerExc{

		SymbolTable.newEntry(i, tipo);

	}

	public String generateCode(){

		return i;

	}
}