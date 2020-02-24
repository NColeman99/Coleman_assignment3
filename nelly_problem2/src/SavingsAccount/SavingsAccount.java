package SavingsAccount;
import java.util.Scanner;
public class SavingsAccount 
{
    private static double annualInterestRate;

    private double savingsBalance;

    public void calculateMonthlyInterest(){
        savingsBalance += (savingsBalance * annualInterestRate / 12.0);
    }

    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }

    public void SavingsBalance(double balance){
        savingsBalance = balance;
    }

    public SavingsAccount(double balance){
        SavingsBalance(balance);
    }

    public double SavingsBalance(){
        return savingsBalance;
    }
}