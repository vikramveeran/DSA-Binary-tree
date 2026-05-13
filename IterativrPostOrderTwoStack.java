import java.util.*;


class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}
 
class Solution{
     public static List<Integer> postOrder(Node root) {
        List<Integer> postorder = new java.util.ArrayList<>();
        Stack<Node>st1 = new Stack<>();
        Stack<Node>st2 = new Stack<>();
        if(root == null){ 
            return postorder;
        }
        st1.push(root);

        while(!st1.isEmpty()){
             root = st1.pop();
             st2.push(root);

             if(root.left != null){
                   st1.push(root.left);
             }
             if(root.right != null){
                 st1.push(root.right);
             }
        }
        while(!st2.empty()){
               postorder.add(st2.pop().data);
        }  
          return postorder;
     }
}


public class IterativrPostOrderTwoStack {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting the postorder traversal
        java.util.List<Integer> result = Solution.postOrder(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
