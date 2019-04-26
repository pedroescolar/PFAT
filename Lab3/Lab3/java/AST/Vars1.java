package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Vars1 implements Vars{
	public Vdef vdef;

	public Vars1(Vdef vdef){
		this.vdef = vdef;
	}

	public void computeTyp() throws CompilerExc{

		vdef.computeTyp();

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		vdef.generateCode(w, tab);

	}
}