package AST;

import Errors.*;
import Compiler.*;

public class Vars1 implements Vars{
	public Vdef vdef;

	public Vars1(Vdef vdef){
		this.vdef = vdef;
	}

	public void computeTyp() throws CompilerExc{

		vdef.computeTyp();

	}
}