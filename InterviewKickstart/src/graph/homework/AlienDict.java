package graph.homework;

public class AlienDict {
	static int count=0;
    static String findOrder(String[] dict) {
        boolean[][] graph = new boolean[26][26];
        int[] status = new int[26];
        for(int i=0;i<dict.length;i++){
            char[] current = dict[i].toCharArray();
            for(char c:current){
                status[c-'a'] = 1;
            }
            if(i>0){
                char[] previous = dict[i-1].toCharArray();
                int len = Math.min(current.length, previous.length);
                for(int j=0;j<len;j++){
                    if(current[j]!=previous[j]){
                        graph[current[j]-'a'][previous[j]-'a'] = true;
                        break;
                    }
                }
            }
        }
        char[] result = new char[26];
        for(int m=0;m<26;m++){
            if(status[m]==1 && !topologicalSort(m, graph, status, result)){
                return "";
            }
        }
        return new String(result, 0, count);
    }
    
    public static boolean topologicalSort(int i, boolean[][] graph, int[] status, char[] result){
        if(status[i]==2){
            return false;
        }
        
        status[i] = 2;
        for(int j=0;j<26;j++){
            if(graph[i][j] && status[j]!=3 && !topologicalSort(j, graph, status, result)){
                return false;
            }
        }
        status[i] = 3;
        result[count++]=(char)(i+'a');
        return true;
    }
}
