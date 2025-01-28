import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {
    private final String text;
    private final String[] words;
    private final String[] sentences;

    public TextAnalyzer(String fileName) {
        try {
            FileInputStream fileReader = new FileInputStream(fileName);
            text = IOUtils.toString(fileReader, StandardCharsets.UTF_8);
            System.out.println("\nYour text is: " + text);
            words = text.split("\\W+");
            sentences = text.split("(?<=[.!?])\\s+(?=[A-Z\"'])");
        } catch (IOException e) {
            System.out.println("File not found: \n" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public long countPunctuations() {
        return text.chars().filter(c -> "\",.;:!?-".indexOf(c) >= 0).count();
    }

    public long countWords() {
        return words.length;
    }

    public long countSentences() {
        return sentences.length;
    }

    public long originalWordsCount() {
        return Arrays.stream(words).map(word -> word.toLowerCase()).distinct().count();
    }

    public long calculateWordsAverage() {
        if (words.length == 0) return 0;
        return Arrays.stream(words).mapToInt(word -> word.length()).sum() / words.length;
    }

    public long calculateSentencesAverage() {
        if (sentences.length == 0) return 0;
        return Arrays.stream(sentences).mapToInt(sentence -> sentence.split("\\W+").length).sum() / sentences.length;
    }

    public void firstTenPopulatedWordsCount(@Nullable PrintWriter writer) {
        Map<String, Long> wordFrequency = new HashMap<>();
        for (String word : words) {
            String lowerCase = word.toLowerCase();
            wordFrequency.put(lowerCase, wordFrequency.getOrDefault(lowerCase, 0L) + 1);
        }
        var topTenWords = wordFrequency.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(10);
        if (writer == null) {
            topTenWords.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
        } else {
            topTenWords.forEach(e -> writer.println(e.getKey() + " " + e.getValue()));
        }

    }
}
