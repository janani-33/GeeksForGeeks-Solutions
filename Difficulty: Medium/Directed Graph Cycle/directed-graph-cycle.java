//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

/*Complete the function below*/

class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        boolean rec[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(checkcyclic(i,visited,rec,adj))
            return true;
        }
        return false;
    }
    public boolean checkcyclic(int i,boolean[] visited,boolean[] rec,ArrayList<ArrayList<Integer>> adj){
        if(rec[i])
        return true;
        if(visited[i])
        return false;
        rec[i]=true;
        visited[i]=true;
        ArrayList<Integer> list =adj.get(i);
        for(int c:list){
            if(checkcyclic(c,visited,rec,adj))
            return true;
        }
        rec[i]=false;
        return false;
    }
}