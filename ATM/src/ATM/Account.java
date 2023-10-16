package ATM;

import java.text.DecimalFormat;
import java.util.*;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    private int customerNumber, pin;
    private double checkingBalance = 0;
    private  double savingsBalance = 0;

    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public int setPin(int pin) {
        this.pin = pin;
        return pin;
    }

    public int getPin() {
        return pin;
    }

    public double getCheckingBalance() {
        return checkingBalance;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    public double calcSavingsWithdraw(double amount) {
        savingsBalance = (savingsBalance - amount);
        return savingsBalance;
    }

    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    public double calcSavingsDeposit(double amount) {
        savingsBalance = (savingsBalance + amount);
        return savingsBalance;
    }

    public void getCheckingWithdrawInput() {
        System.out.println("Current Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount to withdraw: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Remaining Balance cannot be negative. \n");
        }
    }

    public void getSavingsWithdrawInput() {
        System.out.println("Current Savings Account Balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Amount to withdraw: ");
        double amount = input.nextDouble();

        if ((savingsBalance - amount) >= 0) {
            calcSavingsWithdraw(amount);
            System.out.println("New Savings Balance: " + moneyFormat.format(savingsBalance));
        } else {
            System.out.println("Remaining Balance cannot be negative. \n");
        }
    }

    public void getCheckingDepositInput() {
        System.out.println("Current Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.println("Amount to deposit: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Remaining Balance cannot be negative. \n");
        }
    }

    public void getSavingsDepositInput() {
        System.out.println("Current Savings Account Balance: " + moneyFormat.format(savingsBalance));
        System.out.println("Amount to deposit: ");
        double amount = input.nextDouble();

        if ((savingsBalance + amount) >= 0) {
            calcSavingsDeposit(amount);
            System.out.println("New Savings Balance: " + moneyFormat.format(savingsBalance));
        } else {
            System.out.println("Remaining Balance cannot be negative. \n");
        }
    }



}
