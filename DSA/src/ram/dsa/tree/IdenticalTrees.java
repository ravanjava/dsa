package ram.dsa.tree;

public class IdenticalTrees {


    public static void main(String[] args) {
        TreeNode root1 = TreeNode.init();
        TreeNode root2 = TreeNode.init();

        System.out.println(isIdentical(root1,root2));
        root2.right.right.left = new TreeNode(35);
        System.out.println(isIdentical(root1,root2));
    }

    private static boolean isIdentical(TreeNode root1, TreeNode root2){

        if(root1==null && root2==null){
            return true;
        }

        if(root1!=null && root2!=null){
            if(root1.val== root2.val & isIdentical(root1.left,root2.left) && isIdentical(root1.right,root2.right))
                return true;
        }

        return false;
    }
}
