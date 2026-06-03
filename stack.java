public class stack {

    // Node class
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node top;
    private int height;

    // Constructor
    public stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    // Print Stack
    public void printStack() {
        Node temp = top;

        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    // Get Top
    public void getTop() {
        if (top == null) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
    }

    // Get Height
    public void getHeight() {
        System.out.println("Height: " + height);
    }

    // Push Method
    public void push(int value) {

        Node newNode = new Node(value);

        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }

        height++;
    }

    // Pop Method
    public Node pop() {

        if (height == 0) {
            return null;
        }

        Node temp = top;

        top = top.next;
        temp.next = null;

        height--;

        return temp;
    }

    // Main method
    public static void main(String[] args) {

        stack stack = new stack(10);

        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Stack before pop:");
        stack.printStack();

        stack.pop();
        stack.pop();

        System.out.println("Stack after pop:");
        stack.printStack();

        stack.getTop();
        stack.getHeight();
    }
}