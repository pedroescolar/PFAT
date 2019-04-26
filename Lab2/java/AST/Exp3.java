package AST;

import Errors.*;
import Compiler.*;

public class Exp3 implements Exp{
	public int cent;

	public Exp3(int cent){
		this.cent = cent;
	}

	public int computeTyp() throws CompilerExc{

		return Typ.tint;
	}
}