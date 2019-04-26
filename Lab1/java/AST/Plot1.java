package AST;

import Errors.*;

public class Plot1 implements Plot{
	public String color;
	public Exp exp1;
	public Exp exp2;

	public Plot1(String color, Exp exp1, Exp exp2){
		this.color = color;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}
}