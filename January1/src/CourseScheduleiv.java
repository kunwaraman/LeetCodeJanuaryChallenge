import java.util.*;
// ps: https://leetcode.com/problems/course-schedule-iv
// time complexity O(Q∗(V+E))
// space complexity O(V+E)
public class CourseScheduleiv {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] preq:prerequisites){
            int u = preq[0];
            int v = preq[1];
            adj.get(u).add(v);
        }
        int q = queries.length;
        List<Boolean> list = new ArrayList<>(q);
        for(int i=0;i<q;i++){
            int u = queries[i][0]; // source
            int v = queries[i][1]; // dest
            boolean vis[] = new boolean[numCourses];
            list.add(dfs(adj,u,v,vis));
        }
        return list;
    }
    private boolean dfs(ArrayList<ArrayList<Integer>> adj,int src,int dest,boolean vis[]){
        vis[src]=true;
        if(src==dest){
            return true;
        }
        boolean isreach=false;
        for(int v:adj.get(src)){
            if(vis[v]==false){
                isreach=isreach|| dfs(adj,v,dest,vis);
            }
        }
        return isreach;
    }
}
