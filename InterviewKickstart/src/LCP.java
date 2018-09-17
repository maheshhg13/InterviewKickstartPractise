
public class LCP {
	class TrieNode{
		char curr;
		int count;
		TrieNode[] children;
		public TrieNode(char c){
			curr = c;
			count = 0;
			children = new TrieNode[26];
		}
	}
	class Trie{
		TrieNode root;
		
		public Trie(){
			root = new TrieNode('/');
		}
		
		private void addWord(String word){
			TrieNode temp = root;
			for(int i=0;i<word.length();i++){
				char curr = word.charAt(i);
				if(temp.children[curr-'a']==null){
					temp.children[curr-'a']= new TrieNode(curr);
				}
				temp = temp.children[curr-'a'];
				temp.count++;
			}
		}
		
		public void addWords(String[] words){
			for(String w:words){
				addWord(w);
			}
		}
		
		public String LCS(int count){
			TrieNode temp = root;
			StringBuffer sb = new StringBuffer();
			while(temp!=null){
				TrieNode x = null;
				for(TrieNode child:temp.children){
					if(child==null)
						continue;
					if(child.count==count){
						x = child;
						sb.append(x.curr+"");
						break;
					}
				}
				temp = x;
			}
			return sb.toString();
		}
	}
	
	public String longestCommonPrefix(String[] str){
		if(str==null || str.length==0){
			return null;
		}
		Trie trie = new Trie();
		trie.addWords(str);
		return trie.LCS(str.length);
	}
	
	public static void main(String[] args) {
		String[] words = {"abc", "abcd", "abk"};
		System.out.println(new LCP().longestCommonPrefix(words));
	}
}
