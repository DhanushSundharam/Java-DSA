package StackQueues.Stack;

public class StackMain {

    public static void main(String[] args) throws Exception{
        
        CustomStack stack = new DynamicStack(5);

        stack.push(34);
        stack.push(45);
        stack.push(2);
        stack.push(9);
        stack.push(23);
        stack.push(96);
        stack.push(236);
        stack.push(978);
        stack.push(2365);
        



        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        


        



    }
    
}
