default: j
all: jj j
jj: Cabeg.jj
	javacc Cabeg.jj
j: *.java
	javac *.java
clean: 
	rm *.class
check: *.java
	java Test
