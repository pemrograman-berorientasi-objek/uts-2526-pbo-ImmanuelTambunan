
package fintech.model;

public class WithdrawTransaction extends Transaction {

    public WithdrawTransaction(int id, String username, double amount, String timestamp, String description) {
        super(id, username, amount, timestamp, description);
    }
    @Override

    public String getType() {
        return "withdraw";
    }
    @Override
    
    public String toString() {
        return id + "|" + getType() + "|" + (-amount) + "|" + timestamp + "|" + description;
    }

}
