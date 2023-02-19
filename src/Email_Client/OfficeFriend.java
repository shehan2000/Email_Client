package Email_Client;

public class OfficeFriend implements Recipient{
    private String birthday;
    private String email;
    private String name;
    private String designation;


    public OfficeFriend(String name,String email,String designation, String birthday){
        this.name=name;
        this.email=email;
        this.birthday=birthday;
        this.designation=designation;

    }
    public String getDesignation() {
        return designation;
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
