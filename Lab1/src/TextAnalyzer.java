import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TextAnalyzer {
    private final String text;
    private final String[] words;
    private final String[] sentences;

    public TextAnalyzer(String fileName) {
        try {
            File file = new File(fileName);
            text = Files.readString(file.toPath());
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
        return Arrays.stream(words).map(String::toLowerCase).distinct().count();
    }

    public double calculateWordsAverage() {
        if (words.length == 0) return 0;
        return Arrays.stream(words).mapToDouble(String::length).sum() / words.length;
    }

    public double calculateSentencesAverage() {
        if (sentences.length == 0) return 0;
        return (double) words.length / sentences.length;
    }

    public void firstTenPopularWordsCount(PrintWriter writer) {
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
