import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        JFileChooser dialog = new JFileChooser(".");
        dialog.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        dialog.showSaveDialog(null);
        if (dialog.getSelectedFile() == null) {
            System.out.println("No file selected 😔");
            return;
        }


        TextAnalyzer textAnalyzer = new TextAnalyzer(dialog.getSelectedFile().getAbsolutePath());
        try {
            String fileName = "result.txt";
            PrintWriter writer = new PrintWriter(fileName, StandardCharsets.UTF_8);
            writer.println("Word Count: " + textAnalyzer.countWords());
            writer.println("Original Word Count: " + textAnalyzer.originalWordsCount());
            writer.println("Sentence Count: " + textAnalyzer.countSentences());
            writer.println("Punctuation Count: " + textAnalyzer.countPunctuations());
            writer.println("Words Average Length: " + String.format("%.2f", textAnalyzer.calculateWordsAverage()));
            writer.println("Sentences Average Length: " + String.format("%.2f", textAnalyzer.calculateSentencesAverage()));
            writer.println("\nTop 10 words:");
            textAnalyzer.firstTenPopularWordsCount(writer);
            writer.close();

            System.out.println("\nResult is written to result file: " + fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}