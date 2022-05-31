import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {

    // All Tokens for BasedScript

    TK_PRINT("based"),
    TK_STRING("text"),
    TK_INTEGER("num"),
    TK_DOUBLE("dec"),
    TK_BOOL("bool"),
    TK_INPUT("ask"),
    TK_COMMENTS("\\@"),
    TK_PLUS("\\+"),
    TK_MINUS("\\-"),
    TK_MUL("\\*"),
    TK_DIV("/"),
    TK_NOT("!"),
    TK_AND("&"),
    TK_OR("\\|"),
    TK_LESS("<"),
    TK_LEG("<="),
    TK_GT(">"),
    TK_GEQ(">="),
    TK_ASSIGN("=="),
    TK_EQUALS("="),
    TK_PARENOPEN("\\("),
    TK_PARENCLOSE("\\)"),
    TK_SEMI(";"),
    TK_COMMA(","),
    TK_IF("if"),
    TK_ELSE("else"),
    TK_OPENBRACKET("\\{"),
    TK_CLOSEBRACKET("\\}"),
    STRING("\"[^\"]+\""), // String
    INTEGER("\\d"), // Integer
    IDENTIFIER("\\w+"); // Identifier

    private final Pattern pattern;

    Token(String regex) {
        pattern = Pattern.compile("^" + regex); // Compile the regex
    }

    int endOfMatch(String text) { // Return the index of the end of the match
        Matcher matchTokens = pattern.matcher(text); // Create a matcher

        if (matchTokens.find()) { // If a match is found
            return matchTokens.end(); // Return the end of the match
        }
        return -1;
    }
}
