import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
    static void logTransaction(String message) {
        try (FileWriter writer = new FileWriter("transactions.log", true)) {
            writer.write(LocalDateTime.now()+" |\t"+message + "\n");
        } catch (IOException e) {
            System.err.println("Помилка логування: " + e.getMessage());
        }
    }
}
