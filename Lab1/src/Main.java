import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        Dialog dialog = new Dialog(null, true);
        FileDialog chooseAFile = new FileDialog(dialog, "Choose a file", FileDialog.LOAD);
        chooseAFile.setVisible(true);
        chooseAFile.setFilenameFilter((_, name) -> name.endsWith(".txt"));
        String filename = chooseAFile.getFile();
        String directory = chooseAFile.getDirectory();
        if (filename == null && directory == null)
            System.out.println("You cancelled the choice");
        else
            System.out.println("You chose " + filename);
        chooseAFile.dispose();
        dialog.dispose();


        TextAnalyzer textAnalyzer = new TextAnalyzer(directory + filename);
        try {
            PrintWriter writer = new PrintWriter("result.txt", StandardCharsets.UTF_8);
            writer.println("Word Count: " + textAnalyzer.countWords());
            writer.println("Original Word Count: " + textAnalyzer.originalWordsCount());
            writer.println("Sentence Count: " + textAnalyzer.countSentences());
            writer.println("Punctuation Count" + textAnalyzer.countPunctuations());
            writer.println("Word's Average Length: " + textAnalyzer.calculateWordsAverage());
            writer.println("Sentence's Average Length: " + textAnalyzer.calculateSentencesAverage());
            writer.println("\nTop 10 words:");
            textAnalyzer.firstTenPopulatedWordsCount(writer);
            writer.close();

            System.out.println("\nResult is written to result file");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}