
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
        else if(i == 2)                                      // For ACCOUNT BALANCE
            {
                String[] words = line.split("[:]");
                s[2] = words[1];
            }
        else if(i == 3)                                      // For WIZARD/ WITCH/ HOGWARTS STUDENT
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
}
