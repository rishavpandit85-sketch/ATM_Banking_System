
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {

            try {

                // Enter Account Details
                System.out.println("Enter Account Holder Name:");
                String name = sc.nextLine();

                System.out.println("Enter Account Number:");
                int number = sc.nextInt();

                System.out.println("Enter Initial Balance:");
                double balance = sc.nextDouble();

                if (balance < 0) {
                    System.out.println("Invalid Initial Balance");
                    return;
                }

                // Create Bank Account
                BankAccount account
                        = new BankAccount(name, number, balance);

                // Transaction Menu
                System.out.println("Enter Transaction Type:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");

                int choice = sc.nextInt();

                System.out.println("Account Holder: "
                        + account.getAccountHolderName());

                System.out.println("Account Number: "
                        + account.getAccountNumber());

                try {

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Enter Amount:");
                            double amount = sc.nextDouble();
                            account.deposit(amount);
                        }
                        case 2 -> {
                            System.out.println("Enter Amount:");
                            double amount = sc.nextDouble();
                            account.withdraw(amount);
                        }
                        case 3 ->
                            account.checkBalance();
                        default ->
                            System.out.println("Invalid Transaction Type");
                    }

                } catch (InvalidAmountException
                        | InsufficientBalanceException e) {

                    System.out.println(e.getMessage());

                } finally {

                    account.checkBalance();

                    System.out.println("Transaction Completed");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid Input. Please enter correct values.");
            }

        }
    }
}
