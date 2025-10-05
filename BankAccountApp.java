import java.util.*;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private List<String> transactions;

    // Constructor
    public Account(String accountNumber, String accountHolder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with initial deposit: ₹" + initialDeposit);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: ₹" + amount);
            System.out.println("✅ Amount deposited successfully!");
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrawn: ₹" + amount);
            System.out.println("✅ Amount withdrawn successfully!");
        } else {
            System.out.println("❌ Insufficient balance or invalid amount!");
        }
    }

    // Check balance
    public void showBalance() {
        System.out.println("💰 Current Balance: ₹" + balance);
    }

    // Show transaction history
    public void showHistory() {
        System.out.println("\n📜 Transaction History:");
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }

    // Getter
    public String getAccountHolder() {
        return accountHolder;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

public class BankAccountApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("🏦 Welcome to Java Bank!");
        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNo = sc.nextLine();
        System.out.print("Enter Initial Deposit: ₹");
        double deposit = sc.nextDouble();

        Account account = new Account(accNo, name, deposit);
        int choice;

        // Menu-driven interface
        do {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter amount to deposit: ₹");
                    double amt = sc.nextDouble();
                    account.deposit(amt);
                }
                case 2 -> {
                    System.out.print("Enter amount to withdraw: ₹");
                    double amt = sc.nextDouble();
                    account.withdraw(amt);
                }
                case 3 -> account.showBalance();
                case 4 -> account.showHistory();
                case 5 -> System.out.println("👋 Thank you for banking with us!");
                default -> System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
