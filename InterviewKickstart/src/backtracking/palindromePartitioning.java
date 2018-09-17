//package backtracking;
//import java.util.*;
//public class palindromePartitioning {
//    public List<List<String>> partition(String s) {
//        List<List<String>> result = new ArrayList<List<String>>();
//        recurse(s, "", result);
//        return result;
//    }
//    
//    private void recurse(String s, String p, List<List<String>> result){
//        if(isPalindrome(p)){
//            if(!result.contains(p)){
//                result.add(new String(p));    
//            }
//        }
//        for(int i=0;i<s.length();i++){
//            p+=s.charAt(i);
//            recurse(s.substring(1), p, result);
//        }
//    }
//    
//    private boolean isPalindrome(String str){
//        int s=0;
//        int e = str.length()-1;
//        while(s<=e){
//            if(str.charAt(s)!=s.charAt(e))
//                return false;
//            s++;
//            e--;
//        }
//        return true;
//    }
//}
