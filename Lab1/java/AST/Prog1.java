package AST;

import Errors.*;

public class Prog1 implements Prog{
	public String i;
	public Inp inp;
	public Vars vars;
	public Size size;
	public Sent sent;

	public Prog1(String i, Inp inp, Vars vars, Size size, Sent sent){
		this.i = i;
		this.inp = inp;
		this.vars = vars;
		this.size = size;
		this.sent = sent;
	}
}