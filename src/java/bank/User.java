
package bank;

public class User {
    
    public User() {}
    
    private String uid;
    private String pass;

    /**
     *
     * @param userName
     */
    public void setUnm(String userName)
    {
        uid = userName;
    }
     public void setPass(String pass)
    {
        this.pass = pass;
    }
    public String getNm()
    {
        return uid;
    }
     public String getPass()
    {
        return pass;
    }
     
    
}
