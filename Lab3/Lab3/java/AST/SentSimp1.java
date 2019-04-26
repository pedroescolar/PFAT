package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class SentSimp1 implements SentSimp{
	public Asign asign;

	public SentSimp1(Asign asign){
		this.asign = asign;
	}

	public void computeTyp() throws CompilerExc{

		asign.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		asign.generateCode(w, tab);

	}
}