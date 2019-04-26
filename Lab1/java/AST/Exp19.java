package AST;

import Errors.*;

public class Exp19 implements Exp{
	public Exp exp1;
	public Exp exp2;

	public Exp19(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
}