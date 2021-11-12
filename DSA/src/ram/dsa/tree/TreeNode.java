package ram.dsa.tree;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }


    public static TreeNode init(){
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);

        root.left.left.left = new TreeNode(20);
        root.left.left.right = new TreeNode(22);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        return root;
    }


    public static TreeNode initBST(){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right = new TreeNode(25);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(12);

        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(14);

        return root;
    }
}
