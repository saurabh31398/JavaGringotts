
package backend;

import java.io.*;

public class Database {
    public String[] userHomeDisplay(String username) throws IOException
    {
        String s[] = new String[10];
     try{
         
        String f = "H:\\Projects\\Database\\0Usernames.txt";
        File file = new File(f);
        FileReader fRead = new FileReader(file);
        BufferedReader bRead = new BufferedReader(fRead);
        String line;
        int accountNumber = 1000;
        int x = 1000;
        while((line = bRead.readLine())!= null)
        {
            
            String[] words = line.split("[;]");
            if(words[0].equals(username))
            {
                break;
            }
            accountNumber++;
            
        }

        f = "H:\\Projects\\Database\\"+ accountNumber + ".txt";
        File file1 = new File(f);
        FileReader fRead1 = new FileReader(file1);
        BufferedReader bRead1 = new BufferedReader(fRead1);
        int i = 0;
 
       while((line = bRead1.readLine())!= null )
        {   
        if(i == 0)                                   // For NAME
            {
                String[] words = line.split("[:]");
                s[0] = words[1];
            }
        else if(i == 1)                                      // For USERNAME but since we already have it so we just make a set method in UserHome.java
            {
                String[] words1 = line.split("[:]");
                s[1] = words1[1];
            }
        else if(i == 2)                                      // For ACCOUNT NUMBER
            {
                String[] words = line.split("[:]");
                s[2] = words[1];
            }
        else if(i == 3)                                      // For ACCOUNT BALANCE
            {
                String[] words = line.split("[:]");
                s[3] = words[1];
            }
        else if(i == 4)                                      // For WIZARD/ WITCH/ HOGWARTS STUDENT
            {
                String[] words = line.split("[:]");
                s[i] = words[1];
            }
        else if(i > 4)                                       //For Passbook
            {
                s[i] = line;
            }
        i++;
        }
        } 
        catch(IOException ex)
        {}
        return s;
    }
    
    public boolean transferMoney(int moneyToBeTransfered, int accountNumberFrom, int accountNumberTo) throws FileNotFoundException, IOException, NullPointerException
    {
        boolean result = true;
        boolean isBalanceEnough = false;
        int accountBalanceFrom = 0;
        int accountBalanceTo = 0;
        // To store old account balance of users so that we can replace them with new account balance after money transfer
        String oldAccountBalanceFrom = "";
        String oldAccountBalanceTo = "";
        
        String oldContent = "";
        String oldContent1 = "";

        String newContent;
        String newContent1;  
        
        String f = "H:\\Projects\\Database\\"+ "1000"+".txt";
        String fromAddress = "H:\\Projects\\Database\\"+ accountNumberFrom +".txt"; 
        String toAddress = "H:\\Projects\\Database\\"+ "1001" +".txt";
        File file = new File(f);
        if(!file.exists())
            return false;
        FileReader fRead = new FileReader(file);
        BufferedReader bRead = new BufferedReader(fRead);
        FileReader fRead2 = new FileReader(file);
        BufferedReader bRead2 = new BufferedReader(fRead2);
        
//        File fname = new File(fromAddress);
//        FileWriter fWrite = new FileWriter(fname, true); 
//        BufferedWriter bWrite = new BufferedWriter(fWrite);
//        PrintWriter out = new PrintWriter(bWrite);

        
        
        String line;
        int i = 0;
        while((line = bRead.readLine()) != null && i < 4)
        {       
            if(i == 3)
            {
                
                String[] words = line.split("[:]");
                accountBalanceFrom = Integer.parseInt(words[1]);
                isBalanceEnough = accountBalanceFrom > moneyToBeTransfered;
                if(!isBalanceEnough)
                    return false;
            }
            i++;
        }
    
        
            i = 0;
            file = new File(f);
            if(!file.exists())
                return false;
            fRead = new FileReader(file);
            bRead = new BufferedReader(fRead);
            while((line = bRead.readLine()) != null && i <= 4)
            {       
                if(i == 3)                                   //Since account balance is on 4th line
                {
                    oldAccountBalanceFrom = line;
                    String[] words = line.split("[:]");
                    accountBalanceFrom = Integer.parseInt(words[1]);
                    accountBalanceFrom = accountBalanceFrom - moneyToBeTransfered;
                            
                    FileWriter writer = new FileWriter(f, true);
                    line.replaceFirst(line, "Account Balance:" + accountBalanceFrom + ":");
                    writer.close();
                    break;
                }
                i++;
            }
            File file2;
            file2 = new File(toAddress);
            if(!file2.exists())
                return false;
            i = 0;
            fRead2 = new FileReader(file2);
            bRead2 = new BufferedReader(fRead2);
            while((line = bRead2.readLine()) != null || i <= 4)
            {       
                if(i == 3)
                {

                    oldAccountBalanceTo = line;
                    String[] words = line.split("[:]");
                    oldContent = line;
                    accountBalanceTo = Integer.parseInt(words[1]);
                    accountBalanceTo = accountBalanceTo + moneyToBeTransfered;
                    oldContent1 = words[1];

                    break;
                }
                i++;
            }
            FileWriter writer1 = new FileWriter(toAddress, true);
            writer1.write(oldContent.replace(oldContent1, String.valueOf(accountBalanceTo)));
            writer1.close();
            //http://javaconceptoftheday.com/modify-replace-specific-string-in-text-file-in-java/
            bRead.close();
           
            
        
    return true;
    }
}
