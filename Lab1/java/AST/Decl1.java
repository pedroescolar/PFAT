package AST;

import Errors.*;

public class Decl1 implements Decl{
	public int tipo;
	public Lvar lvar;

	public Decl1(int tipo, Lvar lvar){
		this.tipo = tipo;
		this.lvar = lvar;
	}
}