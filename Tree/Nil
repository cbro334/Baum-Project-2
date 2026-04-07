// Nil -- Parse tree node class for representing the empty list

package Tree;

import Print.Printer;

public class Nil extends Node {
    private static Nil instance = new Nil();

    private Nil() {
    }

    public static Nil getInstance() {
        return instance;
    }

    public void print(int n) {
        print(n, false);
    }

    public void print(int n, boolean p) {
        Printer.printNil(n, p);
    }

    public boolean isNull() {
        return true;
    }
}
