// BuiltIn.java -- the data structure for function closures

// Class BuiltIn is used for representing the value of built-in functions
// such as +.  Populate the initial environment with
// (name, new BuiltIn(name)) pairs.

// The object-oriented style for implementing built-in functions would be
// to include the Java methods for implementing a Scheme built-in in the
// BuiltIn object.  This could be done by writing one subclass of class
// BuiltIn for each built-in function and implementing the method apply
// appropriately.  This requires a large number of classes, though.
// Another alternative is to program BuiltIn.apply() in a functional
// style by writing a large if-then-else chain that tests the name of
// of the function symbol.

package Tree;

public class BuiltIn extends Node {
    // TODO: For allowing the built-in functions to access the environment,
    // keep a copy of the Environment here and synchronize it with
    // class Scheme4101.

    // private static Environment globalEnv = null;
    //
    // public static void setGlobalEnv(Environment env) {
    // globalEnv = env;
    // }

    private Node symbol;

    public BuiltIn(Node s) {
        symbol = s;
    }

    public Node getSymbol() {
        return symbol;
    }

    public boolean isProcedure() {
        return true;
    }

    public void print(int n) {
        // there got to be a more efficient way to print n spaces
        for (int i = 0; i < n; i++)
            System.out.print(' ');
        System.out.print("#{Built-in Procedure ");
        if (symbol != null)
            symbol.print(-Math.abs(n) - 1);
        System.out.print('}');
        if (n >= 0)
            System.out.println();
    }

    // TODO: The method apply() should be defined in class Node
    // to report an error. It should be overwritten only in classes
    // BuiltIn and Closure.
    public Node apply(Node args) {
        return null;
    }

    // The easiest way to implement BuiltIn.apply is as an
    // if-then-else chain testing for the different names of
    // the built-in functions.  E.g., here's how load could
    // be implemented:

    // if (name.equals("load")) {
    //     if (!arg1.isString()) {
    //         System.err.println("Error: wrong type of argument");
    //         return Nil.getInstance();
    //     }
    //     String filename = arg1.getStrVal();
    //     try {
    //         Scanner scanner = new Scanner(new FileInputStream(filename));
    //         Parser parser = new Parser(scanner);
    //
    //         Node root = parser.parseExp();
    //         while (root != null) {
    //             root.eval(globalEnv);
    //             root = parser.parseExp();
    //         }
    //     } catch (IOException e) {
    //         System.err.println("Could not find file " + filename);
    //     }
    //     return Nil.getInstance();  // or Unspecific.getInstance();
    // }
}
