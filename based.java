import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class based {

    public static void main(String[] args) {

        Lexer lexer = new Lexer("based.txt");
        while (!lexer.isEmpty()) {
            System.out.printf("%-5s:%s\n", lexer.currentLexer(), lexer.currentToken());
            lexer.nextToken();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Done!");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }
}
