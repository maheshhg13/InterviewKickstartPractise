package backtracking;

public class WordDictionary {
	    
	    class TrieNode{
	        char curr;
	        TrieNode[] children;
	        boolean isWord;
	        public TrieNode(char c){
	            curr = c;
	            isWord = false;
	            children =  new TrieNode[26];
	        }
	        
	        public TrieNode getChild(char c){
	            return children[c-'a'];
	        }
	        
	        public void setChild(char c, TrieNode node){
	            children[c-'a'] = node;
	        }
	    }
	    
	    class Trie{
	        TrieNode root;
	        public Trie(){
	            root = new TrieNode('/');
	        }
	        
	        public void addWord(String word){
	            char[] chars = word.toCharArray();
	            TrieNode temp = root;
	            for(int i=0;i<chars.length;i++){
	                if(temp.getChild(chars[i])==null){
	                	temp.setChild(chars[i], new TrieNode(chars[i]));
	                }
	                temp = temp.getChild(chars[i]);
	            }
	            temp.isWord = true;
	        }
	        
	        public boolean search(String word){
	            return search(word.toCharArray(), 0, root);    
	        }
	        
	        private boolean search(char[] chars, int start, TrieNode temp){
	            if(start>=chars.length){
	                return temp.isWord;
	            }else if(chars[start]!='.'){
	                if(temp.children[chars[start]-'a']!=null){
	                    return search(chars, start+1, temp.children[chars[start]-'a']);
	                }
	                return false;
	            }else{
	                for(TrieNode child:temp.children){
	                    if(child!=null && search(chars, start+1, child)){
	                        return true;
	                    }
	                }
	                return false;
	            }
	        }
	    }
	    
	    /** Initialize your data structure here. */
	    Trie trie;
	    public WordDictionary() {
	        trie = new Trie();
	    }
	    
	    /** Adds a word into the data structure. */
	    public void addWord(String word) {
	        trie.addWord(word);
	    }
	    
	    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	    public boolean search(String word) {
	        return trie.search(word);
	    }
	    
	    public static void main(String[] args) {
			WordDictionary w = new WordDictionary();
			w.addWord("bad");
			w.addWord("dad");
			w.addWord("mad");
		}
}
