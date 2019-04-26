package Compiler;

public class Typ{
	public static final int tint = 1;
	public static final int tbool = 2;
	public static final int treal = 3;

	public static String typToString(int typ){

		if (typ == tint) {

			return "int";
			
		}else if (typ == tbool) {

			return "boolean";
			
		}else if (typ == treal) {
			
			return "double";

		}else{

			return "ERROR: tipo de datos inexistente";
		}
	}

}