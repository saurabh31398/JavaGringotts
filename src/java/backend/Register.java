package backend;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Register {
    public Register(){}
    public void RegistrationCheck(String name, String username, int money, String password, String Customer) throws IOException{
    
    try
    {
    boolean sameUsername = false;                         // Username already exists
    int accountNumber = 1000;
    String f = "H:\\Projects\\Database\\0Usernames.txt";
    
    BufferedWriter bWrite;
    FileWriter fWrite;
    PrintWriter out;
    
    File usernameFile = new File(f);
    FileReader fRead = new FileReader(usernameFile);
    BufferedReader bRead = new BufferedReader(fRead);
    String line;
    String registeredUsername;
    while((line = bRead.readLine()) != null)
    {
      
        String[] words = line.split("[;]");
        accountNumber++;
        if(words[0].equals(username))
        {
            sameUsername = true;
            break;
        }
    }
    if(!sameUsername)
    {
        fWrite = new FileWriter("H:\\Projects\\Database\\" + accountNumber + ".txt");
        bWrite = new BufferedWriter(fWrite);
        out = new PrintWriter(bWrite);
        out.println("hello");
        bWrite.append("hello");
    }
    
    }
    catch(IOException ex)
    {
        System.out.println(ex);
    }
    }
}
