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
    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        public Node removeLast() {

    if (length == 0) {
        return null;
    }

    Node temp = tail;

    if (length == 1) {
        head = null;
        tail = null;
    } else {
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    length--;

    return temp;
}
public void prepend(int value) {

    Node newNode = new Node(value);

    if (length == 0) {
        head = newNode;
        tail = newNode;
    } else {
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    length++;
}
public Node removeFirst() {

    if (length == 0) {
        return null;
    }

    Node temp = head;

    if (length == 1) {
        head = null;
        tail = null;
    } else {
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    length--;

    return temp;
}
public Node get(int index) {
    if (index < 0 || index >= length) {
        return null;
    }

    Node temp;

    if (index < length / 2) {
        temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
    } else {
        temp = tail;

        for (int i = length - 1; i > index; i--) {
            temp = temp.prev;
        }
    }

    return temp;
}
public boolean set(int index, int value) {
    Node temp = get(index);

    if (temp != null) {
        temp.value = value;
        return true;
    }

    return false;
}
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

    Node before = get(index - 1);
    Node after = before.next;

    newNode.prev = before;
    newNode.next = after;

    before.next = newNode;
    after.prev = newNode;

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

    Node temp = get(index);

    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;

    temp.next = null;
    temp.prev = null;

    length--;

    return temp;
}
public void reverse() {
    Node temp = null;
    Node current = head;

    // Swap head and tail
    head = tail;
    tail = current;

    while (current != null) {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;

        current = current.prev;
    }
}
public void partitionList(int x) {
    if (head == null) {
        return;
    }

    Node lessDummy = new Node(0);
    Node greaterDummy = new Node(0);

    Node lessTail = lessDummy;
    Node greaterTail = greaterDummy;

    Node current = head;

    while (current != null) {
        Node next = current.next;

        // Detach current node
        current.next = null;
        current.prev = null;

        if (current.value < x) {
            lessTail.next = current;
            current.prev = lessTail;
            lessTail = current;
        } else {
            greaterTail.next = current;
            current.prev = greaterTail;
            greaterTail = current;
        }

        current = next;
    }

    // Connect the two partitions
    lessTail.next = greaterDummy.next;

    if (greaterDummy.next != null) {
        greaterDummy.next.prev = lessTail;
    }

    // Update head
    head = (lessDummy.next != null)
            ? lessDummy.next
            : greaterDummy.next;

    if (head != null) {
        head.prev = null;
    }

    // Update tail
    tail = (greaterDummy.next != null)
            ? greaterTail
            : lessTail;
}
public void reverseBetween(int startIndex, int endIndex) {

    if (head == null || startIndex == endIndex) {
        return;
    }

    Node startNode = head;
    for (int i = 0; i < startIndex; i++) {
        startNode = startNode.next;
    }

    Node endNode = startNode;
    for (int i = startIndex; i < endIndex; i++) {
        endNode = endNode.next;
    }

    Node beforeStart = startNode.prev;
    Node afterEnd = endNode.next;

    Node current = startNode;
    Node temp = null;

    while (current != afterEnd) {
        temp = current.prev;
        current.prev = current.next;
        current.next = temp;
        current = current.prev;
    }

    if (beforeStart != null) {
        beforeStart.next = endNode;
    } else {
        head = endNode;
    }

    endNode.prev = beforeStart;

    startNode.next = afterEnd;

    if (afterEnd != null) {
        afterEnd.prev = startNode;
    }
}
public void swapPairs() {

    if (head == null || head.next == null) {
        return;
    }

    Node dummy = new Node(0);
    dummy.next = head;
    head.prev = dummy;

    Node prevPair = dummy;

    while (prevPair.next != null && prevPair.next.next != null) {

        Node first = prevPair.next;
        Node second = first.next;
        Node nextPair = second.next;

        // Swap
        prevPair.next = second;
        second.prev = prevPair;

        second.next = first;
        first.prev = second;

        first.next = nextPair;

        if (nextPair != null) {
            nextPair.prev = first;
        }

        prevPair = first;
    }

    head = dummy.next;
    head.prev = null;
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