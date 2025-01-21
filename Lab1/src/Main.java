public class Main {
    public static void main(String[] args) {
        TextAnalyzer textAnalyzer = new TextAnalyzer("text.txt");
        System.out.println(textAnalyzer.countWords());
        System.out.println(textAnalyzer.originalWordsCount());
        System.out.println(textAnalyzer.countSentences());
    }
}