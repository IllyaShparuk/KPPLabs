class BankAccount {
    private final String accountId;
    private double balance;

    public BankAccount(String accountId, double initialBalance) {
        this.accountId = accountId;
        this.balance = initialBalance;
    }

    public synchronized boolean withdraw(double amount) {
        if (amount > balance || amount > 1000) return false;
        balance -= amount;
        Logger.logTransaction("Знято: " + amount + "\uD83D\uDC37 з рахунку " + accountId);
        return true;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        Logger.logTransaction("Поповнено: " + amount + "\uD83D\uDC37 на рахунок " + accountId);
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return accountId;
    }
}