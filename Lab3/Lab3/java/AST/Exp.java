package AST;

import Errors.*;
import Compiler.*;
import java.io.*;

public interface Exp{

	public int computeTyp() throws CompilerExc;
	public String generateCode();

}

