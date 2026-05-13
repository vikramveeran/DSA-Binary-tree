
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

class Solution {

    public static java.util.List<Integer> preorderTraversal(TreeNode root) {
        java.util.List<Integer> preorder = new java.util.ArrayList<>(); 
        
       
        if (root == null) {
            return preorder;
        }

        java.util.Stack<TreeNode> st = new java.util.Stack<>(); 
        st.push(root);  

        
        while (!st.isEmpty()) {
            root = st.pop();  
            preorder.add(root.val);  

    
            if (root.right != null) {
                st.push(root.right);
            }

        
            if (root.left != null) {
                st.push(root.left);
            }
        }
        

        return preorder;
    }
}


class IterativePreorderTraversal{
     public static void main(String[] args) {
        
     }
}