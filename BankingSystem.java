import java.util.Scanner;
public class BankingSystem {
    static int transactionCount = 0;

    // Display Menu..
    public static void displayMenu() {
        System.out.println("\n===== BANK MENU =====");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Transaction Count");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Deposit Money..
    public static double depositMoney(Scanner sc, double balance) {
        System.out.print ("\nEnter Deposit Amount : ");
        double depositAmount = sc.nextDouble();
        if (depositAmount > 0) {
            balance += depositAmount;
            transactionCount++;
            System.out.println ("Amount deposited Successfully..");
        } else {
            System.out.println ("Invalid Deposit Amount !");
        }
        return balance;
    }

    // Withdraw Money..
    public static double withdrawMoney(Scanner sc, double balance) {
        System.out.print ("\nEnter Withdraw Amount : ");
        double withdrawAmount = sc.nextDouble();
        if (withdrawAmount <= 0) {
            System.out.println ("Invalid Amount !");
        } else if (withdrawAmount <= balance) {
            balance -= withdrawAmount;
            transactionCount++;
            System.out.println ("Amount Withdrawn Successfully..");
        } else {
            System.out.println ("Insufficient Balance !");
        }
        return balance;
    }

    // Check Balance..
    public static void checkBalance (double balance) {
        System.out.printf ("\nCurrent Balance : %.2f%n", balance);
    }

    // Transactions Count..
    public static void displayTransactionCount() {
        System.out.println ("\nTotal Transactions : " + transactionCount);
    }

    // Exit..
    public static void exit() {
        System.out.println("\n=================================");
        System.out.println(" Thank You for Using Our Bank ");
        System.out.println(" Have a Great Day!");
        System.out.println("=================================");
    }

    // Main method..
    public static void main (String args[]) {
        Scanner sc = new Scanner (System.in);
        double balance = 1000.0;
        int choice = 0;
        
        do {
            displayMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1 : balance = depositMoney(sc, balance);
                break;

                case 2 : balance = withdrawMoney(sc, balance);
                break;

                case 3 : checkBalance(balance);
                break;

                case 4 : displayTransactionCount();
                break;

                case 5 : exit();
                break;

                default : System.out.println ("\nInvalid Choice Input !");
            } 
        } while (choice != 5);

        sc.close();
    }
}