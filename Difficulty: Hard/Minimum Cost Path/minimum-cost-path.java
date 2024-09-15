//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Tuple{
    int r;
    int c;
    int d;
    Tuple(int r,int c,int d){
        this.r=r;
        this.c=c;
        this.d=d;
    }
}
class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
    public int minimumCostPath(int[][] grid)
    {
        int n=grid.length;
        int[][] cost=new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(cost[i],Integer.MAX_VALUE);
        int x[]={-1,0,1,0};
        int y[]={0,-1,0,1};
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)->a.d-b.d);
        pq.add(new Tuple(0,0,grid[0][0]));
        cost[0][0]=grid[0][0];
        while(!pq.isEmpty()){
            Tuple t=pq.remove();
            int curr=t.r,curc=t.c,curd=t.d;
            for(int i=0;i<4;i++){
                int dx=x[i]+curr,dy=y[i]+curc;
                if(dx>=0 && dx<n && dy>=0 && dy<n && curd+grid[dx][dy]<cost[dx][dy]){
                    cost[dx][dy]=curd+grid[dx][dy];
                    pq.add(new Tuple(dx,dy,curd+grid[dx][dy]));
                }
            }
        }
        return cost[n-1][n-1];
    }
}