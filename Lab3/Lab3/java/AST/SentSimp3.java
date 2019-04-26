package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class SentSimp3 implements SentSimp{
	public final Repet repet;

	public SentSimp3(Repet repet){
		this.repet = repet;
	}

	public void computeTyp() throws CompilerExc{

		repet.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		repet.generateCode(w, tab);

	}
}