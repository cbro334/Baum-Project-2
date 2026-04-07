// Util -- Utility functions

package Special;

import Tree.Node;
import Tree.Nil;
import Tree.Cons;
import Tree.Environment;

public class Util {
    // length returns the length of a well-formed list exp and -1 otherwise
    public static int length(Node exp) {
        if (exp.isNull())
            return 0;
        if (!exp.isPair())
            return -1;
        int n = length(exp.getCdr());
        if (n == -1)
            return -1;
        return n + 1;
    }

    // mapeval calls eval on every list element of exp
    public static Node mapeval(Node exp, Environment env) {
        if (exp.isNull())
            return Nil.getInstance();
        return new Cons(exp.getCar().eval(env), mapeval(exp.getCdr(), env));
    }

    // begin calls eval on all list elements and returns the last value
    public static Node begin(Node exp, Environment env) {
        Node res = exp.getCar().eval(env);
        Node cdr = exp.getCdr();
        if (cdr.isNull())
            return res;
        return begin(cdr, env);
    }
}
