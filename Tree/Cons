// Cons -- Parse tree node class for representing a Cons node

package Tree;

import Special.Special;
import Special.Begin;
import Special.Cond;
import Special.Define;
import Special.If;
import Special.Lambda;
import Special.Let;
import Special.Quote;
import Special.Regular;
import Special.Set;

public class Cons extends Node {
	private Node car;
	private Node cdr;
	private Special form;

	public Cons(Node a, Node d) {
		car = a;
		cdr = d;
		parseList();
	}

	// parseList() `parses' special forms, constructs an appropriate
	// object of a subclass of Special, and stores a pointer to that
	// object in variable form. It would be possible to fully parse
	// special forms at this point. Since this causes complications
	// when using (incorrect) programs as data, it is easiest to let
	// parseList only look at the car for selecting the appropriate
	// object from the Special hierarchy and to leave the rest of
	// parsing up to the interpreter.
	void parseList() {

		if (!car.isSymbol())
			form = new Regular();
		else {
			String sym = car.getName();

			if (sym.equalsIgnoreCase("begin"))
				form = new Begin();
			else if (sym.equalsIgnoreCase("cond"))
				form = new Cond();
			else if (sym.equalsIgnoreCase("define"))
				form = new Define();
			else if (sym.equalsIgnoreCase("if"))
				form = new If();
			else if (sym.equalsIgnoreCase("lambda"))
				form = new Lambda();
			else if (sym.equalsIgnoreCase("let"))
				form = new Let();
			else if (sym.equalsIgnoreCase("quote"))
				form = new Quote();
			else if (sym.equalsIgnoreCase("set!"))
				form = new Set();
			else
				form = new Regular();
		}
	}

	public void print(int n) {
		form.print(this, n, false);
	}

	public void print(int n, boolean p) {
		form.print(this, n, p);
	}

	public boolean isPair() {
		return true;
	}

	public void setCar(Node a) {
		car = a;
		parseList();
	}

	public void setCdr(Node d) {
		cdr = d;
	}

	public Node getCar() {
		return car;
	}

	public Node getCdr() {
		return cdr;
	}
}
