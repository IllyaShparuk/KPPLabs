import org.apache.commons.io.IOUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TextAnalyzer {
    private final String[] words;
    private final String[] sentences;

    public TextAnalyzer(String fileName) {
        try {
            FileInputStream fileReader = new FileInputStream(fileName);
            String text = IOUtils.toString(fileReader, StandardCharsets.UTF_8);
            System.out.println(text);
            words = text.split("\\W+");
            sentences = text.split("(?<=[.!?])\\s+(?=[A-Z\"'])");
        } catch (IOException e) {
            System.out.println("File not found" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public long countWords(){
        return words.length;
    }

    public long countSentences(){
        return sentences.length;
    }

    public long originalWordsCount(){
        return Arrays.stream(words).map(word -> word.toLowerCase()).distinct().count();
    }
}
