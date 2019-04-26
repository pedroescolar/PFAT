package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class SentSimp2 implements SentSimp{
	public Cond cond;

	public SentSimp2(Cond cond){
		this.cond = cond;
	}

	public void computeTyp() throws CompilerExc{

		cond.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		cond.generateCode(w, tab);

	}
}