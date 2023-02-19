package Email_Client;

public class Official implements Recipient {
    private String designation;
    private String email;
    private String name;




    public Official(String name,String email, String designation){
        this.name=name;
        this.email=email;
        this.designation=designation;

    }
    public String getDesignation() {
        return designation;
    }
    public String getName() {
        return name;
    }



    public String getEmail(){
        return email;
    }

}
