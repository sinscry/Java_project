package Profile;

public class Data_prod implements Data{
    private String name="Data_prod";
    public Data_prod(String message){
        this.name=message;
    }
    public Data_prod(){
    }
    public void play(){
        System.out.println("Data_prod play!");
    }
    public String getName(){
        return name;
    }
}
