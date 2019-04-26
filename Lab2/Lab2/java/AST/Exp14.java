package AST;

import Errors.*;
import Compiler.*;

public class Exp14 implements Exp{
	public boolean clog;

	public Exp14(boolean clog){
		this.clog = clog;
	}

	public int computeTyp() throws CompilerExc{

		return Typ.tbool;

	}
}