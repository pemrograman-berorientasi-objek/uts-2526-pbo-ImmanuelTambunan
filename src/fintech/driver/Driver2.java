/**
 * @author 12S24034 Immanuel Alexander Tambunan
 */
package fintech.driver;

import fintech.model.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Driver2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Account> accountMap = new LinkedHashMap<>();
        List<Transaction> transaksi = new ArrayList<>();
        int idTransaksi = 1;

        while (input.hasNextLine()) {
            String command = input.nextLine().trim();

            if (command.equals("---")) break;

            String[] data = command.split("#");

            if (command.startsWith("create-account#")) {
                if (data.length == 3) {
                    accountMap.put(data[2], new Account(data[1], data[2]));
                }

            } else if (command.startsWith("deposit#")) {
                if (data.length == 5) {
                    Account acc = accountMap.get(data[1]);

                    if (acc != null) {
                        double amount = Double.parseDouble(data[2]);

                        acc.deposit(amount);

                        Transaction t = new DepositTransaction(
                                idTransaksi++, data[1], amount, data[3], data[4]);

                        acc.addTransaction(t);
                        transaksi.add(t);
                    }
                }

            } else if (command.startsWith("withdraw#")) {
                if (data.length == 5) {
                    Account acc = accountMap.get(data[1]);

                    if (acc != null) {
                        try {
                            double amount = Double.parseDouble(data[2]);
                            acc.withdraw(amount);

                            Transaction t = new WithdrawTransaction(
                                    idTransaksi++, data[1], amount, data[3], data[4]);

                            acc.addTransaction(t);
                            transaksi.add(t);

                        } catch (NegativeBalanceException e) {
                            // diabaikan jika saldo jadi negatif
                        }
                    }
                }
            }
        }

        for (Account acc : accountMap.values()) {
            System.out.println(acc);
        }

        input.close();
    }
}