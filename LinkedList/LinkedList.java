public class LinkedList {
    private Node head ;
    private Node tail ;
    private int  size ;

   
    public LinkedList(){
            this.size = 0 ;
        }


    @SuppressWarnings("unused")
    private class Node {

        private int value ;
        private Node next ;

        public Node (int value){
            this.value = value ;
        }

        public Node (int value , Node next){
            this.value = value ;
            this.next = next ;
        }
    }
    
    

    public void insertFirst (int val){
        Node node = new Node (val);
        node.next = head ;
        head = node ;

        if (tail == null){
            tail = head ;
        }

        size = size + 1;
    }
    
    public void insertLast (int val){
        if (tail == null){
            insertFirst(val);
            return ;
        }

        
        Node node = new Node(val);
        tail.next = node ;
        tail = node ;
        size ++ ;
    }
    
    public void insert (int val ,  int index){
        if (index == 0){
            insertFirst(val);
            return ;
        }

        if (index == size){
            insertLast(val);
            return ;
        }
        Node temp = head ;
        for (int i = 1; i < index; i++) {
            temp = temp.next ;
        }

        Node node = new Node (val);
        node.next = temp.next ;
        temp.next = node ;
        
    }

    //insert using recursion
    public void insertRec(int val , int index){

        head = insertRec(val, index, head);

    }

    private Node insertRec (int val ,int index , Node node){
        if (index == 0){
            Node temp = new Node (val ,node);
            size ++ ;
            return temp ;
        }

        node.next = insertRec (val , index-1 , node.next) ;
        return node ;


    }
    
    public int deleteFirst(){
        int val = head.value ;
        head = head.next ;
        if (head == null){
            tail = null;
        }
        return val ;
    }
    
    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }

        Node secondlast = get(size - 2);
        int val = tail.value ;
        tail = secondlast ;
        tail.next = null ;

        return val ;

    }

    public int delete (int index){
        if (index == 0){
            return deleteFirst();
        }
        if (index == size - 1){
            return deleteLast() ;
        }
        Node prev = get (index - 1);
        int value = prev.next.value ;
        prev.next = prev.next.next ;

        return value ;
    }


    public Node get (int index){
        Node node = head ;
        for (int i = 0; i < index ; i++) {
            node = node.next ;
            
        }

        return node ;
    }
    
    public Node find (int value){
        Node node = head ;
        while (node != null){
            if (node.value == value){
                return node ;
            }

            node = node.next ;
        }

        return null ;
    }
    
    //questions

    public void duplicates (){
        Node node =  head ;
        
        while (node.next != null){
            if (node.value == node.next.value){
                node.next = node.next.next ;
                size -- ;
            }else {
                node = node.next ;
            }
        }
        tail = node ;
        tail.next = null ;
    }

    public Node duplicates2 (Node node){
        if (node == null){
            return node;
        }
        
        while (node.next != null){
            if (node.value == node.next.value){
                node.next = node.next.next ;
                size -- ;
            }else {
                node = node.next ;
            }
        }

        return head ;
       
    }

    public static LinkedList merge (LinkedList first ,LinkedList second){
        Node f = first.head ;
        Node s = second.head ;

        LinkedList ans = new LinkedList() ;

        while ( f != null && s != null){
            if (f.value < s.value){
                ans.insertLast(f.value);
                f = f.next ;
            }
            else {
                ans.insertLast(f.value);
                s = s.next;
            }
        }

        while ( f != null){
            ans.insertLast(f.value);
            f = f.next ;

        }

        while ( s != null){

            ans.insertLast(s.value);
            s = s.next ;

            
        }

        return ans ;

    }
    
    public boolean hasCycle (){
        Node fast = head ;
        Node slow = head ;

        while  (fast != null & fast.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
            if (slow == fast){
                return true ;
            }
        }

        return false ;
    }

    public Node whereCycleStart(Node head){
        int length = 0;

        Node fast = head ;
        Node slow = head ;

        while (fast != null && fast.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
            if (slow == fast){
                length = lengthCycle(slow);
                break ;
            }
        }

        if (length == 0){
            return null ;
        }

        Node f = head ;
        Node s = head ; 
        while (length > 0){
            s = s.next ;
            length -- ;
        }
        while (f != s){
            f = f.next ;
            s = s.next ;
        }
        return s ;
    }

    public int lengthCycle(Node head){
        Node fast = head ; 
        Node slow = head ; 

        while (fast != null && fast.next != null){
            fast = fast.next.next ;
            slow = slow.next ;
            if (fast == slow){
                Node temp = slow ;
                int length = 0 ;
                do {
                    temp = temp.next ;
                    length++;
                }while (temp != slow);
                return length ;
            }

        }
        return 0 ;
    }

    public boolean isHappy(int n){
        int slow = n ;
        int fast = n ;

        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));

        }while (slow != fast);

        if (slow == 1){
            return true ;
        }

        return false ; 


    }
    private int findSquare (int number){
        int ans = 0 ;
        while (number > 0){
            int rem = number % 10 ;
            ans += rem * rem ;
            number /= 10 ;
        }
        return ans ;
    }

    

    private Node middleLinkedList(Node head){
        Node fast = head ;
        Node slow = head ;
       
        while (fast != null && fast.next != null){
            slow = slow.next ;
            fast = fast.next.next ;
        }
        return slow ;
    }

    public void bubbleSort(){
        bubbleSort(size - 1 , 0);
    }

    private void bubbleSort (int row , int col){
        if (row == 0){
            return ;
        }
        if (col < row){
            Node first  = get(col) ;
            Node second = get (col + 1) ;

            if (first.value > second.value){
                //swap  
                if (first == head){
                    head = second ;
                    first.next = second.next ;
                    second.next = first ;
                }
                else if (second == tail){
                    Node prev = get (col - 1) ;
                    prev.next = second ;
                    second.next = first ;
                    first.next = null ;
                    tail = first ;
                }
                else {
                    Node prev = get (col - 1);
                       prev.next = second ;
                        first.next = second.next ;
                        second.next = first ;
                    
                }
            }
            bubbleSort(row , col+1);
        }
        else {
            bubbleSort(row - 1 , 0);
        }

    }

    public Node reverse(Node head){
        if (head == null){
            return null ;
        }
        Node previous = null ;
        Node current = head ;
        Node Next = current.next ;

        while (current != null ){
            current.next = previous ;
            previous = current ;
            current = Next ;
            if (Next != null){

                Next = Next.next ;

            }

        }

        return head = previous ;
    }

    public Node reverseBetween (Node head , int left , int right){
        if (left == right){
            return head ;
        }
        Node current = head ;
        Node previous = null ;
        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current ;
            current = current.next ;
            
        } 
        Node last = previous ;
        Node newEnd = current ;
        return newEnd;
    }

    // public boolean isPalindrome (Node head){
    //     Node mid = middleLinkedList(head);
    //     Node headSecNode = reverse(mid) ;
    //     Node rereverHead = headSecNode ;

    //     //compare both the halves
    //     while (head != null && headSecNode != null){
           
    //             if (head.value != headSecNode.value){
    //                 break ;
    //             }
    //             head = head.next ;
    //             headSecNode = headSecNode.next ;
    //         }

    //         reverse(rereverHead);
            

    //     }


    public Node reverseKGroup (Node head , int k){
        if ( k <= 1 || head == null){
            return head ;
        }

        Node current = head ;
        Node prev = null ;

        while (true) {
            Node last = prev ;
            Node newEnd = current ;

            Node next = current.next ;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev ;
                prev = current ;

                current = next ;
                if (next != null){
                    next = next.next ;
                }
                

            if (last != null){
                last.next = prev ;
            }else{
                head = prev;
            }

            newEnd.next = current ;

            if (current == null){
                break ;
            }
                
            }
            return head ;
            
        }

        
    }

      

    public void display (){
        Node temp = head ;

        while (temp != null ){
            System.out.print(temp.value +"-->");
            temp = temp.next ;
        }
        System.out.println("END");
    }

    public int getSize(){
        return size ;
    }
}
