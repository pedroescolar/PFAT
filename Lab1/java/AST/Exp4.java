package AST;

import Errors.*;

public class Exp4 implements Exp{
	public Exp exp1;
	public Exp exp2;

	public Exp4(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
}