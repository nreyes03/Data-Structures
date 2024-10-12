import java.util.Scanner;

public class SavingsAccountDemo
{
	static class SavingsAccount
	{
		private double balance;          // The account balance

		public SavingsAccount(double bal)
		{
			balance = bal;
		}

		public void withdraw(double amount)
		{
			if (balance - amount > 0)
				balance -= amount;
		}

		public void deposit(double amount)
		{
			balance += amount;
		}

		public double getBalance()
		{
			return balance;
		}


	}

    public static void main(String args[])
    {
        double balance = 100.0;            // Starting balance
        double deposits = 10.0;           // Amount of deposits for a month
        double withdrawn = 20.0;          // Amount withdrawn in a month

        SavingsAccount savings = new SavingsAccount(balance);

        savings.deposit(deposits);
        System.out.printf("Balance: $%,.2f\n", savings.getBalance());

        savings.withdraw(withdrawn);
        System.out.printf("Balance: $%,.2f\n", savings.getBalance());
    }
}
