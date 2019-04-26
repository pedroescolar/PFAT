package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public interface Inp{

	public void computeTyp(int tipo) throws CompilerExc;
	public String generateCode() throws IOException;

}

