package ram.dsa.tree;

public class FloorInBST {

    public static void main(String[] args) {
        TreeNode root = TreeNode.initBST();
        System.out.println(floor(root,17,true));
        System.out.println(floor(root,17,false));
    }

    private static int floor(TreeNode root,int target,boolean isFloor){
        int result = -1;
        if (root==null)
            return result;

        while (root !=null){
            if(target<root.val){
                if(!isFloor)
                    result = root.val;
                root = root.left;
            }else{
                if(isFloor)
                    result = root.val;
                root = root.right;
            }

        }
        return result;
    }

}
