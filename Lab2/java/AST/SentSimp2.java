package AST;

import Errors.*;
import Compiler.*;

public class SentSimp2 implements SentSimp{
	public Cond cond;

	public SentSimp2(Cond cond){
		this.cond = cond;
	}

	public void computeTyp() throws CompilerExc{

		cond.computeTyp();

	}
}