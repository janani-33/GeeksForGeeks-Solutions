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


class Solution
{
    //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
	class Tuple
    {
        int row,col,cost;
        Tuple(int row, int col,int cost){
            this.row=row;
            this.col=col;
            this.cost=cost;
        }
    }
    int [][] d={{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumCostPath(int[][] grid)
    {
        int n=grid.length;
        int [][] cost=new int[n][n];
        for(int [] sub:cost) 
        Arrays.fill(sub,1000000000);
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)-> a.cost - b.cost);
        pq.add(new Tuple(0,0,grid[0][0]));
        cost[0][0] = grid[0][0];        
        while(!pq.isEmpty())
        {
            Tuple t = pq.remove();
            int row = t.row;
            int col = t.col;
            int prev= t.cost;
            
            for(int [] dir:d)
            {
                int dx=row+dir[0];
                int dy=col+dir[1];
                
                if(dx>=0 && dx<n  &&  dy>=0  &&  dy<n)
                {
                    int p=grid[dx][dy]+prev;
                    if(cost[dx][dy]>p)
                    {
                        cost[dx][dy]=p;
                        pq.add(new Tuple(dx,dy,p));
                    }
                }
            }
        }
        return cost[n-1][n-1];
    }
}