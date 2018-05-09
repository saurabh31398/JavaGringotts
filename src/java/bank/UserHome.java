
package bank;

import backend.Database;
import java.io.IOException;


public class UserHome {
    private String username;
    private String info;
    private String Accountbalance;
    private String customer;
    private String passbook[];
    public void setUserInfo(String username)
    {
        this.username = username;
    }
   
    public void setName(String s)
    {
        info = s; 
    }
    public String getUsername()
    {
        return username;
    }
    public void setAccountBalance(String a)
    {
        Accountbalance = a;
    }
    public void setCustomerType(String x)
    {
        customer = x;
    }
    public void setPassbook(String passbook[])
    {
        passbook = new String[10];
        this.passbook = passbook;
    }
    
    //getter methods
     public String getName()
    {
        return info;
    }
    public String getAccountBalance()
     {
         return Accountbalance;
     }
    public String getCustomerType()
    {
        return customer;
    }
    public String[] getPassbook()
    {
        return passbook;
    }
    public void process() throws IOException
    {
        Database d = new Database();
        String s[] =  d.userHomeDisplay(username);
        
        setName(s[0]);
        //setUsername(s[1])    since we already have username
        setAccountBalance(s[2]);
        setCustomerType(s[3]);
        String[] passb = new String[10];
        int j = 0;
        for(int i = 4; i < s.length ;i++)
        {
            passb[j] = s[i];
            j++;
        }
        setPassbook(passb);
    }
   
}
