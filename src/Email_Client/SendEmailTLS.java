package Email_Client;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class SendEmailTLS implements Serializable {
private String subject;
private String content;
private String email;
    //Serialization ser=new Serialization();
    Date thisDate = new Date();
    SimpleDateFormat simpleDate = new SimpleDateFormat("y/MM/dd");

    String date = simpleDate.format(thisDate);

    public SendEmailTLS(String email,String subject, String content) {
        this.subject = subject;
        this.content = content;
        this.email=email;
        this.date=date;
    }

    public void sendEmail() throws IOException{

        final String username = "malithshehan2000@gmail.com";
        final String password = "qgknizxgbayczwqd";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("malithshehan2000@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subject);
            message.setText(content);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public String getEmail(){
        return email;

    }
    public String getSubject(){
        return subject;
    }
    public String getContent(){
        return content;
    }






}