package AST;

import Errors.*;
import Compiler.*;

public class Prog{
	public String i;
	public Inp inp;
	public Vars vars;
	public Size size;
	public Sent sent;

	public Prog(String i, Inp inp, Vars vars, Size size, Sent sent){
		this.i = i;
		this.inp = inp;
		this.vars = vars;
		this.size = size;
		this.sent = sent;
	}

	public void computeTyp() throws CompilerExc{

		inp.computeTyp(Typ.tint);
		vars.computeTyp();
		size.computeTyp();
		sent.computeTyp();


	}
}