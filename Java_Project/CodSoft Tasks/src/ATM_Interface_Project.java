import java.util.InputMismatchException;
import java.util.Scanner;

class Account {
    private double currentBalance;

    public Account(double startingAmount) {
        if (startingAmount >= 0) {
            currentBalance = startingAmount;
        } else {
            currentBalance = 0;
        }
    }

    public double checkBalance() {
        return currentBalance;
    }

    public void addMoney(double value) {
        currentBalance += value;
    }

    public boolean removeMoney(double value) {
        if (value <= currentBalance) {
            currentBalance -= value;
            return true;
        }
        return false;
    }
}

class ATMSystem {
    private Account userAcc;
    private Scanner input;

    public ATMSystem(Account acc) {
        userAcc = acc;
        input = new Scanner(System.in);
    }

    private void showOptions() {
        System.out.println("\n========== ATM MENU ==========");
        System.out.println("1 -> View Balance");
        System.out.println("2 -> Add Funds");
        System.out.println("3 -> Withdraw Funds");
        System.out.println("4 -> Quit");
        System.out.println("==============================");
    }

    private void processDeposit() {
        System.out.print("Enter amount to deposit: Rs. ");
        double amt = input.nextDouble();

        if (amt > 0) {
            userAcc.addMoney(amt);
            System.out.println("Deposit completed successfully.");
        } else {
            System.out.println("Error: Amount must be positive.");
        }
    }

    private void processWithdrawal() {
        System.out.print("Enter amount to withdraw: Rs. ");
        double amt = input.nextDouble();

        if (amt <= 0) {
            System.out.println("Error: Invalid amount.");
        } else if (userAcc.removeMoney(amt)) {
            System.out.println("Withdrawal completed successfully.");
        } else {
            System.out.println("Error: Insufficient balance.");
        }
    }

    private void showBalance() {
        System.out.printf("Current Balance: Rs. %.2f\n", userAcc.checkBalance());
    }

    public void startATM() {
        int option = 0;

        System.out.println("Welcome to Secure ATM System");

        while (option != 4) {
            showOptions();

            try {
                System.out.print("Select option: ");
                option = input.nextInt();

                switch (option) {
                    case 1:
                        showBalance();
                        break;

                    case 2:
                        processDeposit();
                        break;

                    case 3:
                        processWithdrawal();
                        break;

                    case 4:
                        System.out.println("Session ended. Thank you!");
                        break;

                    default:
                        System.out.println("Invalid option selected.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter valid numeric input.");
                input.next();
            }
        }
    }
}

public class ATM_Interface_Project {
    public static void main(String[] args) {
        Account myAccount = new Account(100000);
        ATMSystem atmMachine = new ATMSystem(myAccount);
        atmMachine.startATM();
    }
}
