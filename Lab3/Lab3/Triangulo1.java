import GeneratedCodeLib.*;
import java.util.*;

public class Triangulo1 {
	public static void main (String [] args) {

	BMP_Gen gen = new BMP_Gen();

		int numArg = 3;
		int ancho = 0;
		int alto = 0;
		int vertice = 0;
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
				vertice = Integer.parseInt(vals[2]);
			}
		}

		int i;
		i = 0;

		double a,b,c;

		a = 0.0;
		b = 0.0;
		c = 0.0;

		if((alto< 0) || (ancho< 0)){
			System.out.println("No se puede generar una figura con dimensiones negativas.");
			System.exit(-1);
		}

		int [][] dibujo = new int [alto] [ancho];
		int [] pixels = new int[dibujo.length * dibujo[0].length];

		if((!((vertice < 0) || (vertice > (ancho - 1))))){
			while(i < ancho){
			if(((dibujo.length) < 0) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[0][i] = 3;
				i = i + 1;

			}

			i = 2;

			a = (double)(alto) / (double)(vertice);

			b = (double)(alto) / ((double)(ancho) - (double)(vertice));

			c = b * (double)(ancho);

			if(((dibujo.length) < alto - 1) || ((dibujo[0].length) < vertice)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[alto - 1][vertice] = 3;
			while(i < vertice){
			if(((dibujo.length) < (int)((double)(i) * a)) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[(int)((double)(i) * a)][i] = 3;
				i = i + 2;

			}

			i = ancho - 2;

			while(i > vertice){
			if(((dibujo.length) < (int)(c - b * (double)(i))) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[(int)(c - b * (double)(i))][i] = 3;
				i = i - 2;

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
