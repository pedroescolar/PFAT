package AST;

import Errors.*;
import Compiler.*;

public class Vdef1 implements Vdef{
	public Decl decl;

	public Vdef1(Decl decl){
		this.decl = decl;
	}

	public void computeTyp() throws CompilerExc{

		decl.computeTyp();

	}
}