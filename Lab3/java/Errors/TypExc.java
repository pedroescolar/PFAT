package Errors;

public class TypExc extends CompilerExc{

	public static final int INCOMPATIBLETYPES = 0;
	public static final int IFNOTBOOL = 1;
	public static final int INCOMPATIBLESUM = 2;
	public static final int INCOMPATIBLEMINUS = 3;
	public static final int INCOMPATIBLEMULT = 4;
	public static final int INCOMPATIBLEDIV = 5;
	public static final int UMENOS = 6;
	public static final int REALTOINT = 7;
	public static final int INTTOREAL = 8;
	public static final int REALSIN = 9;
	public static final int REALCOS = 10;
	public static final int INCOMPATIBLEAND = 11;
	public static final int INCOMPATIBLEOR = 12;
	public static final int INCOMPATIBLENOT = 13;
	public static final int INCOMPATIBLEIGUAL = 14;
	public static final int INCOMPATIBLEMENOR = 15;
	public static final int INCOMPATIBLEMAYOR = 16;
	public static final int INCOMPATIBLEPLOT = 17;
	public static final int INCOMPATIBLEREPET = 18;
	public static final int INCOMPATIBLESIZE = 19;


	public TypExc(int err){

		switch(err){

			case 0:

				System.out.println("ERROR SEMÁNTICO: asignación de tipos incompatibles.");

				break;

			case 1: 
				
				System.out.println("ERROR SEMÁNTICO: se espera tipo bool en condición (if).");

				break;

			case 2:
				
				System.out.println("ERROR SEMÁNTICO: tipo incompatible para suma.");

				break;

			case 3:
				
				System.out.println("ERROR SEMÁNTICO: tipo incompatible para resta.");

				break;

			case 4:
				
				System.out.println("ERROR SEMÁNTICO: tipo incompatible para multiplicación.");

				break;

			case 5:
				
				System.out.println("ERROR SEMÁNTICO: tipo incompatible para división.");

				break;	

			case 6:
				
				System.out.println("ERROR SEMÁNTICO: solo se puede obtener el opuesto de un int o un real.");

				break;

			case 7:

				System.out.println("ERROR SEMÁNTICO: no es de tipo real para poder pasarlo a int.");

				break;

			case 8:

				System.out.println("ERROR SEMÁNTICO: no es de tipo int para poder pasarlo a real.");

				break;

			case 9:

				System.out.println("ERROR SEMÁNTICO: parámetro ha de ser de tipo real para poder calcular el seno.");

				break;

			case 10:

				System.out.println("ERROR SEMÁNTICO: parámetro ha de ser de tipo real para poder calcular el coseno.");

				break;

			case 11:

				System.out.println("ERROR SEMÁNTICO: expresión lógica AND ha de ser entre variables de tipo bool.");

				break;

			case 12:

				System.out.println("ERROR SEMÁNTICO: expresión lógica OR ha de ser entre variables de tipo bool.");

				break;

			case 13:

				System.out.println("ERROR SEMÁNTICO: expresión lógica NOT ha de ser entre variables de tipo bool.");

				break;

			case 14:

				System.out.println("ERROR SEMÁNTICO: expresión lógica IGUAL QUE ha de ser entre variables de tipo int o real.");

				break;

			case 15:

				System.out.println("ERROR SEMÁNTICO: expresión lógica MENOR QUE ha de ser entre variables de tipo int o real.");

				break;

			case 16:

				System.out.println("ERROR SEMÁNTICO: expresión lógica MAYOR QUE ha de ser entre variables de tipo int o real.");

				break;

			case 17:

				System.out.println("ERROR SEMÁNTICO: los dos últimos parámetros de plot han de ser de tipo int.");

				break;

			case 18:

				System.out.println("ERROR SEMÁNTICO: la expresión ha de ser de tipo bool.");

				break;

			case 19:

				System.out.println("ERROR SEMÁNTICO: los parámetros de size han de ser de tipo int.");

				break;

		}
	}
}