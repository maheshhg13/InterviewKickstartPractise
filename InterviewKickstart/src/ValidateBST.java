
public class ValidateBST {

	int biggestBST = 0;
	public int largestBSTSubtree(TreeNode root) {
		return -1;
	}
	
	public int isValidBST(TreeNode root) {
        if(root == null) return -1;
         isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
         return biggestBST;
        // return leftBST(root.left, root) && rightBST(root.right, root) && isValidBST(root.left) && isValidBST(root.right);
    }
    
        
    private int isBST(TreeNode root, long min, long max) {
        
        //System.out.println(root.val + " " + min + " " + max);
        int result = 1;
        if(root.val <= min || root.val >= max){ 
            //System.out.println("minmax returning: " + root.val + "false");
            result= -1;
        }
        
        int left = 0;
        int right = 0;
        
        if(root.left != null) {
            left = isBST(root.left, min, root.val);
        }
        if(root.right != null) {
            right = isBST(root.right, root.val, max);
        }
        
        if(result== -1 || left==-1 || right == -1){
        	result = -1;
        }else{
        	result = result+right+left;
        }
        
        int currMax = Math.max(result, Math.max(left, right));
        biggestBST = Math.max(biggestBST, currMax);
        //System.out.println("returning: " + root.val + " " + result);
        return result;
    }
	
    public static void main(String[] args) {
//    	TreeNode root = new TreeNode(20);
//    	
//    	TreeNode _21 = new TreeNode(21);
//    	TreeNode _18 = new TreeNode(18);
//    	TreeNode _19 = new TreeNode(19);
//    	TreeNode _17 = new TreeNode(17);
//    	
//    	root.left = _21;
//    	_21.left = _18;
//    	_18.left = _17;
//    	_18.right = _19;
    	
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	
    	int result = new ValidateBST().isValidBST(root);
    	System.out.println(result);
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode(int c) {
		val = c;
	}
}

class MyResult{
	
	public boolean isBst;
	private int size;
	
	public MyResult(boolean bst, int s){
		isBst = bst;
		size = s;
	}
	
	public int getSize(){
		return isBst?size:0;
	}
}
