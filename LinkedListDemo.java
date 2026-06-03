
import javax.sound.midi.InvalidMidiDataException;

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
    //inserting at a specified position
    public boolean insert(int index, int value) {

    if (index < 0 || index > length) {
        return false;
    }

    if (index == 0) {
        prepend(value);
        return true;
    }

    if (index == length) {
        append(value);
        return true;
    }

    Node newNode = new Node(value);

    Node temp = get(index - 1);

    newNode.next = temp.next;
    temp.next = newNode;

    length++;

    return true;
}

public Node remove(int index) {

    if (index < 0 || index >= length) {
        return null;
    }

    if (index == 0) {
        return removeFirst();
    }

    if (index == length - 1) {
        return removeLast();
    }

    Node prev = get(index - 1);
    Node temp = prev.next;

    prev.next = temp.next;
    temp.next = null;

    length--;

    return temp;
}
//find middle node 
public Node removeMiddle(){

}

//reverse the list 
public void reverse() {

    Node temp = head;
    head = tail;
    tail = temp;

    Node after = temp.next;
    Node before = null;

    for (int i = 0; i < length; i++) {
        after = temp.next;
        temp.next = before;
        before = temp;
        temp = after;
    }
}

// has loop 
public boolean hasLoop() {

    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {

        slow = slow.next;
        fast = fast.next.next;

        if (slow == fast) {
            return true;
        }
    }

    return false;
}
// find the kth node from end 
public Node findKthFromEnd(int k) {

    if (k <= 0) {
        return null;
    }

    Node slow = head;
    Node fast = head;

    for (int i = 0; i < k; i++) {
        if (fast == null) {
            return null;
        }
        fast = fast.next;
    }

    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }

    return slow;
}

import java.util.HashSet;

public void removeDuplicates() {

    HashSet<Integer> set = new HashSet<>();

    Node current = head;
    Node previous = null;

    while (current != null) {

        if (set.contains(current.value)) {
            previous.next = current.next;
        } else {
            set.add(current.value);
            previous = current;
        }

        current = current.next;
    }
}
public int binaryToDecimal() {

    int num = 0;
    Node current = head;

    while (current != null) {
        num = num * 2 + current.value;
        current = current.next;
    }

    return num;
}
//paritition element 
public void partitionList(int x) {

    if (head == null) {
        return;
    }

    Node dummy1 = new Node(0);
    Node dummy2 = new Node(0);

    Node prev1 = dummy1;
    Node prev2 = dummy2;

    Node current = head;

    while (current != null) {

        if (current.value < x) {
            prev1.next = current;
            prev1 = current;
        } else {
            prev2.next = current;
            prev2 = current;
        }

        current = current.next;
    }

    prev2.next = null;
    prev1.next = dummy2.next;

    head = dummy1.next;
}
//reversing part of a list 
public void reverseBetween(int m, int n) {

    if (head == null || m == n) {
        return;
    }

    Node dummy = new Node(0);
    dummy.next = head;

    Node prev = dummy;

    for (int i = 0; i < m; i++) {
        prev = prev.next;
    }

    Node current = prev.next;

    for (int i = 0; i < n - m; i++) {

        Node temp = current.next;

        current.next = temp.next;

        temp.next = prev.next;

        prev.next = temp;
    }

    head = dummy.next;
}
public void swapPairs() {

    Node dummy = new Node(0);
    dummy.next = head;

    Node prev = dummy;

    while (prev.next != null && prev.next.next != null) {

        Node first = prev.next;
        Node second = first.next;

        first.next = second.next;
        second.next = first;
        prev.next = second;

        prev = first;
    }

    head = dummy.next;
}

//swap nodes
public void swapPairs() {

    Node dummy = new Node(0);
    dummy.next = head;

    Node prev = dummy;

    while (prev.next != null && prev.next.next != null) {

        Node first = prev.next;
        Node second = first.next;

        // Swap the pair
        first.next = second.next;
        second.next = first;
        prev.next = second;

        // Move to the next pair
        prev = first;
    }

    head = dummy.next;
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
        //myLL.set(1, 4);

        // Print the linked list
        myLL.printLL();
    }
}
