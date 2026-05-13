package BinaryTree;

import java.util.*;

class Node{
     int data;
    Node left;
    Node right;


public  Node(int val){
     data = val;
     left = null;
     right = null;
}

}

class solution{
     
    public static List<Integer> postOrder(Node root){
           List<Integer> postorder = new ArrayList<>();  
           Stack<Node>st1 = new Stack<>();
            Stack<Node>st2 = new Stack<>();
           
            if(root == null){ 
                 return postorder;
            }

                      st1.push(root);

        // Iterative traversal to populate st2 with nodes in postorder
        while (!st1.isEmpty()) {
            root = st1.pop();  // Get the top node from st1
            st2.push(root);  // Push the node onto st2

            // Push left child onto st1 if exists
            if (root.left != null) {
                st1.push(root.left);
            }

            // Push right child onto st1 if exists
            if (root.right != null) {
                st1.push(root.right);
            }
        }

          while (!st2.isEmpty()) {
            postorder.add(st2.pop().data);  // Add the node's value to the postorder result
        }

        // Return the postorder traversal result
        return postorder;

    }
    

}

public class Postorder {
    public static void main(String[] args) {
        Node root = new Node(1);
           root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
    }
}


