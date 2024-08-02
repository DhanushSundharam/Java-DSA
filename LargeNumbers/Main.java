package LargeNumbers;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        //int a = 30 ;
        //int b = 67 ;

        //BigInteger A = BigInteger.valueOf(33);
        //BigInteger B = BigInteger.valueOf(334567234); // Convert int/long to BI
        //int c = B.intValue(); //convert BI to int
        BigInteger C = new BigInteger("2346756576");
        BigInteger X = new BigInteger("23467565767747667655");


       // constants

       //BigInteger D =BigInteger.ZERO ;

       //addition
       //BigInteger add = C.add(X) ; 

       //BigInteger mul = C.multiply(X);

       //BigInteger sub = C.subtract(X);

       //BigInteger div = C.divide(X);

       ///BigInteger rem = C.remainder(X);

       if (C.compareTo(X) < 0){
        System.out.println("Yes");
       }

       //System.out.println(Factorial.fact(234567));

       BD();

       int[] arr = {1,2,3,4,5};
       int i = 0;
       System.out.println(arr[i++]);

       
    
    }

    static void BD(){
        //double x = 0.03 ;
        //double y = 0.04 ;
        //double ans = y - x ;
        //System.out.println(ans);

        //BigDecimal X = new BigDecimal("0.03");
        //BigDecimal Y = new BigDecimal("0.04");
        //BigDecimal ans1 = Y.subtract(X);
        //System.out.println(ans1);

        BigDecimal a  = new BigDecimal("456253738.383788");
        BigDecimal b  = new BigDecimal("4245363738.8474839");

        // Operations
        System.out.println(b.add(a));
        System.out.println(b.subtract(a));
        System.out.println(b.multiply(a));
        System.out.println(b.pow(2));

        //constants

        BigDecimal com = BigDecimal.ONE;
        System.out.println(com); 
    }

    
    
}
