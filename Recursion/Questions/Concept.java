package Recursion.Questions;

public class Concept {

    public static void main(String[] args) {
        fun(5);
        
    }
    static void fun(int n){

        if (n == 0){
            return ;
        }

        System.out.println(n);
        fun(--n);
        //fun(n--);
        // int n = 5;
        // System.out.println(--n); // This will output 4 because n is decremented first, then used.
        
        // System.out.println(n--); // This will output 4 too because the current value of n (which is 4 now) is used first, then decremented.
        

    }
    
}
