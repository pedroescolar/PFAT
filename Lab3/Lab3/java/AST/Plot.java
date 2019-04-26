package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Plot{
	public String color;
	public Exp exp1;
	public Exp exp2;

	public Plot(String color, Exp exp1, Exp exp2){
		this.color = color;
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public int parseColor(String color){

		int pintar = 0; 

		switch(color){
			case "white": 
				pintar = 0;
			break;
			case "grey":
				pintar = 1;
			break;
			case "black":
				pintar = 2;
			break;
			case "red":
				pintar = 3;
			break;
			case "green":
				pintar = 4;
			break;
			case "blue":
				pintar = 5;
			break;
			case "yellow":
				pintar = 6;
			break;
		}

		return pintar;
	}

	public void computeTyp() throws CompilerExc{

		if ((exp1.computeTyp() != Typ.tint) || (exp2.computeTyp() != Typ.tint)) {

			throw new TypExc(TypExc.INCOMPATIBLEPLOT);

		}

	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		w.write("\t\t\tif(((dibujo.length) < " + exp2.generateCode() + ") || ((dibujo[0].length) < " + exp1.generateCode() + ")){");
		w.newLine();
		w.write("\t\t\tSystem.out.println(\"Los argumentos de la sentencia plot no están dentro del rango permitido.\");");
		w.newLine();
		w.write("\t\t\tSystem.exit(-1);");
		w.newLine();
		w.write("\t\t\t}");
		w.newLine();

		int pintar = parseColor(color);

		w.write("\t\t\tdibujo[" + exp2.generateCode() + "][" + exp1.generateCode() + "] = " + pintar + ";");

	}
}