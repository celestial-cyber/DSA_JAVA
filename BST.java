// Full Binary Tree = Every node has either 0 or 2 children.

// Perfect Binary Tree = All internal nodes have 2 children
// and all leaf nodes are at the same level.

// Complete Binary Tree = A tree filled from left to right
// with no gaps (except possibly the last level).

// Binary Tree = A tree where each node can have at most 2 children.

// Binary Search Tree (BST) =
// Left child value < Parent node value
// Right child value > Parent node value

// Total nodes in a perfect binary tree:
// 2^(number of levels) - 1

// BST follows Divide and Conquer approach.

// BST Time Complexities

// Insert Node
// Best Case: O(log n)
// Average Case: O(log n)
// Worst Case: O(n)   // skewed tree

// Search / Contains
// Best Case: O(log n)
// Average Case: O(log n)
// Worst Case: O(n)

// Delete Node
// Best Case: O(log n)
// Average Case: O(log n)
// Worst Case: O(n)

// Find Minimum
// Best Case: O(1)
// Average Case: O(log n)
// Worst Case: O(n)

// Find Maximum
// Best Case: O(1)
// Average Case: O(log n)
// Worst Case: O(n)

// BFS Traversal (Breadth First Search)
// Time Complexity: O(n)
// Space Complexity: O(n)

// DFS Preorder Traversal
// Time Complexity: O(n)
// Space Complexity: O(h)

// DFS Inorder Traversal
// Time Complexity: O(n)
// Space Complexity: O(h)

// DFS Postorder Traversal
// Time Complexity: O(n)
// Space Complexity: O(h)

// Height of BST
// Best/Average: O(log n)
// Worst: O(n)

// Overall Space Complexity of BST
// O(n)

public class BST {

    class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
   // public BST(int value){
        //Node newNode = new Node(value);
        //root = newNode;
        //root = null;
    //}
    //steps to insert node in a BST
    //insert -> if < left else > right 
    //if root == null then root = newNode
    // temp = root
    // while loop
    // if newNode == temp return false
    //if < left else > right
    //if null insert newNode else move to next
    public boolean insert(int value){
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
            }
        Node temp = root;
        while(true){
            if (newNode.value == temp.value) return false;
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;

            }else{
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }

        }
 }

    // contains function 
    //if root == null returns false
    //temp = root;
    //while temp ! = null
    // if < left 
    //else if > right 
    //else == return true 
    //return false 
    public boolean contains(int value){
        if ( root == null) return false;
        Node temp = root;
        while(temp != null){
            if(value < temp.value){
                temp = temp.left;
            } else if (value > temp.value){
                temp = temp.right;
            }
            else{
                return true;
            }
        }
        return false;


    }
    
    public static void main(String[] args){
            BST myBST = new BST();
            
            myBST.insert(47);
            myBST.insert(27);
            myBST.insert(54);
           //System.out.println(myBST.root.left.value);
           //System.out.println(myBST.root.right.value);
           System.out.println(myBST.contains(10));
           System.out.println(myBST.contains(54));
        }
        }




