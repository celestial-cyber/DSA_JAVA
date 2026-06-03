//fifo structure
//enqueue and dequeue operations are performed with o(n) and O(1)

public class queue{
    private Node first;
    private Node last;
    private int length;

    public queue(int value){
       Node newNode = new Node(value);
       first = newNode;
       last = newNode;
       length =1;

    }
    //node class 
    class Node {
    int value;
    Node next;

    Node (int value){
        this.value = value;
    }

   
}

     //print Queue method 
    public void printQueue(){
        Node temp = first;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    //getfirst
    public void getfirst(){
        System.out.println("First "+ first.value);
    }

    //getlast
    public void getlast(){
        System.out.println("Last "+ last.value);
    }
    //length
    public void getlength(){
        System.out.println("Length "+ length);
    }

    //enqueue
    public void enqueue(int value){
        Node newNode = new Node(value);
        if (length==0){
            first = newNode;
            last = newNode;
        }
        else{
            last.next = newNode;
            last= newNode;
            
        }
        length++;
    }

    //dequeue operations 
    public Node dequeue(){
        if(length==0){ //or first == null
            return null;
        }

        Node temp = first;
        if(length==1){
            first = null;
            last= null;
        }

        else{
            first = first.next;
            temp.next= null;
        }
        length--;
        return temp;
    }


    //main method
    public static void main(String[] args) {
    queue q = new queue(10);
    q.enqueue(20);
    q.enqueue(30);
    q.enqueue(40);
    q.dequeue();    
     

    System.out.println("Queue created");
    q.getlength();
    q.getfirst();
    q.getlast();
    q.printQueue();

    
    
    

}
}



