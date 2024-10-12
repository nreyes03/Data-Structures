public class SavingsAccount
{

    private double accountBalance;
    private double annualInterestRate;
    private double lastInterestEarned;

    public SavingsAccount(double balance, double interestRate) {

        accountBalance = balance;
        annualInterestRate = interestRate;
        lastInterestEarned = 0.0;
    }

    public void withdraw(double withdrawAmount) {
        accountBalance -= withdrawAmount;
    }

    public void deposit(double depositAmount) {
        accountBalance += depositAmount;
    }

    public void addInterest() {

        double monthlyInterestRate = annualInterestRate / 12;

        lastInterestEarned = monthlyInterestRate * accountBalance;

        accountBalance += lastInterestEarned;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public double getLastAmountOfInterestEarned() {
        return lastInterestEarned;
    }
}