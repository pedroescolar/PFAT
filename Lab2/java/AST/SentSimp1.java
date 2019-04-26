package AST;

import Errors.*;
import Compiler.*;

public class SentSimp1 implements SentSimp{
	public Asign asign;

	public SentSimp1(Asign asign){
		this.asign = asign;
	}

	public void computeTyp() throws CompilerExc{

		asign.computeTyp();

	}
}