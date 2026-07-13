import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // object of scanner

        int pass = 0;
        boolean status = true;
        int attempts = 0;
        double balance = 2500.75;

        do {

            while (attempts < 3 && pass != 1234) {

                System.out.println("Enter Pass");
                pass = sc.nextInt();
                attempts++;

                if (attempts == 3 && pass != 1234) {
                    System.out.println("ur account has been locked");
                    return; // to exit the whole method
                }

                if (pass == 1234) {
                    attempts = 0;
                }
            }

            System.out.println(
                "========= ATM =========\n" +
                "1. Check Balance\n" +
                "2. Deposit\n" +
                "3. Withdraw\n" +
                "4. Show Account Status\n" +
                "5. Exit\n" +
                "======================="
            );

            System.out.println("Enter Option");
            int option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.println("Balance " + balance);
                    break;

                case 2:
                    System.out.println("Enter Deposit amount");
                    int deposit = sc.nextInt();

                    if (deposit > 0) {
                        balance = balance + deposit;
                        System.out.println("Balance " + balance);
                    } 
                    else {
                        System.out.println("Invalid Amount");
                        break;
                    }

                    break;

                case 3:
                    System.out.println("Enter withdraw amount");
                    int withdraw = sc.nextInt();

                    if (withdraw == 0) {
                        System.out.println("Transaction Cancelled");
                    } 
                    else if (withdraw > 0 && withdraw <= balance && withdraw < 4000) {
                        balance = balance - withdraw;
                        System.out.println("Balance " + balance);
                    } 
                    else {
                        System.out.println("Insufficiant balance");
                        break;
                    }

                    if (balance == 0) {
                        System.out.println("Warning! Your account is empty");
                    }

                    break;

                case 4:
                    if (balance >= 5000) {
                        System.out.println("VIP Customer");
                    } 
                    else if (balance > 1000 && balance <= 4999.99) {
                        System.out.println("Regular Customer");
                    } 
                    else {
                        System.out.println("Low Balance");
                    }

                    break;

                case 5:
                    System.out.println("Thanks for using our ATM");
                    status = false;
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (status); // no while(1)

    }
}