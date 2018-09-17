package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFS_Graph {
	Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
	List<Integer> visited = new ArrayList<Integer>();
	
	public void dfs(Integer start, Map<Integer, Set<Integer>> map, List<Integer> visited){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		while(!q.isEmpty()){
			int value = q.poll();
			System.out.println(value+" ");
			visited.add(value);
			for(Integer x:map.get(value)){
				if(!visited.contains(x)){
					q.add(x);
				}
			}
		}
	}
}
