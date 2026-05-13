import java.util.List;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Define the TreeNode structure
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { data = x; left = null; right = null; }
}
class Solution{
     public  List<Integer> iterativeInorderTraversal(TreeNode root){
         Stack<TreeNode>st = new Stack<>();
        TreeNode node = root;
        List<Integer> inorder = new ArrayList<>();

        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                 if(st.empty()){
                     break;
                 }
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;

     }
 }
public class IterativeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // Initializing the Solution class
        Solution sol = new Solution();

        // Getting the inorder traversal
        List<Integer> result = sol.iterativeInorderTraversal(root);

        // Displaying the inorder traversal result
        System.out.print("Inorder Traversal: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
