import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Lexer {
    private String code;
    private int index; 
    private char currentChar;

    public Lexer(String code) {
        this.code = code;
        this.index = 0;
        this.currentChar = this.code.charAt(this.index);
    }

    public Token advance(){
        this.index++;
        if (this.index >= this.code.length()) {
            this.currentChar = '\0';
        } else {
            this.currentChar = this.code.charAt(this.index);
        }
        return this.nextToken();
    }


    public Token nextToken() {
        while (Character.isWhitespace(this.currentChar)) {
            this.advance();
        }

        if (Character.isLetter(this.currentChar)) {
            StringBuilder textCode = new StringBuilder();
            while (Character.isLetter(this.currentChar)) {
                textCode.append(this.currentChar);
                this.advance();
            }
            String text = textCode.toString();
            if (text.equals("based")) {
                return Token.PRINT;
            } else if (text.equals("ask")) {
                return Token.INPUT;
            } else if (text.equals("if")) {
                return Token.IF;
            } else if (text.equals("else")) {
                return Token.ELSE;
            } else if (text.equals("{")) {
                return Token.OPENBRACKET;
            } else if (text.equals("}")) {
                return Token.CLOSEBRACKET;
            } else if (text.equals(";")) {
                return Token.SEMI;
            } else if (text.equals(",")) {
                return Token.COMMA;
            } else if (text.equals("+")) {
                return Token.PLUS;
            } else if (text.equals("-")) {
                return Token.MINUS;
            } else if (text.equals("*")) {
                return Token.MUL;
            } else if (text.equals("/")) {
                return Token.DIV;
            } else if (text.equals("!")) {
                return Token.NOT;
            } else if (text.equals("&")) {
                return Token.AND;
            } else if (text.equals("|")) {
                return Token.OR;
            } else if (text.equals("<")) {
                return Token.LESS;
            } else if (text.equals("<=")) {
                return Token.LEG;
            } else if (text.equals(">")) {
                return Token.GT;
            }
            else if(text.equals("<=")){
                return Token.LEG;
            }
            else if(text.equals(">=")){
                return Token.GEQ;
            }
            else if(text.equals("==")){
                return Token.EQ;
            }
            else if(text.equals("=")){
                return Token.ASSIGNOP;
            }
            else if(text.equals("(")){
                return Token.PARENOPEN;
            }
            else if(text.equals(")")){
                return Token.PARENCLOSE;
            }
            else if(text.equals("@")){
                return Token.COMMENTS;
            }
            else if(text.equals("text")){
                return Token.STRING;
            }
            else if(text.equals("num")){
                return Token.INTEGER;
            }
            else if(text.equals("bool")){
                return Token.BOOL;
            }
            else if(text.equals("ask")){
                return Token.INPUT;
            }
            else{
                return null;
            }
        }
        return null;
    }
}
