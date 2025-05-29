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
            accounts[accountCount] = account;
            accountCount++;
        } else {
            System.out.println("Bank cannot handle more accounts.");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                try {
                    accounts[i].withdraw(amount);
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Account with number " + accountNumber + " not found.");
    }

    public void displayAllAccounts() {
        for (int i = 0; i < accountCount; i++) {
            System.out.println("Account: "+accounts[i].getAccountNumber());
            System.out.println("Holder: "+  accounts[i].getAccountHolder()); 
            System.out.println("Balance: Rs."+accounts[i].getBalance());
        }
    }
}

 class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        // Add accounts
        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));
        
        // Withdraw money
        bank.withdrawFromAccount(1001, 6000.0); // Should cause exception
        bank.withdrawFromAccount(1002, 1000.0); // Should succeed
        
        // Display all accounts
        bank.displayAllAccounts();
    }
}
