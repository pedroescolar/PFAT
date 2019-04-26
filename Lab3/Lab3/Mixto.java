import GeneratedCodeLib.*;
import java.util.*;

public class Mixto {
	public static void main (String [] args) {

	BMP_Gen gen = new BMP_Gen();



		int i,j;
		i = 0;
		j = 0;

		int ancho,alto,vertice;
		ancho = 0;
		alto = 0;
		vertice = 0;

		double a,b,c;

		a = 0.0;
		b = 0.0;
		c = 0.0;

		if((400< 0) || (410< 0)){
			System.out.println("No se puede generar una figura con dimensiones negativas.");
			System.exit(-1);
		}

		int [][] dibujo = new int [400] [410];
		int [] pixels = new int[dibujo.length * dibujo[0].length];

		ancho = 400;

		alto = 300;

		vertice = 200;

		if((!((vertice < 0) || (vertice > (ancho - 1))))){
			while(i < ancho){
			if(((dibujo.length) < 0) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[0][i] = 4;
				i = i + 1;

			}

			i = 1;

			a = (double)(alto) / (double)(vertice);

			b = (double)(alto) / ((double)(ancho) - (double)(vertice));

			c = b * (double)(ancho);

			if(((dibujo.length) < alto - 1) || ((dibujo[0].length) < vertice)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[alto - 1][vertice] = 4;
			while(i < (ancho - 1)){
				j = 1;

				while(j < (alto - 1)){
					if(((i == vertice))){
			if(((dibujo.length) < j) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[j][i] = 4;
					}else{
						if((i < vertice)){
							if(((j < (int)((double)(i) * a)) || ((j == (int)((double)(i) * a))))){
			if(((dibujo.length) < j) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[j][i] = 4;
							}

						}else{
							if(((j < (int)(c - b * (double)(i))) || ((j == (int)(c - b * (double)(i)))))){
			if(((dibujo.length) < j) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[j][i] = 4;
							}

						}

					}

					j = j + 1;

				}

				i = i + 1;

			}

		}

		alto = 200;

		i = 5;

		while(i < ancho){
			if(((dibujo.length) < alto - 1) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[alto - 1][i] = 5;
			if(((dibujo.length) < 40) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[40][i] = 5;
			i = i + 1;

		}

		i = 40;

		while(i < alto){
			if(((dibujo.length) < i) || ((dibujo[0].length) < 5)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[i][5] = 5;
			if(((dibujo.length) < i) || ((dibujo[0].length) < (ancho - 1))){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[i][(ancho - 1)] = 5;
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
