package Compiler;

public class Typ{
	public static final int tint = 1;
	public static final int tbool = 2;
	public static final int treal = 3;

	public static String typToString(int typ){

		if (typ == tint) {

			return "int";
			
		}else if (typ == tbool) {

			return "bool";
			
		}else if (typ == treal) {
			
			return "real";

		}else{

			return "ERROR: tipo de datos inexistente (int, bool o real)";
		}
	}

}