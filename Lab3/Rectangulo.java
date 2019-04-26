import GeneratedCodeLib.*;
import java.util.*;

public class Rectangulo {
	public static void main (String [] args) {

	BMP_Gen gen = new BMP_Gen();

		int numArg = 2;
		int ancho = 0;
		int alto = 0;
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
				ancho = Integer.parseInt(vals[0]);
				alto = Integer.parseInt(vals[1]);
			}
		}

		int i;

		i = 0;

		if((alto + 10< 0) || (ancho + 10< 0)){
			System.out.println("No se puede generar una figura con dimensiones negativas.");
			System.exit(-1);
		}

		int [][] dibujo = new int [alto + 10] [ancho + 10];
		int [] pixels = new int[dibujo.length * dibujo[0].length];

		while(i < ancho){
			if(((dibujo.length) < 5) || ((dibujo[0].length) < i + 5)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[5][i + 5] = 2;
			if(((dibujo.length) < (alto + 4)) || ((dibujo[0].length) < i + 5)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[(alto + 4)][i + 5] = 2;
			i = i + 1;

		}

		i = 0;

		while(i < alto){
			if(((dibujo.length) < i + 5) || ((dibujo[0].length) < 5)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[i + 5][5] = 2;
			if(((dibujo.length) < i + 5) || ((dibujo[0].length) < (ancho + 4))){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[i + 5][(ancho + 4)] = 2;
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
