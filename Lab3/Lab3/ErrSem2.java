import GeneratedCodeLib.*;
import java.util.*;

public class ErrSem2 {
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

		int i,j;
		i = 0;
		j = 0;

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
			dibujo[0][i] = 2;
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
			dibujo[alto - 1][vertice] = 2;
			while(i < (ancho - 1)){
				j = 1;

				while(j < (alto - 1)){
					if(((i == vertice))){
			if(((dibujo.length) < j) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[j][i] = 2;
					}else{
						if((i < vertice)){
							if(((j < (int)((double)(i) * a)) || ((j == (int)((double)(i) * a))))){
			if(((dibujo.length) < j) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[j][i] = 2;
							}

						}else{
							if(((j < (int)(c - b * (double)(i))) || ((j == (int)(c - b * (double)(i)))))){
			if(((dibujo.length) < j) || ((dibujo[0].length) < i)){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[j][i] = 2;
							}

						}

					}

					j = j + 1;

				}

				i = i + 1;

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
