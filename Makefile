LIBSRC= $(wildcard Parse/*.java) $(wildcard Tokens/*.java) Print/Printer.java
LIBOBJ= $(LIBSRC:%.java=%.class)
LIB =   libSPP.jar
SRC =   Scheme4101.java $(wildcard Tree/*.java) $(wildcard Special/*.java)
OBJ =   $(SRC:%.java=%.class)
JAR =   Scheme4101.jar

all: $(SRC)
	javac -g -cp $(LIB) $(SRC)

jar: $(SRC) $(LIBSRC)
	javac $(SRC) $(LIBSRC)
	jar cfm $(JAR) Manifest.txt $(OBJ) $(LIBOBJ)

lib: $(LIBSRC)
	javac $(LIBSRC)
	jar cf $(LIB) $(LIBOBJ)

clean:
	@rm -f *.class */*.class *~ */*~

veryclean:
	@rm -f *.class */*.class *~ */*~ $(LIB) $(JAR)
