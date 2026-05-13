package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
// Pair class to store node + state
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}
public class Solution {
    public void preInPostTraversal(TreeNode root) {

        if (root == null) return;  // ⚠️ move this BEFORE pushing to stack

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));

        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        while (!st.isEmpty()) {
            Pair it = st.pop();

            // Preorder
            if (it.num == 1) {
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.left != null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }
            // Inorder
            else if (it.num == 2) {
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if (it.node.right != null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            // Postorder
            else {
                post.add(it.node.val);
            }
        }

        // Print results (optional)
        System.out.println("Preorder: " + pre);
        System.out.println("Inorder: " + in);
        System.out.println("Postorder: " + post);
    }
}
