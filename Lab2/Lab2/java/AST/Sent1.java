package AST;

import Errors.*;
import Compiler.*;

public class Sent1 implements Sent{
	public SentSimp sentsimp;
	public Sent sent;

	public Sent1(SentSimp sentsimp, Sent sent){
		this.sentsimp = sentsimp;
		this.sent = sent;
	}

	public void computeTyp() throws CompilerExc{

		sentsimp.computeTyp();
		sent.computeTyp();

	}
}