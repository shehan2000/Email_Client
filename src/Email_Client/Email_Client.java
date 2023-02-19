package Email_Client;

// Index_No=200600T


import java.awt.*;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Email_Client {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        boolean x = true;

        Date thisDate = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy/MM/dd");
        String today = simpleDate.format(thisDate);

        DecriptFileData decript = new DecriptFileData();
        decript.decriptData();

        //check whether birthday wishes were sent today or not
        DeSerialization getEmailData=new DeSerialization();
        List<SendEmailTLS> mailData=getEmailData.deSerialize();

        //Sending Birthday Wishes when Starting the Client
        //code to restrict sending birthday wishes only for one time a day
        if(!mailData.get(mailData.size() - 1).date.equals(today)) {
            BirthdayWishes wish = new BirthdayWishes();
            wish.sendWishes(decript.getPersonalArray(), decript.getOfficeFriendArray());
        }
        while (x) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter option type: \n"
                    + "1 - Adding a new recipient\n"
                    + "2 - Sending an email\n"
                    + "3 - Printing out all the recipients who have birthdays\n"
                    + "4 - Printing out details of all the emails sent\n"
                    + "5 - Printing out the number of recipient objects in the application");

            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    // Use a single input to get all the details of a recipient

                    // code to add a new recipient
                    AddRecipient recipient = new AddRecipient();
                    recipient.addRecipient(today);

                    //increase the recipient count by 1
                    decript.increaseObjCount();
                    // store details in clientList.txt file

                    break;
                case 2:

                    // input format - email, subject, content

                    // code to send an email

                    SendMail mail = new SendMail();
                    mail.sendmail();

                    break;
                case 3:
                    //System.out.println("3");

                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    // code to print recipients who have birthdays on the given date
                    PrintBirthdays printbd = new PrintBirthdays();
                    printbd.printBday(decript.getPersonalArray(), decript.getOfficeFriendArray());
                    break;
                case 4:
                    //System.out.println("4");
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    System.out.println("Enter the Date you want Email Data:- \n" +"In Format of YYYY/MM/DD");
                    String iptDate=scanner.next();

                    //iptDate="2022/08/04";
                    for(int i=0;i< mailData.size();i++) {
                        if (mailData.get(i).date.equals(iptDate)) {
                            System.out.println("Sent Email Address is:- " + mailData.get(i).getEmail());
                            System.out.println("Sent Email Subject is:- " + mailData.get(i).getSubject());
                            System.out.println("Sent Email Content is:- " + mailData.get(i).getContent());
                            System.out.println("");

                        }
                    }


                    // code to print the details of all the emails sent on the input date

                    break;
                case 5:

                    // code to print the number of recipient objects in the application

                    System.out.println(decript.getObjectCount());

                    break;

            }


            // code to rerun or terminate app
            System.out.println("Do You Need Another Services\n"+
                                "Yes:= Enter 1\n"+"No:=Enter 2");
            int cliIpt = scanner.nextInt();
            if (cliIpt == 2) {
                x = false;

            }
        }
    }

}

// create more classes needed for the implementation (remove the  public access modifier from classes when you submit your code)
