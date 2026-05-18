import java.util.*;

class Node{
    Node left;
    Node right;
    int data;

    Node(int value){
         data = value;
         left = null;
         right = null;
    }
}

class Solution{ 

    Queue<Node>q = new LinkedList<>();
    int maxDepth(Node root){
         if(root == null){
             return 0;
         }

         int level = 0;
         while(!q.isEmpty()){
             int size = q.size();
             for(int i=0; i<size; i++){
                 Node front = q.poll();
                 if(front.left!=null){
                     q.add(front.left);
                 }
                 if(front.right!=null){
                     q.add(front.right);
                 }
             }
             level++;
         }
    }
}

public class MaxDepth {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);

        
        Solution solution = new Solution();
        int depth = solution.maxDepth(root);

    }
}
