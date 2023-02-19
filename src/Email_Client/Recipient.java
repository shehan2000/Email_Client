package Email_Client;


import java.util.Scanner;

public interface Recipient {
         String birthday = null;
         String email = null;
         String name = null;
         String nickName=null;

        public default String getName() {

            return null;
        }

        public default String getBirthday() {
            return birthday;
        }

        public default String getEmail(){
            return email;
        }

    public default String getNickName() {
        return null;
    }

    }
