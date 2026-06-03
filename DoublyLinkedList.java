public class DoublyLinkedList {

    // Node class
    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    // Constructor
    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Append method
    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } 
        else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length++;
    }

    //prining next value
    public void printList(){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

     // Main method
    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList(10);

        dll.append(20);
        dll.append(30);
        dll.append(40);

        dll.printList();
    }
}