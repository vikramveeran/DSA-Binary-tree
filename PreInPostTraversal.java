import java.util.*;
// Node structure for the binary tree
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // the node with a value
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
}

class Solution{ 
    public List<List<Integer>>preInPostTraversal(Node root){
          List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        Stack<Pair<Node,Integer>>st = new Stack<>();
        st.push(new Pair<>(root,1));

        while(!st.empty()){
                Pair<Node, Integer> it = st.pop();
                if(it.getValue() == 1){ 
                     pre.add(it.getKey().data);

                     it.setValue(2);

                     st.push(it);

                     if(it.getKey().left != null){ 
                        st.push(new Pair<>(it.getKey().left, 1));
                     }
                }
                 else if (it.getValue() == 2) {
                // Store the node's data
                // in the inorder traversal
                in.add(it.getKey().data);
                // Move to state 3
                // (postorder) for this node
                it.setValue(3);
                // Push the updated state
                // back onto the stack
                st.push(it);

                // Push right child onto
                // the stack for processing
                if (it.getKey().right != null) {
                    st.push(new Pair<>(it.getKey().right, 1));
                }
            }
            else{
                 post.add(it.getKey().data);
            }

        }
         List<List<Integer>> result = new ArrayList<>();
        result.add(pre);
        result.add(in);
        result.add(post);
        return result;

       
    }
    public  void printList(List<Integer> list){ 
        for(int  res : list){ 
             System.out.println(res);
        }
       }
}

public class PreInPostTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Create object of Solution class
        Solution sol = new Solution();

        // Getting the pre-order, in-order,
        // and post-order traversals
        List<List<Integer>> traversals = sol.preInPostTraversal(root);

        // Extracting the traversals
        List<Integer> pre = traversals.get(0);
        List<Integer> in = traversals.get(1);
        List<Integer> post = traversals.get(2);

        // Printing the traversals
        System.out.print("Preorder traversal: ");
        sol.printList(pre);

        System.out.print("Inorder traversal: ");
        sol.printList(in);

        System.out.print("Postorder traversal: ");
        sol.printList(post);

    }
}
