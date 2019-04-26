package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Lvar2 implements Lvar{
	public String i;
	public Lvar lvar;

	public Lvar2(String i, Lvar lvar){
		this.i = i;
		this.lvar = lvar;
	}

	public void computeTyp(int tipo) throws CompilerExc{

		SymbolTable.newEntry(i, tipo);

		lvar.computeTyp(tipo);

	}

	public String generateCode(){

		return i + "," + lvar.generateCode();

	}
}