
package bank;

import backend.Database;
import java.io.IOException;

public class Transfer {
    private int amount;
    private int accountNumberFrom;
    private int accountNumberTo;
    private boolean result;
    public void setAmount(int amount)
    {
        this.amount = amount;
    }
    public void setAccountNumberFrom(String accountNumber)
    {
        int x;
        x = Integer.parseInt(accountNumber);
        this.accountNumberFrom = x;
    }
     public void setAccountNumberTo(String accountNumber)
    {
        int x;
        x = Integer.parseInt(accountNumber);
        this.accountNumberTo = x;
    }
    public void setResult(boolean result)
    {
        this.result = result;
    }
    public boolean getResult()
    {
        return result;
    }
    public void process() throws IOException
    {
        Database d = new Database();
        boolean isTransfered = d.transferMoney(amount, accountNumberFrom, accountNumberTo);
        setResult(isTransfered);
    }
}
