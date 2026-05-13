
import java.util.*;


class Node {
    int data;
    Node left;
    Node right;
    public int val;

    // Constructor to initialize the node with a value
    public Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution{
     public static List<Integer>postOrderUsingOneStack(Node root){
          List<Integer>postorder = new ArrayList<Integer>();
          Stack<Node>st = new Stack<>();
          Node temp;
          Node current = root;

          while(current != null || !st.isEmpty() ){
              if(current != null){
                 st.push(current);
                 current  = current.left;
              }
              else{
                 temp = st.peek().right;
                 if(temp == null){
                     temp = st.peek();
                     st.pop();
                     postorder.add(temp.val);
                     while(!st.isEmpty() && temp == st.peek().right){
                         temp = st.peek();
                     st.pop();
                     postorder.add(temp.val);
                     }
                 }
                 else{ 
                    current = temp;
                 }
              }
              return postorder;
          }  
     } 
}


public class PostOrderUsingOneStack {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Getting the postorder traversal
        java.util.List<Integer> result = Solution.postOrderUsingOneStack(root);

        // Printing the postorder traversal result
        System.out.print("Postorder traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
