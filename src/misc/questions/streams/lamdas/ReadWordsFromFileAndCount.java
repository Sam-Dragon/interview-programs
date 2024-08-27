package misc.questions.streams.lamdas;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadWordsFromFileAndCount {

    public static void main(String[] args) {

        try (Stream<String> lines = Files.lines(Path.of("words.txt"), Charset.defaultCharset())) {
            lines.flatMap(word -> Arrays.stream(word.split(" ")))
                .map(s -> s.charAt(0))
                .collect(Collectors.groupingBy(Character::toLowerCase, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + ": " + v));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
