class ATM {
    private final Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public boolean withdraw(String accountId, double amount) {
        BankAccount account = bank.getAccount(accountId);
        if (account != null && account.withdraw(amount)) {
            System.out.println("Успішне зняття " + amount + "\uD83D\uDC37 з рахунку " + accountId);
            return true;
        } else {
            System.out.println("Операція не виконана: недостатньо коштів або перевищено ліміт.");
            return false;
        }
    }

    public void deposit(String accountId, double amount) {
        BankAccount account = bank.getAccount(accountId);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Успішне поповнення " + amount + "\uD83D\uDC37 на рахунок " + accountId);
        }
    }
}