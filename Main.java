
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {
            System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Search Account");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Account Number: ");
                    int number = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Initial Balance: ");
                    double balance = sc.nextDouble();

                    bank.createAccount(number, name, balance);
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    number = sc.nextInt();

                    System.out.print("Deposit Amount: ");
                    double amount = sc.nextDouble();

                    bank.deposit(number, amount);
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    number = sc.nextInt();

                    System.out.print("Withdraw Amount: ");
                    amount = sc.nextDouble();

                    bank.withdraw(number, amount);
                    break;

                case 4:
                    System.out.print("Account Number: ");
                    number = sc.nextInt();

                    Account acc = bank.searchAccount(number);

                    if (acc != null) {
                        acc.displayAccount();
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    bank.displayAllAccounts();
                    break;

                case 6:
                    System.out.println("Thank you for using our bank!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
