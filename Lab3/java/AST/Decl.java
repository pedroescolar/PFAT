package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Decl{
	public int tipo;
	public Lvar lvar;

	public Decl(int tipo, Lvar lvar){
		this.tipo = tipo;
		this.lvar = lvar;
	}

	public void computeTyp() throws CompilerExc{

		lvar.computeTyp(tipo);	//Nueva variable de tipo "tipo"
	}

	public String generateCode(BufferedWriter w, String tab) throws IOException{

		w.write(tab + Typ.typToString(tipo) + " " + lvar.generateCode() + ";");

		return Typ.typToString(tipo) + " " + lvar.generateCode();

	}
}