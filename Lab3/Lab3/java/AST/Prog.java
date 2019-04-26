package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Prog{
	public String i;
	public Inp inp;
	public Vars vars;
	public Size size;
	public Sent sent;

	public Prog(String i, Inp inp, Vars vars, Size size, Sent sent){
		this.i = i;
		this.inp = inp;
		this.vars = vars;
		this.size = size;
		this.sent = sent;
	}

	public void computeTyp() throws CompilerExc{

		inp.computeTyp(Typ.tint);
		vars.computeTyp();
		size.computeTyp();
		sent.computeTyp();


	}

	public void generateCode(BufferedWriter w) throws IOException{

		final String vacio ="\"\"";

		w.write("\tpublic static void main (String [] args) {");
		w.newLine();
		w.newLine();
		w.write("\tBMP_Gen gen = new BMP_Gen();");
      	w.newLine();
      	w.newLine();
      	String variables = inp.generateCode();
      	if(!(variables.equals(""))){
			String vector[] = variables.split(",");
			w.write("\t\tint numArg = " + vector.length + ";");
			w.newLine();

			for (int i = 0; i < vector.length; i++) {

				w.write("\t\tint " + vector[i] + " = 0;");
				w.newLine();
				
			}

			w.write("\t\tif (args != null){");
			w.newLine();
			w.write("\t\t\tString [] vals = new String[numArg];");
			w.newLine();
			w.write("\t\t\tfor(int i = 0; i < numArg; i++){");
			w.newLine();
			w.write("\t\t\t\tvals[i] = " + vacio + ";");
			w.newLine();
			w.write("\t\t\t}");
			w.newLine();
			w.write("\t\t\tif(numArg > args.length){");
			w.newLine();
			w.write("\t\t\t\tfor(int i = 0; i < args.length; i++){");
			w.newLine();
			w.write("\t\t\t\t\tvals[i] = args[i];");
			w.newLine();
			w.write("\t\t\t\t}");
			w.newLine();
			w.write("\t\t\t}else{");
			w.newLine();
			w.write("\t\t\t\tfor(int i = 0; i < numArg; i++){");
			w.newLine();
			w.write("\t\t\t\t\tvals[i] = args[i];");
			w.newLine();
			w.write("\t\t\t\t}");
			w.newLine();
			for (int j = 0; j < vector.length; j++) {

				w.write("\t\t\t\t" + vector[j] + " = Integer.parseInt(vals[" + j + "]);");
				w.newLine();
				
			}
			w.write("\t\t\t}");
			w.newLine();
			w.write("\t\t}");
		}

		w.newLine();
		w.newLine();
		vars.generateCode(w, "\t\t");
		w.newLine();
		size.generateCode(w, "\t\t");
		w.newLine();
		sent.generateCode(w, "\t\t");
		w.newLine();
		w.write("\t\tint cont = 0;");
		w.newLine();
		w.write("\t\tfor(int filas = (dibujo.length - 1); filas >= 0; filas--){");
		w.newLine();
		w.write("\t\t\tfor(int columnas = 0; columnas < dibujo[filas].length; columnas++){");
		w.newLine();
		w.write("\t\t\t\tpixels[cont] = dibujo[filas][columnas];");
		w.newLine();
		w.write("\t\t\t\tcont++;");
		w.newLine();
		w.write("\t\t\t}");
		w.newLine();
		w.write("\t\t}");
		w.newLine();
		w.newLine();
		w.write("\t\tgen.map2BMP(dibujo.length, dibujo[0].length, pixels, args[args.length - 1]);");
		w.newLine();
		w.write("\t}");


	}
}