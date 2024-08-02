package LargeStrings;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;
public class Main {

    public static void main(String[] args) {

        //int x =97 + (int)('r');
        // constructor 1
        StringBuffer sb = new StringBuffer() ;
        System.out.println(sb.capacity());

        //constructor 2
        //StringBuffer sb2 = new StringBuffer("Dhanush");

        //constructor 3
        StringBuffer sb3 = new StringBuffer(30);
        System.out.println(sb3.capacity());


        sb.append("WeMakeDevs");
        sb.append(" is nice!");
        //sb.insert(2, "steve Jobs");

        sb.replace(1, 5,"Dhanush");
        sb.delete(1,5);
 
        //sb.reverse();

        String str  = sb.toString();
        System.out.println(str);

        Random random = new Random() ;
        System.out.println(random.nextFloat());

        System.out.println((char)(97+1));

        int n = 20 ;
        String name = RandomString.generate(n);
        System.out.println(name);


        // remove whitespaces

        String sentence = "hi h   hjh hjkso  siowi   w";
        System.out.println(sentence);

        System.out.println(sentence.replaceAll("\\s", ""));

        // split 

        String arr = "Kunal ,Apoorv ,Rahul ,snehal";
        String[] names = arr.split(",");
        System.out.println(Arrays.toString(names));


        // Rounding off
        DecimalFormat df = new DecimalFormat("0.0000"); 
        System.out.println(df.format(7.245365));
    }

    
    
}
