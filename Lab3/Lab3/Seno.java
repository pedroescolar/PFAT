import GeneratedCodeLib.*;
import java.util.*;

public class Seno {
	public static void main (String [] args) {

	BMP_Gen gen = new BMP_Gen();

		int numArg = 2;
		int ancho = 0;
		int color = 0;
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
				color = Integer.parseInt(vals[1]);
			}
		}

		int i,j,color2;

		i = 0;
		j = 0;
		color2 = 0;

		if((210< 0) || (ancho< 0)){
			System.out.println("No se puede generar una figura con dimensiones negativas.");
			System.exit(-1);
		}

		int [][] dibujo = new int [210] [ancho];
		int [] pixels = new int[dibujo.length * dibujo[0].length];

		j = 10;

		color2 = color;

		if(((color == 7))){
			color2 = 1;

		}

		while(i < ancho * j){
			if(((color2 == 1))){
			if(((dibujo.length) < 5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))) || ((dibujo[0].length) < i / j)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))][i / j] = 2;
			}

			if(((color2 == 2))){
			if(((dibujo.length) < 5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))) || ((dibujo[0].length) < i / j)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))][i / j] = 1;
			}

			if(((color2 == 3))){
			if(((dibujo.length) < 5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))) || ((dibujo[0].length) < i / j)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))][i / j] = 5;
			}

			if(((color2 == 4))){
			if(((dibujo.length) < 5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))) || ((dibujo[0].length) < i / j)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))][i / j] = 3;
			}

			if(((color2 == 5))){
			if(((dibujo.length) < 5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))) || ((dibujo[0].length) < i / j)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))][i / j] = 4;
			}

			if(((color2 == 6))){
			if(((dibujo.length) < 5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))) || ((dibujo[0].length) < i / j)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[5 + (int)(100.0 * (1.0 + Math.sin(Math.PI * (double)(i) / ((double)(j) * 40.0))))][i / j] = 6;
			}

			i = i + 1;

			if(((color == 7) && (200 * (i / 200) == i))){
				if((color2 == 6)){
					color2 = 1;

				}else{
					color2 = color2 + 1;

				}

			}

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
