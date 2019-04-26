package AST;

import Errors.*;
import Compiler.*;

public class Inp1 implements Inp{
	public Lvar lvar;

	public Inp1(Lvar lvar){
		this.lvar = lvar;
	}

	public void computeTyp(int tipo) throws CompilerExc{
		lvar.computeTyp(tipo);
	}
}