all: jj j
jj: Jagger.jj
	javacc Jagger.jj
j: *.java
	javac -g *.java
clean: 
	rm *.class
check: *.java
	java Test
