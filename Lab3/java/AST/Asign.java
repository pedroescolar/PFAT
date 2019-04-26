package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Asign{
	public String i;
	public Exp exp;

	public Asign(String i, Exp exp){
		this.i = i;
		this.exp = exp;
	}

	public void computeTyp() throws CompilerExc{
		
		if (SymbolTable.getType(i) != exp.computeTyp()){

		 	throw new TypExc(TypExc.INCOMPATIBLETYPES);
		}
	}

	public void generateCode(BufferedWriter w, String tab) throws IOException{

		w.write(tab + i + " = "+ exp.generateCode() + ";");
		w.newLine();

	}

}