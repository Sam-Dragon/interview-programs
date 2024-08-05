package learn.programs;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

/**
 * Program to count unique words from file using streams
 */

public class CountUniqueWordsFromFile {

    public static void main(String[] args) throws IOException {
        try (var lines = Files.lines(Path.of("words.txt"), Charset.defaultCharset())) {
            long count = lines.flatMap(word -> Arrays.stream(word.split(" ")))
                .distinct()
                .count();
            System.out.println("Total words: " + count);
        }
    }
}
