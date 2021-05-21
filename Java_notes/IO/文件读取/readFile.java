import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class readFile {
    public static void main(String args[]) throws IOException{
        InputStream input=null;
        try{
            input = new FileInputStream("./readme.txt");
            int n;
            while((n=input.read())!=-1){
                System.out.println(n);
            }
        }finally{
            if(input!=null){
                input.close();
            }
        }
    }
}