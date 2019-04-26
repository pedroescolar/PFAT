import GeneratedCodeLib.*;
import java.util.*;

public class Diagonal2 {
	public static void main (String [] args) {

	BMP_Gen gen = new BMP_Gen();

		int numArg = 1;
		int lado = 0;
		if (args != null){
			String [] vals = new String[numArg];
			for(int i = 0; i < numArg; i++){
				vals[i] = "";
			}
			if(numArg > args.length){
				for(int i = 0; i < args.length; i++){
					vals[i] = args[i];
				}
			}else{
				for(int i = 0; i < numArg; i++){
					vals[i] = args[i];
				}
				lado = Integer.parseInt(vals[0]);
			}
		}

		int i;

		i = 0;

		if((lado< 0) || (lado< 0)){
			System.out.println("No se puede generar una figura con dimensiones negativas.");
			System.exit(-1);
		}

		int [][] dibujo = new int [lado] [lado];
		int [] pixels = new int[dibujo.length * dibujo[0].length];

		while(i < lado){
			if(((dibujo.length) < lado - (i + 1)) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[lado - (i + 1)][i] = 2;
			i = i + 1;

		}

		int cont = 0;
		for(int filas = (dibujo.length - 1); filas >= 0; filas--){
			for(int columnas = 0; columnas < dibujo[filas].length; columnas++){
				pixels[cont] = dibujo[filas][columnas];
				cont++;
			}
		}

		gen.map2BMP(dibujo.length, dibujo[0].length, pixels, args[args.length - 1]);
	}
}
