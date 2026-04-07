// BooleanLit -- Parse tree node class for representing boolean literals

package Tree;

import Print.Printer;

public class BooleanLit extends Node {
	private boolean boolVal;

	private static BooleanLit trueInstance = new BooleanLit(true);
	private static BooleanLit falseInstance = new BooleanLit(false);

	private BooleanLit(boolean b) {
		boolVal = b;
	}

	public static BooleanLit getInstance(boolean val) {
		if (val)
			return trueInstance;
		else
			return falseInstance;
	}

	public void print(int n) {
		Printer.printBoolLit(n, boolVal);
	}

	public boolean isBoolean() {
		return true;
	}
}
