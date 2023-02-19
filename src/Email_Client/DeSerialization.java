package Email_Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeSerialization {
    List<SendEmailTLS>  mailData= new ArrayList();

//code to deseurialize data
    public List deSerialize() throws IOException, ClassNotFoundException {

        try {

            FileInputStream fis = new FileInputStream("Sent_Mail.ser");

            ObjectInputStream ois = null;
            while (true) {
                try {
                    ois = new ObjectInputStream(fis);
                    SendEmailTLS fileD = (SendEmailTLS) ois.readObject();

                    mailData.add(fileD);



                } catch (EOFException lol) {

                    break;
                }


            }
            ois.close();
            fis.close();


        }
        catch (IOException no){
            System.out.println("No File Detected");
        }
        //System.out.println("All Data Printed");
        return mailData;
    }

}
