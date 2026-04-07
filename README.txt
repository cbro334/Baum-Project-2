The reference implementation of Project 1 is in libSPP.jar.

You can compile your source code on the command line using

    javac -g -cp libSPP.jar *.java */*.java

or, if you have the make tool installed, simply use the command

    make

In VS Code, mouse over JAVA PROJECTS in the bottom left corner, click on "...",
Configure Classpath, and then add libSPP.jar under Referenced Libaries.

You can run your program from the command line using

    java -cp '.:libSPP.jar' Scheme4101

on Linux or MacOS.  On Windows, use a semicolon instead of the colon:

    java -cp '.;libSPP.jar' Scheme4101

Alternatively, you can define the environment variable CLASSPATH as follows.

In Linux or MacOS, simply add

    export CLASSPATH=.:libSPP.jar

to your .profile and .bashrc files.

In Windows, go to

    Settings / About / Advanced system settings / Environment variables

and then add a definition for CLASSPATH to the user variables with the value

    .;libSPP.jar

If you have your file libSPP.jar in another folder/directory, then put the
full path to libSPP.jar onto the CLASSPATH.

Once you added the CLASSPATH, create a new shell (or log out and back in).
You can then compile and run your code using

    javac -g *.java */*.java
    java Scheme4101
