package FileHandling;

//import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
    //     try (InputStreamReader fr = new InputStreamReader(System.in)){
    //         System.out.println("Enter Some letters :");
    //         int letters = fr.read();
    //         while (fr.ready()){
    //             System.out.println((char) letters);
    //             letters = fr.read();
    //         }
    //         //fr.close();
    //         System.out.println();

    //     }catch (IOException e){
    //         System.out.println(e.getMessage());
    //     }

    try (FileReader fr = new FileReader("Note.txt")){
        System.out.println("Enter Some letters :");
        int letters = fr.read();
        while (fr.ready()){
            System.out.println((char) letters);
            letters = fr.read();
        }
        //fr.close();
        System.out.println();

    }catch (IOException e){
        System.out.println(e.getMessage());
    }


    //BufferedReader br = new 
    
}


        
    }
    


