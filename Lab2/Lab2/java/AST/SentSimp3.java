package AST;

import Errors.*;
import Compiler.*;

public class SentSimp3 implements SentSimp{
	public final Repet repet;

	public SentSimp3(Repet repet){
		this.repet = repet;
	}

	public void computeTyp() throws CompilerExc{

		repet.computeTyp();

	}
}