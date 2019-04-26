package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public interface Vars{

	public void computeTyp() throws CompilerExc;
	public void generateCode(BufferedWriter w, String tab) throws IOException;
}

