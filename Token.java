import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Token {
    
    PRINT ("based"),
    STRING ("text"),   
    INTEGER("num"),
    BOOL("bool"), 
    INPUT("ask"),
    COMMENTS("\\@"), 
    PLUS ("\\+"), 
    MINUS ("\\-"), 
    MUL ("\\*"), 
    DIV ("/"),
    NOT ("!"), 
    AND ("&"),  
    OR ("\\|"),  
    LESS ("<"),
    LEG ("<="),
    GT (">"),
    GEQ (">="), 
    EQ ("=="),
    ASSIGNOP ("="),
    PARENOPEN ("\\("),
    PARENCLOSE ("\\)"), 
    SEMI (";"), 
    COMMA (","), 
    IF ("if"), 
    ELSE ("else"), 
    OPENBRACKET ("\\{"),
    CLOSEBRACKET ("\\}");

    private String text;

    Token(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Token getToken(String text) {
        for (Token token : Token.values()) {
            if (token.getText().equals(text)) {
                return token;
            }
        }
        return null;
    }
}






