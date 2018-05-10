package backend;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Register {
    public Register(){}
    public String RegistrationCheck(String name, String username, int money, String password, String customer) throws IOException{
    
    try
    {
    boolean sameUsername = false;                         // Username already exists
    int accountNumber = 1000;
    String f = "H:\\Projects\\Database\\0Usernames.txt";
    
    BufferedWriter bWrite;
    BufferedWriter bWrite2;
    FileWriter fWrite;
    PrintWriter out;
    
    File usernameFile = new File(f);
    FileReader fRead = new FileReader(usernameFile);
    BufferedReader bRead = new BufferedReader(fRead);
    String line;
    
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
        // Entering USERNAME IN 0Usernames.txt
        File fname = new File("H:\\Projects\\Database\\0Usernames.txt");
        fWrite = new FileWriter(fname, true); //We have the permission to append the file
        bWrite = new BufferedWriter(fWrite);
        out = new PrintWriter(bWrite);
        out.println(username + ";" + password + ";" +accountNumber);
        
        // Making a new txt file for new successfully registered user
        File userFile = new File("H:\\Projects\\Database\\" + accountNumber + ".txt");
        fWrite = new FileWriter(userFile, true); //We have the permission to append the file
        bWrite2 = new BufferedWriter(fWrite);
        out = new PrintWriter(bWrite2);
        out.println("Name :" + name + ":");
        out.println("USERNAME :" + username + ":" );
        out.println("Account Number :" + accountNumber + ":");
        out.println("Account Balance:" + money + ":");
        out.println("CUSTOMER :" + customer + ":" );
        out.println("PASSBOOK:");
        
        
        
        bWrite.close();
        bWrite2.close();
        
    }
  
    else
    {
        String s = "OOPS!!! Username already taken. Choose some other username."; 
        return s;
    }
    }
    catch(IOException ex)
    {
        System.out.println(ex);
    }
    String s = "Your are now registered user of Gringotts!!! CONGRATULATIONS!";
        return s;
    }
}
