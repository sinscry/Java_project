package b_simpleMVC.pojo;

public class UserForm {
    private String uname;
    private String upass;
    private String reupass;

    public String getUname(){
        return this.uname;
    }
    public String getUpass(){
        return this.upass;
    }
    public String getReupass(){
        return this.reupass;
    }
    public void setUname(String uname){
        this.uname=uname;
    }
    public void setUpass(String upass){
        this.upass=upass;
    }
    public void setReupass(String reupass){
        this.reupass=reupass;
    }
}
