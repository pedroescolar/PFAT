package AST;

import Errors.*;

public class Asign1 implements Asign{
	public String i;
	public Exp exp;

	public Asign1(String i, Exp exp){
		this.i = i;
		this.exp = exp;
	}
}