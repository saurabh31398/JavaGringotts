
package bank;

import backend.Database;
import java.io.IOException;


public class UserHome {
    private String username;
    private String info;
    public void setUserInfo(String username)
    {
        this.username = username;
    }
    public String getName()
    {
        return info;
    }
    public void setName(String s)
    {
        info = s; 
    }
    public void process() throws IOException
    {
        Database d = new Database();
        String s;
        s = "saurabh";
        s = d.userHomeDisplay(username);
        setName(s);
    }
   
}
