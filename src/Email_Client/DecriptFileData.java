package Email_Client;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//code to read client list
public class DecriptFileData  {
    private static int objCount;

    List<Personal> personalObjArray = new ArrayList();
    List<Official> officialObjArray = new ArrayList();
    List<OfficeFriend> officeFriendObjArray = new ArrayList();
    public void decriptData() {
        String details;

        Date thisDate = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd");

        String date = simpleDate.format(thisDate);



        SendMail send = new SendMail();

        File clientList = new File("D:\\ACA S02\\prgramming construction\\email\\email\\clientList.txt");
        if (clientList.exists()) {
            try (BufferedReader read = new BufferedReader(new FileReader(clientList))) {
                while ((details = read.readLine()) != null) {


                    String arr[] = details.split(":|\\,");

                    if(arr[0].equals("Official")){
                        officialObjArray.add(new Official(arr[1],arr[2],arr[3]));

                        objCount++;
                    }
                    else if(arr[0].equals("Personal")){
                        personalObjArray.add(new Personal(arr[1],arr[2],arr[3],arr[4]));

                        objCount++;
                    }
                    else if(arr[0].equals("Office_friend")){
                        officeFriendObjArray.add(new OfficeFriend(arr[1],arr[2],arr[3],arr[4]));

                        objCount++;
                    }
                    else{
                        System.out.println("Wrong Input");
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("No Details Exists");
        }


    }

    //Returning arrays including the objects in the txt file
    public List getOfficeFriendArray(){
        return(officeFriendObjArray);
    }
    public List getOfficialArray(){
        return(officialObjArray);
    }
    public List getPersonalArray(){
        return(personalObjArray);
    }
    public int getObjectCount(){
        return(objCount);
    }

    public void increaseObjCount() {
        objCount++;
    }
}

