package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Inp1 implements Inp{
	public Lvar lvar;

	public Inp1(Lvar lvar){
		this.lvar = lvar;
	}

	public void computeTyp(int tipo) throws CompilerExc{
		lvar.computeTyp(tipo);
	}

	public String generateCode() throws IOException{

		return lvar.generateCode();

	}
}