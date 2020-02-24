package SavingsAccountTest;
import SavingsAccount.SavingsAccount;
public class SavingsAccountTest {

	public static void main(String [] arg)
    {
        SavingsAccount saver1 = new SavingsAccount(2000.0);
        SavingsAccount saver2 = new SavingsAccount(3000.0);
        SavingsAccount.modifyInterestRate(4); 
        int i;
         
        System.out.println("\nYour savings account.\n");
        System.out.println("Savings Account Balances!\n");
        System.out.format("%-8s %9s %9s\n", "Month", "Saver1", "Saver2");
        for(i = 0; i < 13; i ++)
        {
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
          
         System.out.println("\n");
         System.out.format("%-8d %9.2f %9.2f\n", i + 1, saver1.SavingsBalance(),saver2.SavingsBalance());

            if(i == 11)
            {
             SavingsAccount.modifyInterestRate(5);
            }
        }

    }
}