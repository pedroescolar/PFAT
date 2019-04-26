package Compiler;

import java.util.Vector;
import Errors.*;

public class SymbolTable{
	private static Vector <TableEntry> table = new Vector <TableEntry>();

	public static void newEntry(String name, int type)throws DoubleDefExc{
		TableEntry e = search(name);
		if (e == null) {
			
			e = new TableEntry(name, type);
			table.add(e);
		}else throw new DoubleDefExc(name);

	}

	private static TableEntry search(String name){
		TableEntry e = null;

		int i = 0;

		while (i < table.size()) {

			e = table.get(i);

			if (e.getName().equals(name)) {
				break;
				
			}
			e = null;
			i++;
			
		}

		return e;
	}

	public static Integer getType(String name)throws VarNoDefExc{

		TableEntry e = search(name);

		if (e == null) throw new VarNoDefExc(name);

		return e.getType();
	}
}