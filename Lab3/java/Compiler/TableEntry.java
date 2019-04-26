package Compiler;

public class TableEntry{

	private String name;
	private Integer type;

	public TableEntry(String name, Integer type){

		this.name = name;
		this.type = type;
	}

	public String getName(){
		return name;
	}

	public Integer getType(){
		return type;
	}
}