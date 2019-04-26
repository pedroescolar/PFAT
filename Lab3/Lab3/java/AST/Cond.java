package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public interface Cond{


	public void computeTyp() throws CompilerExc;
	public void generateCode(BufferedWriter w, String tab) throws IOException;
	
}

