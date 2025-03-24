import java.util.concurrent.ConcurrentHashMap;

class Bank {
    private final ConcurrentHashMap<String, BankAccount> accounts = new ConcurrentHashMap<>();

    public BankAccount createAccount(String accountId, double initialBalance) {
        BankAccount account = new BankAccount(accountId, initialBalance);
        accounts.put(accountId, account);
        Logger.logTransaction("Рахунок " + accountId + " вікрито");
        return account;
    }

    public void closeAccount(String accountId) {
        accounts.remove(accountId);
        Logger.logTransaction("Рахунок " + accountId + " закрито");
    }

    public BankAccount getAccount(String accountId) {
        return accounts.get(accountId);
    }
}