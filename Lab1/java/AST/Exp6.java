package AST;

import Errors.*;

public class Exp6 implements Exp{
	public Exp exp1;
	public Exp exp2;

	public Exp6(Exp exp1, Exp exp2){
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
}