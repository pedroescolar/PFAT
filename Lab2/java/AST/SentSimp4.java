package AST;

import Errors.*;
import Compiler.*;

public class SentSimp4 implements SentSimp{
	public Plot plot;

	public SentSimp4(Plot plot){
		this.plot = plot;
	}

	public void computeTyp() throws CompilerExc{

		plot.computeTyp();

	}
}