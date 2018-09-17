package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumCostPath
{
    /* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
    private static int minCost_Iter(int[][] cost){
    	int[][] cache = new int[cost.length][cost[0].length];
    	for(int i=cost.length-1;i>=0; i--){
    		for(int j=cost[i].length-1;j>=0; j--){
    			if(i==cost.length-1 && j!=cost[0].length-1){
    				cache[i][j] = cost[i][j] + cache[i][j+1];
    			}else if(i!=cost.length-1 && j==cost[0].length-1){
    				cache[i][j] = cost[i][j] + cache[i+1][j];
    			}else if(i!=cost.length-1 && j!=cost[0].length-1){
    				cache[i][j] = cost[i][j] + Math.min(cache[i+1][j+1], Math.min(cache[i][j+1], cache[i+1][j]));
    			}else{
    				cache[i][j] = cost[i][j];
    			}
    		}
    	}
    	return cache[0][0];
    }
    
    private static int minCost_memo(int[][] cost, int r, int c, int[][] cache){
    	if(r>=cost.length || c>=cost[0].length){
    		return Integer.MAX_VALUE;
    	}else if(cache[r][c]!=-1){
    		return cache[r][c];
    	}else if(r==cost.length-1 && c==cost[0].length-1){
    		cache[r][c] = cost[r][c];
    	}else{
    		cache[r][c] = min(minCost_memo(cost, r+1, c+1, cache), minCost_memo(cost, r+1, c, cache), minCost_memo(cost, r, c+1, cache));
    	}
    	return cache[r][c];
    }
    private static int minCost_geeks(int cost[][], int m, int n)
    {
        int i, j;
        int tc[][]=new int[m][n];
 
        tc[0][0] = cost[0][0];
 
        /* Initialize first column of total cost(tc) array */
        for (i = 1; i < m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];
 
        /* Initialize first row of tc array */
        for (j = 1; j < n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];
        
        for(i=0;i<tc.length;i++){
        	for(j=0;j<tc[i].length;j++){
        		System.out.print(tc[i][j]+", ");
        	}
        	System.out.println();
        }
        
        /* Construct rest of the tc array */
        for (i = 1; i < m; i++)
            for (j = 1; j < n; j++)
                tc[i][j] = min(tc[i-1][j-1], 
                               tc[i-1][j],
                               tc[i][j-1]) + cost[i][j];
 
        return tc[m-1][n-1];
    }
 
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
    	//int cost[][] = {{1,2},{1,1}};
//        System.out.println("minimum cost to reach (2,2) = " +
//        		minCost_Iter(cost));
        
    }
}