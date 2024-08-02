package Recursion.Arrays;

import java.util.ArrayList;

public class Find {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 4, 5};
        // System.out.println(find(arr, 4, 0));
        // System.out.println(findIndex(arr, 4, 0));
        // System.out.println(findIndexLast(arr, 4, arr.length - 1));
        // findAllIndex(arr, 4, 0);
        // System.out.println(list1);

        // System.out.println(findAlllIndex(arr, 4, 0, new ArrayList<>()));


        System.out.println(findAlll3Index(arr, 4, 0));





        
    }

    static boolean find(int[] arr , int target , int index){
        if (index == arr.length){
            return false ;
        }

        return (arr[index] == target) || find (arr , target , index + 1);
    }

    static int findIndex(int[] arr , int target , int index){
        if (index == arr.length){
            return -1 ;
        }

        if (arr[index] == target){
            return index ; 
        }

        return findIndex(arr, target, index + 1) ;
    }

    static int findIndexLast(int[] arr , int target , int index){
        if (index == -1){
            return -1 ;
        }

        if (arr[index] == target){
            return index ; 
        }

        return findIndex(arr, target, index - 1) ;
    }

    static ArrayList<Integer> list1 = new ArrayList<>();

    static void  findAllIndex(int[] arr , int target , int index){
        if (index == arr.length){
            return  ;
        }

        if (arr[index] == target){
            list1.add(index);
        }

        findAllIndex(arr, target, index + 1) ;
    }

    static ArrayList<Integer>  findAlllIndex(int[] arr , int target , int index , ArrayList<Integer> list){
        if (index == arr.length){
            return  list ;
        }

        if (arr[index] == target){
            list.add(index);
        }

        return findAlllIndex(arr, target, index + 1,list) ;
        
    }
    
    static ArrayList<Integer>  findAlll3Index(int[] arr , int target , int index ){
        ArrayList<Integer> list22 = new ArrayList<>() ;
        if (index == arr.length){
            return  list22 ;
        }
        // This will contain answer for that function call only
        if (arr[index] == target){
            list22.add(index);
        }

        
        ArrayList<Integer> ansFromBelowCalls = findAlllIndex(arr, target, index + 1,list22) ;

        list22.addAll(ansFromBelowCalls);

        return list22;
        
    }
}
