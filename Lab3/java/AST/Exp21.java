package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public class Exp21 implements Exp{

	public Exp21(){
		
	}

	public int computeTyp() throws CompilerExc{

		return Typ.treal;

	}

	public String generateCode(){

		return "Math.PI";

	}
}