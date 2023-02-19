package Email_Client;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BirthdayWishes{
    List<Personal> personalObjArray = new ArrayList();
    List<Official> officialObjArray = new ArrayList();
    List<OfficeFriend> officeFriendObjArray = new ArrayList();
    private int i=0;
    SendMail send = new SendMail();
    public void sendWishes(List<Personal> personArr, List<OfficeFriend> officeFriArr) throws IOException {
        String details;

        Date thisDate = new Date();
        SimpleDateFormat simpleDate = new SimpleDateFormat("MM/dd");

        String date = simpleDate.format(thisDate);





            while(i<personArr.size()){

                if (personArr.get(i).getBirthday().substring(5,10).equals(date)) {
                    send.personalWish(personArr.get(i).getEmail(),officeFriArr.get(i).getName());
                }
                i++;

            }
            i=0;
            while(i<officeFriArr.size()){

                if (officeFriArr.get(i).getBirthday().substring(5,10).equals(date)) {
                    send.officeWish(officeFriArr.get(i).getEmail(),officeFriArr.get(i).getName());
                }
                i++;
        }
    }


}
