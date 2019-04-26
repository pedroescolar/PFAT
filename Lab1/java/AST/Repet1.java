package AST;

import Errors.*;

public class Repet1 implements Repet{
	public Exp exp;
	public Sent sent;

	public Repet1(Exp exp, Sent sent){
		this.exp = exp;
		this.sent = sent;
	}
}