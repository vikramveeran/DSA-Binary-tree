package BinaryTree;
import java.util.*;

class Node{ 
    int data;
    Node left;
    Node right;


Node(int val){
     data = val;
     left = null;
     right = null;
  }
}

class Solution{
   
  public void preorder(Node root, java.util.List<Integer> arr) {
        // If the current node is NULL
        // (base case for recursion), return   
        if (root == null) {        
            return;          
        }        
         
        arr.add(root.data);
       
        preorder(root.left, arr);
      
        preorder(root.right, arr);
    }
public List<Integer> preorder(Node root) { 
   List<Integer> arr = new ArrayList<>();
   preorder(root, arr);
      return arr;
  }
}

public class Preorder {
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Solution sol = new Solution();
        java.util.List<Integer> result = sol.preorder(root);

        // Displaying the preorder traversal result
        System.out.print("Preorder Traversal: ");
        // Output each value in the
        // preorder traversal result
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
