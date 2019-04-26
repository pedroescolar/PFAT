package AST;

import Errors.*;
import Compiler.*;

public class Sent2 implements Sent{
	public SentSimp sentsimp;

	public Sent2(SentSimp sentsimp){
		this.sentsimp = sentsimp;
	}

	public void computeTyp() throws CompilerExc{

		sentsimp.computeTyp();

	}
}