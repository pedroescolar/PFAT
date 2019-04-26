package Errors;

public class VarNoDefExc extends CompilerExc{

	private String msg;

	public VarNoDefExc(String s){

		msg = "Variable " + s +" no esta declarada. \n";
	}

	public String toString(){

		return msg;
	}
}