package AST;

import Errors.*;
import Compiler.*;

public class Vdef2 implements Vdef{
	public Decl decl;
	public Vdef vdef;

	public Vdef2(Decl decl, Vdef vdef){
		this.decl = decl;
		this.vdef = vdef;
	}

	public void computeTyp() throws CompilerExc{

		decl.computeTyp();
		vdef.computeTyp();

	}
}