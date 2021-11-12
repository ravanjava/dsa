package ram.dsa.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeTraversals {

    public static void main(String[] args) {
        TreeNode root =  TreeNode.init();
        dfs(root, "pre");
        System.out.println();
        dfs(root, "in");
        System.out.println();
        dfs(root, "post");
        System.out.println();
        bsf(root);
    }

    private static void bsf(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " -> ");

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    private static void dfs(TreeNode root, String order) {
        if (root == null) {
            return;
        }
        if ("pre".equalsIgnoreCase(order))
            System.out.print(root.val + " -> ");
        dfs(root.left, order);
        if ("in".equalsIgnoreCase(order))
            System.out.print(root.val + " -> ");
        dfs(root.right, order);
        if ("post".equalsIgnoreCase(order))
            System.out.print(root.val + " -> ");
    }


}
