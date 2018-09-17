package backtracking;

import java.util.*;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        recurse(n, k, 1, new ArrayList<Integer>(), result);
        
        Set<List<String>> set = new HashSet<List<String>>();
        List<List<String>> lst = new ArrayList<List<String>>(set);
        return result;
    }
    
    private void recurse(int n, int k, int pos, List<Integer> current, List<List<Integer>> result){
        if(current.size() == k){
            result.add(new ArrayList<Integer>(current));
        }else{
            for(int i=pos;i<=n;i++){
                current.add(i);
                recurse(n, k, i+1, current, result);
                current.remove(current.size()-1);
            }
        }
    }
}

class TreeNode{
	int val;
	TreeNode right;
	TreeNode left;
}
 class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean validate(TreeNode root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.val>min && root.val<max){
            return validate(root.left, min, (long)root.val) && validate(root.right, (long)root.val, max);
        }
        StringBuilder s = new StringBuilder();
        return false;
    }
}