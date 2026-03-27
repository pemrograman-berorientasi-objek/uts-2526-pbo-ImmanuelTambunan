/**
 * @author 12S24034 Immanuel Alexander Tambunan
 */
package fintech.driver;

import fintech.model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Account> listAccount = new ArrayList<>();

        while (input.hasNextLine()) {
            String command = input.nextLine().trim();

            if (command.equals("---")) break;

            if (command.startsWith("create-account#")) {
                String[] data = command.split("#");

                if (data.length == 3) {
                    Account acc = new Account(data[1], data[2]);
                    listAccount.add(acc);
                }
            }
        }
        for (Account acc : listAccount) {
            System.out.println(acc);
        }

        input.close();
    }
}