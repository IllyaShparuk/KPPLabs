public class Main {
    public static void main(String[] args) {
        TextAnalyzer textAnalyzer = new TextAnalyzer("text.txt");
        System.out.println(textAnalyzer.countWords());
        System.out.println(textAnalyzer.originalWordsCount());
        System.out.println(textAnalyzer.countSentences());
        System.out.println(textAnalyzer.countPunctuations());
        System.out.println(textAnalyzer.calculateWordsAverage());
        System.out.println(textAnalyzer.calculateSentencesAverage());

        System.out.println("Top 10 words:");
        textAnalyzer.firstTenPopulatedWordsCount();
    }
}