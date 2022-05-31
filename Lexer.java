import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Lexer {
    private StringBuilder userInput = new StringBuilder();
    private Token token;
    private String lexer;
    private boolean empty = false;
    private String errors = "";
    private Set<Character> blankCharacters = new HashSet<Character>(); // Set of blank characters

    public Lexer(String readFile) {
        try (Stream<String> st = Files.lines(Paths.get(readFile))) { // Read the file
            st.forEach(userInput::append); // Append each line to the userInput
        } catch (IOException exception) {
            empty = true;
            errors = "Could not read file / File not found: " + readFile;
            return;
        }

        blankCharacters.add('\r'); // Carrage Return
        blankCharacters.add('\n'); // New Line
        blankCharacters.add((char) 8);
        blankCharacters.add((char) 9);
        blankCharacters.add((char) 11);
        blankCharacters.add((char) 12);
        blankCharacters.add((char) 32);

        nextToken(); // Get the first token
    }

    public void nextToken() {
        if (empty) { // If the file is empty
            return; // return nothing
        }

        if (userInput.length() == 0) {
            empty = true; // If user didn't input anything, empty is set to true
            return;
        }

        blankWhiteSpaces(); // Remove blank spaces <-- unnecessary

        if (findNextToken()) {
            return;
        }

        empty = true;

        if (userInput.length() > 0) {
            errors = "Unexpected symbol/Unidentifiable symbol: '" + userInput.charAt(0) + "'";
        }
    }

    private void blankWhiteSpaces() {
        int deleteChars = 0;

        while (blankCharacters.contains(userInput.charAt(deleteChars))) { // While the character is a blank character
            deleteChars++; // Increment the number of characters to delete
        }

        if (deleteChars > 0) { // If there are characters to delete
            userInput.delete(0, deleteChars); // Delete the characters
        }
    }

    private boolean findNextToken() {
        for (Token x : Token.values()) {
            int end = x.endOfMatch(userInput.toString());

            if (end != -1) {
                token = x;
                lexer = userInput.substring(0, end);
                userInput.delete(0, end);
                return true;
            }
        }

        return false;
    }

    public Token currentToken() {
        return token;
    }

    public String currentLexer() {
        return lexer;
    }

    public boolean isSuccessful() {
        return errors.isEmpty();
    }

    public String errorMessage() {
        return errors;
    }

    public boolean isEmpty() {
        return empty;
    }
}
