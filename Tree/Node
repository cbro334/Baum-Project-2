// Node -- Super class for parse tree node objects

package Tree;

public class Node {
    // The argument of print(int) is the number of characters to indent.
    // Every subclass of Node must implement print(int).
    public void print(int n) {
    }

    // The first argument of print(int, boolean) is the number of characters
    // to indent. It is interpreted the same as for print(int).
    // The second argument is only useful for lists (nodes of classes
    // Cons or Nil). For all other subclasses of Node, the boolean
    // argument is ignored. Therefore, print(n,p) defaults to print(n)
    // for all classes other than Cons and Nil.
    // For classes Cons and Nil, print(n,TRUE) means that the open
    // parenthesis was printed already by the caller.
    // Only classes Cons and Nil override print(int,boolean).
    // For correctly indenting special forms, you might need to pass
    // additional information to print. What additional information
    // you pass is up to you. If you only need one more bit, you can
    // encode that in the sign bit of n. If you need additional parameters,
    // make sure that you define the method print in all the appropriate
    // subclasses of Node as well.
    public void print(int n, boolean p) {
        print(n);
    }

    // For parsing Cons nodes, for printing trees, and later for
    // evaluating them, we need some helper functions that test
    // the type of a node and that extract some information.

    // These are implemented in the appropriate subclasses to return true.
    public boolean isBoolean() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isString() {
        return false;
    }

    public boolean isSymbol() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isPair() {
        return false;
    }

    public boolean isProcedure() {
        return false;
    }

    public boolean isEnvironment() {
        return false;
    }

    // Report an error in these default methods and implement them
    // in class Cons. After setCar, a Cons cell needs to be `parsed' again
    // using parseList.

    // These static methods were added to allow the Node hierarchy to
    // be modified without having to recompile classes Parser and Printer.
    public static void print(Node t, int n, boolean p) {
        t.print(n, p);
    }

    public static Node getCar(Node t) {
        return t.getCar();
    }

    public static Node getCdr(Node t) {
        return t.getCdr();
    }

    public static boolean isNull(Node t) {
        return t.isNull();
    }

    public static boolean isPair(Node t) {
        return t.isPair();
    }

    public Node getCar() {
        System.err.println("Error: argument of car is not a pair");
        return Nil.getInstance();
    }

    public Node getCdr() {
        System.err.println("Error: argument of cdr is not a pair");
        return Nil.getInstance();
    }

    public void setCar(Node a) {
        System.err.println("Error: argument of set-car! is not a pair");
    }

    public void setCdr(Node d) {
        System.err.println("Error: argument of set-cdr! is not a pair");
    }

    public String getName() {
        return "";
    }

    public Node eval(Environment env) {
        System.err.println("Error: Node.eval not yet implemented");
        return Nil.getInstance();
    }
}
