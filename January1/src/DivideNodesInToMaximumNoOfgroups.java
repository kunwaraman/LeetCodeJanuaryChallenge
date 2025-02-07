
import java.util.*;
// ps: https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/

public class DivideNodesInToMaximumNoOfgroups {
        public int magnificentSets(int n, int[][] edges) {
            int m = edges.length;
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // o(v+e)
            for(int i=0;i<n;i++){
                list.add(new ArrayList<>());
            }
            for(int edge[]:edges){
                int u = edge[0]-1;
                int v = edge[1]-1;
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int color[] = new int[n];
            Arrays.fill(color,-1);
            // o((v)*(v+e))
            for(int node=0;node<n;node++){ // o(n)
                if(color[node]==-1){
                    if(isbipartite(list,node,color,1)==false){ // o(v+e)
                        return -1;
                    }
                }
            }
            // bfs karke max levels nikalo for each node
            boolean vis[] = new boolean[n];
            int level[] = new int[n];
            //o((v)*(v+e))
            for(int node=0;node<n;node++){ //o(v)
                level[node]=bfs(list,node,n); // o(v+e)
            }
            int maxgrpeachCom =0;
            for(int node=0;node<n;node++){
                if(vis[node]==false){ // o((v)*(v+e))
                    maxgrpeachCom+=getmaxFromEachComp(list,node,vis,level);

                }
            }
            return maxgrpeachCom;
        }
        public boolean isbipartite(ArrayList<ArrayList<Integer>> list,int curr,int color[],int currColor){
            color[curr]=currColor;
            for(int ngbr:list.get(curr)){
                if(color[ngbr]==color[curr]){
                    return false;
                }
                if(color[ngbr]==-1){
                    if(isbipartite(list,ngbr,color,1-currColor)==false){
                        return false;
                    }
                }
            }
            return true;
        }
        public int bfs(ArrayList<ArrayList<Integer>> list,int currNode,int n){
            Queue<Integer> queue = new LinkedList<>();
            boolean vis[] = new boolean[n];
            queue.add(currNode);
            vis[currNode]=true;
            int level=1; // max group in that component
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i=0;i<size;i++){
                    int curr = queue.remove();
                    for(int ngbr:list.get(curr)){
                        if(vis[ngbr]==true){
                            continue;
                        }
                        queue.add(ngbr);
                        vis[ngbr]=true;
                    }
                }
                level++; // one extra will be incremented in the last loop
            }
            return level-1;

        }
        public int getmaxFromEachComp(ArrayList<ArrayList<Integer>> list,int curr,boolean vis[],int level[]){
            int maxgrp = level[curr];
            vis[curr]=true;
            for(int ngbr:list.get(curr)){
                if(vis[ngbr]==false){
                    maxgrp=Math.max(maxgrp,getmaxFromEachComp(list,ngbr,vis,level));
                }
            }
            return maxgrp;

        }

}
