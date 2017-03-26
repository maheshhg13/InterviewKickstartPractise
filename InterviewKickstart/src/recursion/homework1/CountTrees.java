package recursion.homework1;

public class CountTrees {
	static int countTrees(int iNodeCount) {
        if(iNodeCount<=1){
            return 1;
        }
        int count = 0;
        for(int i=1;i<=iNodeCount;i++){
            int left = countTrees(i-1);
            int right = countTrees(iNodeCount-i);
            count+=(left*right);
        }
        System.out.println("Returning count: "+count+" for tree: "+iNodeCount);
        return count;

    }
	public static void main(String[] args) {
		    System.out.println(countTrees(3));
	}

}
