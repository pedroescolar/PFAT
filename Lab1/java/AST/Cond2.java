package AST;

import Errors.*;

public class Cond2 implements Cond{
	public Exp exp;
	public Sent sent1;
	public Sent sent2;

	public Cond2(Exp exp, Sent sent1, Sent sent2){
		this.exp = exp;
		this.sent1 = sent1;
		this.sent2 = sent2;
	}
}