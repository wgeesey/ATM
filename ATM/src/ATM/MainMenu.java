package ATM;

import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

public class MainMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat money = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(987678, 990089);
                data.put(887654, 682234);
                data.put(987654, 123456);
                data.put(567890, 987654);

                System.out.println("Welcome to XBank ATM!");
                System.out.println("Please enter your customer number (or type EXIT to exit):");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Please enter your PIN Number:");
                setPin(menuInput.nextInt());
            } catch (InputMismatchException e) {
                if (menuInput.hasNext("EXIT")) {
                    x = 2;
                    System.out.println("Thank you for using our ATM! \n\n");
                    break;
                } else {
                    System.out.println("\n Invalid Input, please use numbers only. \n");
                }
            }
            int cn = getCustomerNumber();
            int pn = getPin();
            if (data.containsKey(cn) && data.get(cn) == pn) {
                getAccountType();
            } else
                System.out.println("\n The Customer Number or Pin Number provided is incorrect. \n");
        } while (x == 1);
    }

    public void getAccountType() {
        System.out.println("Select the Account you want to access:");
        System.out.println("1: Checking Account");
        System.out.println("2: Savings Account");
        System.out.println("3: Exit");

        int selection = menuInput.nextInt();

        switch(selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSavings();
                break;

            case 3:
                System.out.println("Thank you for using our ATM! \n\n");
                break;

            default:
                if (menuInput.hasNext("EXIT")) {
                    break;
                } else {
                    System.out.println("\n Invalid choice, please select 1,2 or 3. \n");
                    getAccountType();
                }
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Press 1 to view balance.");
        System.out.println("Press 2 to withdraw funds.");
        System.out.println("Press 3 to make a deposit.");
        System.out.println("Press 4 to exit.");
        System.out.println("Your selection: ");

        int selection = menuInput.nextInt();

        switch(selection) {
            case 1:
                System.out.println("Checking Account balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using our ATM! ");
                break;

            default:
                System.out.println("\n Invalid choice, please select 1, 2, 3 or 4. \n");
                getChecking();
        }
    }

    public void getSavings() {
        System.out.println("Savings Account: ");
        System.out.println("Press 1 to view balance.");
        System.out.println("Press 2 to withdraw funds.");
        System.out.println("Press 3 to make a deposit.");
        System.out.println("Press 4 to exit.");
        System.out.println("Your selection: ");

        int selection = menuInput.nextInt();

        switch(selection) {
            case 1:
                System.out.println("Savings Account balance: " + moneyFormat.format(getSavingsBalance()));
                getAccountType();
                break;

            case 2:
                getSavingsWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingsDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank you for using our ATM! ");
                break;

            default:
                System.out.println("\n Invalid choice, please select 1, 2, 3 or 4. \n");
                getSavings();
        }
    }
}
