package AST;

import Errors.*;

public class Lvar2 implements Lvar{
	public String i;
	public Lvar lvar;

	public Lvar2(String i, Lvar lvar){
		this.i = i;
		this.lvar = lvar;
	}
}