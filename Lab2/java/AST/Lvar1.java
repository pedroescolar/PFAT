package AST;

import Errors.*;
import Compiler.*;

public class Lvar1 implements Lvar{
	public String i;

	public Lvar1(String i){
		this.i = i;
	}

	public void computeTyp(int tipo) throws CompilerExc{

		SymbolTable.newEntry(i, tipo);

	}
}