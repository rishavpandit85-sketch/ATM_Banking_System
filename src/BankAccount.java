
public class BankAccount {

    private final String accountHolderName;
    private final int accountNumber;
    private double balance;

    // Parameterized Constructor
    public BankAccount(String name, int number, double balance) {
        this.accountHolderName = name;
        this.accountNumber = number;
        this.balance = balance;
    }

    // Deposit Method
    public void deposit(double amount)
            throws InvalidAmountException {

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid Amount");
        }

        balance += amount;
        System.out.println("Deposit Successful");
    }

    // Withdraw Method
    public void withdraw(double amount)
            throws InvalidAmountException,
            InsufficientBalanceException {

        if (amount <= 0) {
            throw new InvalidAmountException("Invalid Amount");
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient Balance");
        }

        balance -= amount;
        System.out.println("Withdrawal Successful");
    }

    // Check Balance Method
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Getter Methods
    public String getAccountHolderName() {
        return accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }
}
