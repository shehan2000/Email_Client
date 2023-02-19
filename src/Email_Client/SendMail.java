package Email_Client;

import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class SendMail implements Serializable{
    private static final long serialVersionUID = -5586361169800455323L;
    Serialization ser=new Serialization();
    public void sendmail() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter mail details in format: \n"
                + "Email Address, Subject, Content"

        );
        try {
            String userData = scanner.nextLine();
            //System.out.println(userData);
            String arr[] = userData.split("\\,", 3);
            String email = arr[0];
            String subject = arr[1];

            String content = arr[2];

            // code to send an email
            SendEmailTLS sendmail = new SendEmailTLS(email, subject, content);

            sendmail.sendEmail();
            ser.serialize(sendmail);
        }
        catch(ArrayIndexOutOfBoundsException p){
            System.out.println("Wrong input type");
        }
    }
    //codes to send birthday wishes

    //for office friend
    public void officeWish(String mailAddress,String name) throws IOException {
        SendEmailTLS sendmail= new SendEmailTLS(mailAddress,"Birthday Wishes For You", "Wish you a Happy Birthday "+ name);
        sendmail.sendEmail( );
        ser.serialize(sendmail);

    }
    //for personal recipient
    public void personalWish(String mailAddress,String name) throws IOException {
        SendEmailTLS sendmail= new SendEmailTLS(mailAddress,"Birthday Wishes For You","May the joy that you have spread in the past come back to you on this day. Wishing you a very happy birthday! "+name);
        sendmail.sendEmail();
        ser.serialize(sendmail);
    }
}
