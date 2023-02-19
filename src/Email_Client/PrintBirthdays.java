package Email_Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintBirthdays {
   private int i=0;

    List<String> bdaylist = new ArrayList();
    public void printBday(List<Personal> personArr, List<OfficeFriend> officeFriArr){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The Date you Want Birthday list, in format: \nYYYY/MM/DD");
        String date = scanner.next();

        while(i<personArr.size()){

            if (personArr.get(i).getBirthday().equals(date)) {
                bdaylist.add(personArr.get(i).getName());
            }
            i++;

        }
        i=0;
        while(i<officeFriArr.size()){

            if (officeFriArr.get(i).getBirthday().equals(date)) {
                bdaylist.add(officeFriArr.get(i).getName());
            }
            i++;

        }
        i=0;
    while(i<bdaylist.size()){
        System.out.println(bdaylist.get(i));
        i++;
    }

    }
}
