package Email_Client;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
   // private Object Email_Details;

    public void serialize(SendEmailTLS mailObj) throws IOException {
        //File serFile=new File("Sent_Mail.ser");
        FileOutputStream fos=new FileOutputStream("Sent_Mail.ser",true);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(mailObj);
        oos.close();
        fos.close();
    }
}
