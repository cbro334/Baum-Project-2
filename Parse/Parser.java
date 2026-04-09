// Parser -- the parser for the Scheme printer and interpreter
//
// Defines
//
//   class Parser;
//
// Parses the language
//
//   exp  ->  ( rest
//         |  #f
//         |  #t
//         |  ' exp
//         |  integer_constant
//         |  string_constant
//         |  identifier
//    rest -> )
//         |  exp+ [. exp] )
//
// and builds a parse tree.  Lists of the form (rest) are further
// `parsed' into regular lists and special forms in the constructor
// for the parse tree node class Cons.  See Cons.parseList() for
// more information.
//
// The parser is implemented as an LL(0) recursive descent parser.
// I.e., parseExp() expects that the first token of an exp has not
// been read yet.  If parseRest() reads the first token of an exp
// before calling parseExp(), that token must be put back so that
// it can be reread by parseExp() or an alternative version of
// parseExp() must be called.
//
// If EOF is reached (i.e., if the scanner returns a NULL) token,
// the parser returns a NULL tree.  In case of a parse error, the
// parser discards the offending token (which probably was a DOT
// or an RPAREN) and attempts to continue parsing with the next token.

package Parse;

import Tokens.*;
import Tree.*;

public class Parser {
    private Scanner scanner;

    public Parser(Scanner s) {
        scanner = s;
    }

    public Node parseExp() {
        Token t = scanner.getNextToken();
        if (t == null) return null;

        TokenType type = t.getType();

        // exp -> ( rest
        if (type == TokenType.LPAREN) {
            return parseRest();
        }
        // exp -> #f | #t (Singletons) [cite: 169]
        if (type == TokenType.FALSE) return BooleanLit.getInstance(false);
        if (type == TokenType.TRUE)  return BooleanLit.getInstance(true);
        
        // exp -> ' exp
        if (type == TokenType.QUOTE) {
            return new Cons(new Ident("quote"), new Cons(parseExp(), Nil.getInstance()));
        }
        // exp -> integer_constant | string_constant | identifier [cite: 129, 134-136]
        if (type == TokenType.INT)    return new IntLit(t.getIntVal());
        if (type == TokenType.STRING) return new StringLit(t.getStrVal());
        if (type == TokenType.IDENT)  return new Ident(t.getName());

        // Parse Error: discard and continue [cite: 13]
        System.err.println("Parse error: unexpected token " + type);
        return parseExp();
    }

    protected Node parseRest() {
        Token t = scanner.getNextToken();
        if (t == null) return null;

        // rest -> ) [cite: 132]
        if (t.getType() == TokenType.RPAREN) {
            return Nil.getInstance(); // Singleton [cite: 169]
        }

        // rest -> exp+ [. exp] ) 
        // Check for dotted pair notation
        if (t.getType() == TokenType.DOT) {
            Node car = parseExp();
            Token closing = scanner.getNextToken();
            if (closing.getType() != TokenType.RPAREN) {
                System.err.println("Parse error: expected ')' after dotted pair");
            }
            return car;
        }

        // If not ) or ., it must be the start of an expression. 
        // Put it back so parseExp() can read it[cite: 13].
        scanner.pushBackToken(t);
        Node car = parseExp();
        Node cdr = parseRest();
        return new Cons(car, cdr);
    }
}
