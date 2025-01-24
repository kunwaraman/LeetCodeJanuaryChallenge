public class FindEventualSafeStates {public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    for(int i=0;i<n;i++){
        list.add(new ArrayList<>());
    }
    for(int i=0;i<n;i++){
        for(int neigh:graph[i]){
            list.get(i).add(neigh);
        }
    }
    // for(int gph[]:graph){ // suppose agar graph aisha hua
    //   int[][] graph = {{0}, {1}, {2}} so that case we can use this that swhy we use up wala
    //     int u = gph[0];
    //     int v = gph[1];
    //     list.get(u).add(v);
    //     list.get(v).add(u);
    // }
    ArrayList<Integer> safe = new ArrayList<>();
    boolean vis[] = new boolean[n];
    boolean inRecur[] = new boolean[n];
    for(int i=0;i<n;i++){
        if(vis[i]==false){
            isCycle(list,i,vis,inRecur);
        }

    }
    for(int i=0;i<n;i++){
        if(inRecur[i]==false){
            safe.add(i);
        }
    }
    return safe;

}
    public boolean isCycle(ArrayList<ArrayList<Integer>> list,int u,boolean vis[],boolean inRecur[]){
        vis[u]=true;
        inRecur[u]=true;
        for(int v:list.get(u)){
            if(vis[v]==false && isCycle(list,v,vis,inRecur)){
                return true;
            }else if(inRecur[v]==true){
                return true;
            }
        }
        inRecur[u]=false;
        return false;

    }
}
