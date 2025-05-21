class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    public String toString() {
        return "Account Number: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance;
    }
}

class Bank {
    private BankAccount[] accounts;
    private int accountCount;

    public Bank() {
        accounts = new BankAccount[5];
        accountCount = 0;
    }

    public void addAccount(BankAccount account) {
        if (accountCount < 5) {
            accounts[accountCount++] = account;
        } else {
            System.out.println("Bank is full. Cannot add more accounts.");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawn " + amount + " from account " + accountNumber);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account number " + accountNumber + " not found.");
    }

    public void displayAllAccounts() {
        for (int i = 0; i < accountCount; i++) {
            System.out.println(accounts[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        bank.withdrawFromAccount(1001, 6000.0);

        bank.withdrawFromAccount(1002, 1000.0);

        bank.displayAllAccounts();
    }
}
