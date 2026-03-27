
package fintech.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String username;
    private String name;
    private double balance;
    private List<Transaction> transactions;

    public Account(String name, String username) {
        this.name = name;
        this.username = username;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

 public void withdraw(double amount) throws NegativeBalanceException {
        if (amount > this.balance) {
            throw new NegativeBalanceException("Insufficient balance for withdrawal");
        }
        if (amount > 0) {
            this.balance -= amount;
        }
    }
    
    public void transfer(double amount, Account recipient) throws NegativeBalanceException {
        if (amount > this.balance) {
            throw new NegativeBalanceException("Insufficient balance for transfer");
        }
        if (amount > 0) {
            this.balance -= amount;
            recipient.balance += amount;
        }
    }
    
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }
    
    @Override
    public String toString() {
        return username + "|" + name + "|" + balance;
    }
}
