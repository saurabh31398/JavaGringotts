package bank;

import backend.Register;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignIn { //JavaBean
    private String name;
    private String username;
    private int money;
    private String password;
    private String customer;
    private String result;
    
    //setter methods
    public void setNam(String name)
    {
        this.name = name;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public void setMoney(int money)
    {
        this.money = money;
    }
    public void setPass(String password)
    {
        this.password = password;
    }
    public void setCustomer(String customer)
    {
        this.customer = customer;
    }
    
    //getter methods
    public String getNam()
    {
        return name;
    }
    public String getUsername()
    {
        return username;
    }
    public int getMoney()
    {
        return money;
    }
    public String getPass()
    {
        return password;
    }
    public String getCustomer()
    {
        return customer;
    }
    public void setResult(String registration)
    {
        result = registration;
    }
    public String getResult()
    {
        return result;
    }
    
    public void process() throws IOException
    {
        Register reg;
        reg = new Register();
        String registration;
        registration = "Sorry Some Error Occured while Resgistring. TRY AGAIN!!! ";
        
        
           registration = reg.RegistrationCheck(name, username, money, password, customer);
           setResult(registration);
        
        

    }

    
}  

