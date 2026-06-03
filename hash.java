// ======================= HASH TABLE =======================

// Hash Table = A data structure used to store data in
// key-value pairs for fast access, insertion, and deletion.

// Example:
// Key -> Value
// "name" -> "Celestial"
// "age"  -> 20

// -----------------------------------------------------------
// HASH FUNCTION
// -----------------------------------------------------------

// A hash function converts a key into an index (address)
// in the array where the data will be stored.

// Important:
// Hashing is deterministic,
// meaning the same key always generates the same address.

// Example:
// hash("apple") -> index 3
// hash("apple") -> index 3 (always same)

// Goal of hashing:
// Fast searching, insertion, and deletion.

// Average Time Complexity:
// Insert  -> O(1)
// Search  -> O(1)
// Delete  -> O(1)

// Worst Case (many collisions):
// O(n)


// -----------------------------------------------------------
// COLLISION IN HASH TABLE
// -----------------------------------------------------------

// Collision occurs when two different keys
// generate the same index/address.

// Example:
// "apple" -> index 2
// "grape" -> index 2
// Both want the same position = Collision


// -----------------------------------------------------------
// METHODS TO HANDLE COLLISIONS
// -----------------------------------------------------------

// 1. Separate Chaining
// -----------------------------------------------------------

// In Separate Chaining,
// multiple elements at the same index
// are stored using a Linked List.

// Example:

// Index 2:
// apple -> grape -> mango

// If collision happens,
// add the new node to the linked list.

// We commonly use Linked Lists
// in Separate Chaining.


// 2. Open Addressing
// -----------------------------------------------------------

// Instead of Linked List,
// find another empty position in the table.

// Types of Open Addressing:

// a) Linear Probing
// If index is full,
// move to the next empty spot.

// Example:
// index 2 = occupied
// place item at index 3

// b) Quadratic Probing
// Jump using square values:
// +1², +2², +3² ...

// c) Double Hashing
// Use another hash function
// to find the next position.


// -----------------------------------------------------------
// WHY HASH TABLE IS FAST?
// -----------------------------------------------------------

// No need to search one by one.
// We directly calculate the address
// using the hash function.

// This makes access nearly O(1).


// -----------------------------------------------------------
// REAL LIFE USES OF HASH TABLE
// -----------------------------------------------------------

// Password storage
// Caching
// Database indexing
// Dictionaries / Maps
// Phone contacts
// Searching usernames quickly
import java.util.ArrayList;
class Node {
    String key;
    int value;
    Node next;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

public class hash {

    private int size = 7;
    private Node[] dataMap;

    public hash() {
        dataMap = new Node[size];
    }

    // Hash Function
    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int i = 0; i < keyChars.length; i++) {
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % dataMap.length;
        }

        return hash;
    }

    // Set Method
    public void set(String key, int value) {

        int index = hash(key);

        Node newNode = new Node(key, value);

        if (dataMap[index] == null) {
            dataMap[index] = newNode;

        } else {
            Node temp = dataMap[index];

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // Get Method
    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];

        while (temp != null) {

            // use equals() for String comparison
            if (temp.key.equals(key)) {
                return temp.value;
            }

            temp = temp.next;
        }

        return 0;
    }

    // Print Hash Table
    public void printTable() {

        for (int i = 0; i < dataMap.length; i++) {

            System.out.println(i + ":");

            Node temp = dataMap[i];

            while (temp != null) {
                System.out.println("   {" + temp.key + " = " + temp.value + "}");
                temp = temp.next;
            }
        }
    }
    //key
   public ArrayList<String> keys() {

    ArrayList<String> allKeys = new ArrayList<>();

    for (int i = 0; i < dataMap.length; i++) {

        Node temp = dataMap[i];

        while (temp != null) {
            allKeys.add(temp.key);
            temp = temp.next;
        }
    }

    return allKeys;
}

// Main Method
public static void main(String[] args) {

    hash myHash = new hash();

    myHash.set("nails", 100);
    myHash.set("tile", 50);
    myHash.set("lumber", 80);
    myHash.set("paint", 40);
    myHash.set("bolts", 20);

    // myHash.printTable();

    System.out.println(myHash.get("nails"));
    System.out.println(myHash.keys());
}
}


// big O for hash method 
