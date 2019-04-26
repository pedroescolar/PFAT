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


	java -cp class/:CUP/ Main ejemplos/Ejem1/Rectangulo.prg Rectangulo
	javac -d class/ -cp class/ Rectangulo.java
	java  -cp class/ Rectangulo 200 100 rectangulo.bmp
	java -cp class/ Rectangulo 100 200 rectangulo1.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem2/Diagonal1.prg Diagonal1
	javac -d class/ -cp class/ Diagonal1.java 
	java -cp class/ Diagonal1 150 diagonal1.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem3/Diagonal2.prg Diagonal2
	javac -d class/ -cp class/ Diagonal2.java
	java -cp class/ Diagonal2 150 diagonal2.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem4/Triangulo1.prg Triangulo1
	javac -d class/ -cp class/ Triangulo1.java
	java -cp class/ Triangulo1 400 400 100 triangulo11.bmp
	java -cp class/ Triangulo1 400 400 200 triangulo12.bmp
	java -cp class/ Triangulo1 400 400 300 triangulo13.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem5/Circulo.prg Circulo1
	javac -d class/ -cp class/ Circulo1.java
	java -cp class/ Circulo1 circulo1.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem6/Circulo.prg Circulo2
	javac -d class/ -cp class/ Circulo2.java
	java -cp class/ Circulo2 circulo2.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem7/Triangulo2.prg Triangulo2
	javac -d class/ -cp class/ Triangulo2.java
	java -cp class/ Triangulo2 400 400 250 triangulo2.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem8/Triangulo3.prg Triangulo3
	javac -d class/ -cp class/ Triangulo3.java
	java -cp class/ Triangulo3 400 400 100 triangulo3-1.bmp
	java -cp class/ Triangulo3 400 400 200 triangulo3-2.bmp
	java -cp class/ Triangulo3 400 400 300 triangulo3-3.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem9/Mixto.prg Mixto
	javac -d class/ -cp class/ Mixto.java
	java -cp class/ Mixto mixto.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem10/Seno.prg Seno
	javac -d class/ -cp class/ Seno.java
	java -cp class/ Seno 600 1 seno1.bmp
	java -cp class/ Seno 600 2 seno2.bmp
	java -cp class/ Seno 600 3 seno3.bmp
	java -cp class/ Seno 600 4 seno4.bmp
	java -cp class/ Seno 600 5 seno5.bmp
	java -cp class/ Seno 600 6 seno6.bmp
	java -cp class/ Seno 600 7 seno7.bmp
	java -cp class/ Seno 600 8 seno8.bmp

	java -cp class/:CUP/ Main ejemplos/Ejem11/Zigzag.prg Zigzag
	javac -d class/ -cp class/ Zigzag.java
	java -cp class/ Zigzag 900 zigzag.bmp

	mv *.bmp imgs/

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
