package Email_Client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddRecipient {

        //private String detailsToWrite;
        SendMail wish = new SendMail();

        public void addRecipient(String today) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Recipient Details \n"+"input format:=\n"+
                    "For official- Official: name,email,designation\n"
                    + "For official-friend- Office_friend: name,email,designation,Birthday\n"
                    + "For Personal- Personal: name,<nick-name>,email,Birthday");
            String detailsToWrite = scanner.nextLine();
            writeToFile(detailsToWrite,today);

        }
        public void writeToFile(String details,String today){
            try {
                String arr[] = details.split(":|\\,");
                if((!arr[0].equals("Official")) && arr[arr.length-1].substring(5,10).equals(today.substring(5,10))){
                    if(arr[0].equals("Personal")){
                        wish.personalWish(arr[3],arr[1]);
                    } else if (arr[0].equals("Office_friend")) {
                        wish.officeWish(arr[2],arr[1]);
                    }

                }

                File clientList=new File("D:\\ACA S02\\prgramming construction\\email\\email\\clientList.txt");
                if(clientList.exists()){
                    //FileWriter writer =new FileWriter("D:\\ACA S02\\prgramming construction\\email\\email\\clientList.txt",true);
                    BufferedWriter writer = new BufferedWriter(new FileWriter(clientList,true));
                    writer.write(details);
                    writer.newLine();
                    // System.out.println("written");
                    writer.close();


                }
                else{
                    try {
                        clientList.createNewFile();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    writeToFile(details,today);
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }catch(StringIndexOutOfBoundsException p){
                System.out.println("Wrong Input");
            }
        }
}

