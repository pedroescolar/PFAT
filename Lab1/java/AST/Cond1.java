package AST;

import Errors.*;

public class Cond1 implements Cond{
	public Exp exp;
	public Sent sent;

	public Cond1(Exp exp, Sent sent){
		this.exp = exp;
		this.sent = sent;
	}
}