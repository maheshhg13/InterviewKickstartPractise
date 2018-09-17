package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class DFS_Graph {
	Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
	List<Integer> visited = new ArrayList<Integer>();
	
	public void dfs(Integer start, Map<Integer, Set<Integer>> map, List<Integer> visited){
		visited.add(start);
		System.out.println(start+" ");
		Iterator<Integer> child = map.get(start).iterator();
		while(child.hasNext()){
			int val = child.next();
			if(!visited.contains(val)){
				dfs(val, map, visited);
			}
		}
	}
}
