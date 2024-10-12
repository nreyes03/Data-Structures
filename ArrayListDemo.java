import java.util.ArrayList; // Needed for ArrayList class


public class ArrayListDemo
{
    static class BankAccount
    {
        private double balance;      // Account balance

        public BankAccount(double startBalance)
        {
            balance = startBalance;
        }

        public void deposit(double amount)
        {
            balance += amount;
        }

        public void withdraw(double amount)
        {
            balance -= amount;
        }

        public double getBalance()
        {
            return balance;
        }
    }

    public static void main(String[] args)
    {
        // Create an ArrayList to hold BankAccount objects.
        ArrayList<BankAccount> list = new ArrayList<BankAccount>();

        // Add three BankAccount objects to the ArrayList.
        list.add(new BankAccount(100.0));
        list.add(new BankAccount(500.0));
        list.add(new BankAccount(1500.0));

        // Display each item.
        for (int index = 0; index < list.size(); index++)
        {
            BankAccount account = list.get(index);
            account.deposit(100);
            System.out.println("Account at index " + index +
                    "\nBalance: " + account.getBalance());
        }
    }
}