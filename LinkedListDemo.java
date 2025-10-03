// LinkedListDemo.java
// This class implements a singly linked list using the Node class

public class LinkedListDemo {
    private Node head;  // Head of the linked list
    private Node tail;  // Tail of the linked list
    private int length; // Number of nodes in the linked list

    // Constructor to initialize the linked list with one node
    public LinkedListDemo(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Print all values in the linked list
    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Append a new node at the end
    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Prepend a new node at the beginning
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // Remove the last node
    public Node removeLast() {
        if (length == 0) return null;

        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if (length == 0) {
            head = null;
            tail = null;
        }
        return temp;
    }

    // Remove the first node
    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    // Get a node at a specific index
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // Update the value of a node at a specific index
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create linked list with initial value 41
        LinkedListDemo myLL = new LinkedListDemo(41);

        // Append nodes
        myLL.append(25);
        myLL.append(33);
        myLL.append(23);
        myLL.append(73);
        myLL.append(22);
        myLL.append(45);

        // Prepend a node
        myLL.prepend(29);

        // Test get and set methods
        System.out.println("Value returned by get method: " + myLL.get(2).value);
        myLL.set(1, 4);

        // Print the linked list
        myLL.printLL();
    }
}
