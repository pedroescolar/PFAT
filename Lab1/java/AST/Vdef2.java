package AST;

import Errors.*;

public class Vdef2 implements Vdef{
	public Decl decl;
	public Vdef vdef;

	public Vdef2(Decl decl, Vdef vdef){
		this.decl = decl;
		this.vdef = vdef;
	}
}