package Errors;

public class DoubleDefExc extends CompilerExc{

	private String msg;

	public DoubleDefExc(String s){

		msg = "Declaración doble de la variable " + s + "\n";
	}

	public String toString(){

		return msg;
	}
}