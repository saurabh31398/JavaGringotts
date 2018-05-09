
package backend;

import java.io.*;

public class Database {
    public String userHomeDisplay(String username) throws IOException
    {
        String s = "";
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
        File f1 = new File("H:\\Projects\\Database\\"+ "hello1" + ".txt");
        FileWriter fwrite = new FileWriter(f1, true);
        BufferedWriter bwrite = new BufferedWriter(fwrite);
        PrintWriter out = new PrintWriter(bwrite);
        out.println("H:\\Projects\\Database\\"+ accountNumber+ ".txt");
        
 
        bwrite.close();
        out.close();

        f = "H:\\Projects\\Database\\"+ accountNumber + ".txt";
        File file1 = new File(f);
        FileReader fRead1 = new FileReader(file1);
        BufferedReader bRead1 = new BufferedReader(fRead1);
        int i = 0;
 
       while((line = bRead1.readLine())!= null )
        {   if(i < 1)
            {
                String[] words = line.split("[:]");
                s = words[1];
                i++;
            }

        }
        bRead.close();
      
      
        
        }
        catch(IOException ex)
        {}
        return s;
    }
}
