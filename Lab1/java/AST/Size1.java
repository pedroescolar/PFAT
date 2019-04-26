package AST;

import Errors.*;

public class Size1 implements Size{
	public Exp exp1;
	public Exp exp2;

	public Size1(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
}