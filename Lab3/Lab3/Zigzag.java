import GeneratedCodeLib.*;
import java.util.*;

public class Zigzag {
	public static void main (String [] args) {

	BMP_Gen gen = new BMP_Gen();

		int numArg = 1;
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
				alto = Integer.parseInt(vals[0]);
			}
		}

		int i,j,delta;
		i = 0;
		j = 0;
		delta = 0;

		boolean control;

		control = false;

		if((alto< 0) || (200< 0)){
			System.out.println("No se puede generar una figura con dimensiones negativas.");
			System.exit(-1);
		}

		int [][] dibujo = new int [alto] [200];
		int [] pixels = new int[dibujo.length * dibujo[0].length];

		control = true;

		delta = 4;

		if((alto < 1)){
			control = false;

		}

		while(control){
			while(control && (j < 180)){
			if(((dibujo.length) < i) || ((dibujo[0].length) < j + 10)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[i][j + 10] = 2;
				i = i + 1;

				if(((i == alto))){
					control = false;

				}

				j = j + delta;

			}

			delta = -delta;

			j = j + delta;

			i = i - 1;

			while(control && (j > 0)){
			if(((dibujo.length) < i) || ((dibujo[0].length) < j + 10)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[i][j + 10] = 2;
				i = i + 1;

				if(((i == alto))){
					control = false;

				}

				j = j + delta;

			}

			delta = -delta;

			j = j + delta;

			i = i - 1;

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
