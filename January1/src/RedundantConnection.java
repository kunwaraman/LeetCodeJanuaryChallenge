import java.util.*;
//ps: https://leetcode.com/problems/redundant-connection/
// time complexity o(n)
// space complexity o(n)
// bfs
class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int edge[]:edges){
            int u = edge[0];
            int v = edge[1];
            if(map.containsKey(u) && map.containsKey(v)){
                boolean vis[] = new boolean[n+1];
                if(dfs(map,u,v,vis)==true){
                    return edge;
                }
            }
            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }
        return new int[0];
    }
    public boolean dfs(HashMap<Integer,List<Integer>> map,int u,int v,boolean vis[]){
        vis[u]=true;
        if(u==v){
            return true;
        }
        for(Integer ngbr:map.get(u)){
            if(vis[ngbr]==true){
                continue;
            }
            if(dfs(map,ngbr,v,vis)==true){
                return true;
            }
        }
        return false;
    }
}