package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Sent2 implements Sent{
	public SentSimp sentsimp;

	public Sent2(SentSimp sentsimp){
		this.sentsimp = sentsimp;
	}

	public void computeTyp() throws CompilerExc{

		sentsimp.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		sentsimp.generateCode(w, tab);

	}
}