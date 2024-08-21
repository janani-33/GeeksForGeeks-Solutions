//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<n;i++)
        g.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            g.get(u).add(v);
            g.get(v).add(u);
        }
        int[] res=new int[n];
        Arrays.fill(res,-1);
        Set<Integer> v=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        res[src]=0;
        q.add(src);
        v.add(src);
        int c=1;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int p=q.remove();
                for(int val:g.get(p)){
                    if(!v.contains(val)){
                        res[val]=c;
                        q.add(val);
                        v.add(val);
                    }
                }
            }
            c++;
        }
        return res;
    }
}