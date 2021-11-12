package ram.dsa.tree;

public class TreeDiameter {

    private static int  diameter = 0;

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();
        diameter(root);
        System.out.println(diameter);
    }


    private static int diameter(TreeNode root){
        if(root==null)
            return 0;

        int left = diameter(root.left);
        int right = diameter(root.right);
        diameter =  Math.max(diameter,left+right+1);

        return Math.max(left,right)+1;
    }


    private static int height(TreeNode root){

        if(root==null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left,right)+1;

    }
}
