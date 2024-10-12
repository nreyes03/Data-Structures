import java.util.Scanner;
public class SavingsAccountDemo
{
    public static void main(String[] args)
    {
        double monthlyDeposit;
        double monthlyWithdrawl;
        double interestEarned = 0.0;
        double totalDeposits = 0;
        double totalWithdrawn = 0;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("How much money is in your savings account?: ");
        double startingBalance = keyboard.nextDouble();

        System.out.print("Enter the annual interest rate: ");
        double annualInterestRate = keyboard.nextDouble();

        System.out.print("How long has the account been opened? ");
        double months = keyboard.nextInt();

        SavingsAccount sa = new SavingsAccount(startingBalance, annualInterestRate);

        for (int i = 1; i <= months; i++)
        {
            System.out.print("Enter amount deposited for month " + i + ": $");
            monthlyDeposit = keyboard.nextDouble();
            totalDeposits += monthlyDeposit;

            sa.deposit(monthlyDeposit);

            System.out.print("Enter amount withdrawn for month " + i + ": $");
            monthlyWithdrawl = keyboard.nextDouble();
            totalWithdrawn += monthlyWithdrawl;

            sa.withdraw(monthlyWithdrawl);

            sa.addInterest();

            interestEarned += sa.getLastInterestEarned();
        }
        System.out.printf("\nTotal deposits: $%.2f", totalDeposits);
        System.out.printf("\nTotal withdrawals: $%.2f", totalWithdrawn);
        System.out.printf("\nTotal interest: $%.2f", interestEarned);
        System.out.printf("\nEnding balance: $%.2f", sa.getAccountBalance());

    }
}
