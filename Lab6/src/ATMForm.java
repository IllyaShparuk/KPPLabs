import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ATMForm {
    private JPanel contentPanel;
    private JTextField accountIdField;
    private JTextField sumField;
    private JButton deposit;
    private JButton withdraw;
    private JButton openAccount;
    private JButton closeAccount;
    private JButton checkBalance;
    private final Bank bank = new Bank();
    private final ATM atm = new ATM(bank);

    public ATMForm() {
        JFrame frame = new JFrame("ATM");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 300);
        frame.setContentPane(getContentPanel());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        openAccount.addActionListener(_ -> new Thread(() -> {
            String accountId = accountIdField.getText();
            if (accountId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "ID рахунку не може бути порожнім!");
                return;
            }
            BankAccount newAccount = bank.createAccount(accountId, 0);
            JOptionPane.showMessageDialog(frame, "Рахунок " + newAccount + " успішно створено!");
        }).start());

        closeAccount.addActionListener(_ -> new Thread(() -> {
            String accountId = accountIdField.getText();
            if (accountId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "ID рахунку не може бути порожнім!");
                return;
            }
            bank.closeAccount(accountId);
            JOptionPane.showMessageDialog(frame, "Рахунок " + accountId + " успішно закрито!");
        }).start());

        deposit.addActionListener(_ -> new Thread(() -> {
            try {
                String accountId = accountIdField.getText();
                double amount = Double.parseDouble(sumField.getText());
                if (accountId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID рахунку не може бути порожнім!");
                    return;
                }
                atm.deposit(accountId, amount);
                JOptionPane.showMessageDialog(frame, "Нараховано " + amount + "\uD83D\uDC37 на рахунок " + bank.getAccount(accountId));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Некоректне значення суми!");
            }

        }).start());

        withdraw.addActionListener(_ -> new Thread(() -> {
            try {
                String accountId = accountIdField.getText();
                double amount = Double.parseDouble(sumField.getText());
                if (accountId.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "ID рахунку не може бути порожнім!");
                    return;
                }
                if (atm.withdraw(accountId, amount))
                    JOptionPane.showMessageDialog(frame, "Знято " + amount + "\uD83D\uDC37 з рахунку " + bank.getAccount(accountId));
                else
                    JOptionPane.showMessageDialog(frame, "Операція не виконана: недостатньо коштів або перевищено ліміт!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Некоректне значення суми!");
            }
        }).start());

        checkBalance.addActionListener(_ -> new Thread(() -> {
            String accountId = accountIdField.getText();
            if (accountId.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "ID рахунку не може бути порожнім!");
                return;
            }
            BankAccount account = bank.getAccount(accountId);
            if (account != null) {
                JOptionPane.showMessageDialog(frame, "Кошти на рахунку " + account + ": " + account.getBalance() + "\uD83D\uDC37");
            } else {
                JOptionPane.showMessageDialog(frame, "Рахунок не знайдено!");
            }
        }).start());
    }

    private Container getContentPanel() {
        return contentPanel;
    }
}
