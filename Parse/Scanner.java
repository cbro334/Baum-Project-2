package Parse;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import Tokens.*;

public class Scanner {
    private PushbackInputStream in;
    private Token lookaheadToken = null;
    private int BUFSIZE = 1000;
    private byte[] buf = new byte[BUFSIZE];

    public Scanner(InputStream i) {
        in = new PushbackInputStream(i);
    }

    // Method to allow the parser to put back a token for LL(0) parsing
    public void pushBackToken(Token t) {
        lookaheadToken = t;
    }

    public Token getNextToken() {
        if (lookaheadToken != null) {
            Token t = lookaheadToken;
            lookaheadToken = null;
            return t;
        }

        int ch;
        try {
            ch = in.read();

            // 1. Skip white space and 2. Discard comments [cite: 46, 47]
            while (Character.isWhitespace(ch) || ch == ';') {
                if (ch == ';') {
                    while (ch != -1 && ch != '\n' && ch != '\r')
                        ch = in.read();
                } else {
                    ch = in.read();
                }
            }

            if (ch == -1) return null; // Return null on EOF [cite: 13]

            // 3. Recognize special characters [cite: 48]
            if (ch == '\'') return new Token(TokenType.QUOTE);
            if (ch == '(')  return new Token(TokenType.LPAREN);
            if (ch == ')')  return new Token(TokenType.RPAREN);
            if (ch == '.')  return new Token(TokenType.DOT);

            // 4. Recognize boolean constants #t and #f [cite: 49]
            if (ch == '#') {
                ch = in.read();
                if (ch == 't') return new Token(TokenType.TRUE);
                if (ch == 'f') return new Token(TokenType.FALSE);
                System.err.println("Illegal character '" + (char)ch + "' following #");
                return getNextToken();
            }

            // 6. Recognize string constants [cite: 51]
            if (ch == '"') {
                int i = 0;
                while ((ch = in.read()) != '"' && ch != -1) {
                    if (i < BUFSIZE) buf[i++] = (byte)ch;
                }
                return new StrToken(new String(buf, 0, i));
            }

            // 5. Recognize integer constants (unsigned digits) [cite: 50]
            if (ch >= '0' && ch <= '9') {
                int val = 0;
                while (ch >= '0' && ch <= '9') {
                    val = val * 10 + (ch - '0');
                    ch = in.read();
                }
                in.unread(ch);
                return new IntToken(val);
            }

            // 7. Recognize identifiers (converted to lowercase) [cite: 52, 57]
            if (isInitial(ch) || ch == '+' || ch == '-') {
                int i = 0;
                // Handle peculiar identifiers + and - which are only identifiers if alone 
                // or followed by subsequent chars, but not if part of a signed number 
                // (though project spec ignores signed numbers).
                while (isSubsequent(ch)) {
                    if (i < BUFSIZE) buf[i++] = (byte)Character.toLowerCase(ch);
                    ch = in.read();
                }
                in.unread(ch);
                return new IdentToken(new String(buf, 0, i));
            }

            // Illegal character error handling [cite: 13]
            System.err.println("Illegal input character '" + (char)ch + '\'');
            return getNextToken();
        } catch (IOException e) {
            return null;
        }
    }

    private boolean isInitial(int ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || 
               "!$%&*/:<=>?^_~".indexOf(ch) != -1;
    }

    private boolean isSubsequent(int ch) {
        return isInitial(ch) || (ch >= '0' && ch <= '9') || "+-.@".indexOf(ch) != -1;
    }
}
