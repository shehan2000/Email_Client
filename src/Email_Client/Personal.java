package Email_Client;

public class Personal implements Recipient{
    private String birthday;
    private String email;
    private String name;
    private String nickName;

    public Personal(String name,String nickName,String email, String birthday){
            this.name=name;
            this.email=email;
            this.birthday=birthday;
            this.nickName=nickName;

        }
    public String getNickName() {
        return nickName;
    }
    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmail(){
        return email;
    }

}





