
import java.io.*;
import java.util.ArrayList;

public class FileService {

    private static final String FILE_NAME = "accounts.txt";

    public static void saveAccounts(ArrayList<Account> accounts) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Account acc : accounts) {
                bw.write(acc.getAccountNumber() + "," +
                         acc.getName() + "," +
                         acc.getBalance());
                bw.newLine();
            }

            System.out.println("Accounts saved successfully!");

        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    public static ArrayList<Account> loadAccounts() {
        ArrayList<Account> accounts = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return accounts;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",", 3);

                if (data.length == 3) {
                    int number = Integer.parseInt(data[0]);
                    String name = data[1];
                    double balance = Double.parseDouble(data[2]);

                    accounts.add(new Account(number, name, balance));
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading accounts: " + e.getMessage());
        }

        return accounts;
    }
}
