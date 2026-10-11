
import java.util.ArrayList;

public class BankService {
    private ArrayList<Account> accounts;

    public BankService() {
        accounts = FileService.loadAccounts();
        System.out.println("Accounts loaded: " + accounts.size());
    }

    public void createAccount(int accountNumber, String name, double balance) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                System.out.println("Account already exists!");
                return;
            }
        }

        if (balance < 0) {
            System.out.println("Invalid initial balance!");
            return;
        }

        Account account = new Account(accountNumber, name, balance);
        accounts.add(account);

        FileService.saveAccounts(accounts);
        System.out.println("Account created successfully!");
    }

    public Account searchAccount(int accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber() == accountNumber) {
                return acc;
            }
        }
        return null;
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available!");
            return;
        }

        for (Account acc : accounts) {
            acc.displayAccount();
            System.out.println("-------------------");
        }
    }

    public void deposit(int accountNumber, double amount) {
        Account acc = searchAccount(accountNumber);

        if (acc != null) {
            acc.deposit(amount);
            FileService.saveAccounts(accounts);
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account acc = searchAccount(accountNumber);

        if (acc != null) {
            acc.withdraw(amount);
            FileService.saveAccounts(accounts);
        } else {
            System.out.println("Account not found!");
        }
    }
}
