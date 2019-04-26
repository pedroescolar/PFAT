all: errors compiler ast sint lex main

#compilamos CUP y JLex
tools:
	javac CUP/java_cup/*.java CUP/java_cup/runtime/*.java
	javac JLex/Main.java

#compilamos errores
errors:
	clear; javac -d class/ java/Errors/*.java

compiler:
	javac -d class/ -cp .:class java/Compiler/*.java

#Compilamos clases del paquete AST
ast:
	javac -d class/ -cp class/ java/AST/*.java

# Generamos y compilamos lexico
lex:
	java JLex.Main java/Lexer/Yylex
	javac -d class/ -cp CUP/:class/ java/Lexer/Yylex.java

#generamos y compilamos sintactico
sint:
	java -cp class/:CUP/ java_cup.Main java/Parser/parser
	mv parser.java java/Parser/
	mv sym.java java/Parser/
	javac -d class/ -cp CUP/:class/ java/Parser/*.java

# Clase main que se proporciona
main:
	javac -d class/ -cp CUP/:class/ java/Main.java

test:
	java -cp class/:CUP/ Main ejemplos/Ejem1/Rectangulo.prg
	java -cp class/:CUP/ Main ejemplos/Ejem2/Diagonal1.prg 
	java -cp class/:CUP/ Main ejemplos/Ejem3/Diagonal2.prg 
	java -cp class/:CUP/ Main ejemplos/Ejem4/Triangulo1.prg
	java -cp class/:CUP/ Main ejemplos/Ejem5/Circulo.prg 
	java -cp class/:CUP/ Main ejemplos/Ejem6/Circulo.prg 
	java -cp class/:CUP/ Main ejemplos/Ejem7/Triangulo2.prg
	java -cp class/:CUP/ Main ejemplos/Ejem8/Triangulo3.prg
	java -cp class/:CUP/ Main ejemplos/Ejem9/Mixto.prg 
	java -cp class/:CUP/ Main ejemplos/Ejem10/Seno.prg 
	java -cp class/:CUP/ Main ejemplos/Ejem11/Zigzag.prg
testlex:
	-java -cp class/:CUP/ Main ejemplos/ErrLex/ErrLex.prg
testsint:
	-java -cp class/:CUP/ Main ejemplos/ErrSint1/ErrSint1.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSint2/ErrSint2.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSint3/ErrSint3.prg

testsemant:
	-java -cp class/:CUP/ Main ejemplos/ErrSem1/ErrSem1.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem2/ErrSem2.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem3/ErrSem3.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem4/ErrSem4.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem5/ErrSem5.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem6/ErrSem6.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem7/ErrSem7.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem8/ErrSem8.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem9/ErrSem9.prg
	-java -cp class/:CUP/ Main ejemplos/ErrSem10/ErrSem10.prg

testall: test testlex testsint testsemant
