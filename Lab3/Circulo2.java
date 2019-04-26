import GeneratedCodeLib.*;
import java.util.*;

public class Circulo2 {
	public static void main (String [] args) {

	BMP_Gen gen = new BMP_Gen();



		int i;

		i = 0;

		if((410< 0) || (810< 0)){
			System.out.println("No se puede generar una figura con dimensiones negativas.");
			System.exit(-1);
		}

		int [][] dibujo = new int [410] [810];
		int [] pixels = new int[dibujo.length * dibujo[0].length];

		while(i < 2000){
			if(((dibujo.length) < 5 + (int)(200.0 * (1.0 + Math.cos((double)(i) * Math.PI / 1000.0)))) || ((dibujo[0].length) < 5 + (int)(400.0 * (1.0 + Math.sin((double)(i) * Math.PI / 1000.0))))){
			System.out.println("Los argumentos de la sentencia plot no están dentro del rango permitido.");
			System.exit(-1);
			}
			dibujo[5 + (int)(200.0 * (1.0 + Math.cos((double)(i) * Math.PI / 1000.0)))][5 + (int)(400.0 * (1.0 + Math.sin((double)(i) * Math.PI / 1000.0)))] = 1;
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
