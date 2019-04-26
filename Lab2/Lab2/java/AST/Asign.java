package AST;

import Errors.*;
import Compiler.*;

public class Asign{
	public String i;
	public Exp exp;

	public Asign(String i, Exp exp){
		this.i = i;
		this.exp = exp;
	}

	public void computeTyp() throws CompilerExc{
		
		if (SymbolTable.getType(i) != exp.computeTyp()){

		 	throw new TypExc(TypExc.INCOMPATIBLETYPES);
		}
	}

}