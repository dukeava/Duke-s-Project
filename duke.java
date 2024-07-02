import java.util.ArrayList;
import java.util.Scanner;

class Transaction {
    private String description;
    private double amount;

    public Transaction(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}

class BudgetManager {
    private double balance;
    private ArrayList<Transaction> transactions;

    public BudgetManager() {
        balance = 0.0;
        transactions = new ArrayList<>();
    }

    public void addIncome(String description, double amount) {
        balance += amount;
        Transaction transaction = new Transaction(description, amount);
        transactions.add(transaction);
        System.out.println("Income added: " + description + ", Amount: $" + amount);
    }

    public void addExpense(String description, double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds to add expense.");
        } else {
            balance -= amount;
            Transaction transaction = new Transaction(description, -amount);
            transactions.add(transaction);
            System.out.println("Expense added: " + description + ", Amount: $" + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactions() {
        System.out.println("\n--- Transactions ---");
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() > 0) {
                System.out.println("Income: " + transaction.getDescription() + ", Amount: $" + transaction.getAmount());
            } else {
                System.out.println("Expense: " + transaction.getDescription() + ", Amount: $" + (-transaction.getAmount()));
            }
        }
        System.out.println("--- End of Transactions ---\n");
    }
}

public class Main {
    public static void main(String[] args) {
        BudgetManager budgetManager = new BudgetManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter income description: ");
                    String incomeDesc = scanner.nextLine();
                    System.out.print("Enter income amount: $");
                    double incomeAmount = scanner.nextDouble();
                    budgetManager.addIncome(incomeDesc, incomeAmount);
                    break;
                case 2:
                    System.out.print("Enter expense description: ");
                    String expenseDesc = scanner.nextLine();
                    System.out.print("Enter expense amount: $");
                    double expenseAmount = scanner.nextDouble();
                    budgetManager.addExpense(expenseDesc, expenseAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: $" + budgetManager.getBalance());
                    break;
                case 4:
                    budgetManager.showTransactions();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}