package StackQueues.Queues;

public class QueueMain {

    public static void main(String[] args) throws Exception {
        CircularQueue queue = new CircularQueue(6);
        queue.insert(1);
        queue.insert(3);
        

        queue.remove();
        queue.remove();
        queue.remove();

        queue.display();

        System.out.println(queue.remove());

        queue.display();
        
    }
    
}
