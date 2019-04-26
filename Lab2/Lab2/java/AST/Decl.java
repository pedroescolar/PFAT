package AST;

import Errors.*;
import Compiler.*;

public class Decl{
	public int tipo;
	public Lvar lvar;

	public Decl(int tipo, Lvar lvar){
		this.tipo = tipo;
		this.lvar = lvar;
	}

	public void computeTyp() throws CompilerExc{

		lvar.computeTyp(tipo);	//Nueva variable de tipo "tipo"
	}
}