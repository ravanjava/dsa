package ram.dsa.tree;

public class LevelOfGivenKey {

    public static void main(String[] args) {
        TreeNode root = TreeNode.init();

        System.out.println(getLevel(root,7,1));
    }


    private static int getLevel(TreeNode root,int key, int level){

        if(root==null)
            return -1;

        if(root.val==key){
            return level;
        }

        int leftAns = getLevel(root.left,key,level+1);
        if(leftAns!=-1)
            return leftAns;
        else
            return getLevel(root.right,key,level+1);
    }
}
