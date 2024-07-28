//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int dfs(int[][] grid,int[][] v,int i,int j,int m,int n,int val){
        int count=0;
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        while(!q.isEmpty()){
            int p[]=q.remove();
            v[p[0]][p[1]]=val;
            count++;
            for(int k=0;k<4;k++){
                int dx=p[0]+x[k];
                int dy=p[1]+y[k];
                if(dx>=0 && dx<n && dy>=0 && dy<m && v[dx][dy]==-1 && grid[dx][dy]==1){
                    q.add(new int[]{dx,dy});
                    v[dx][dy]=val;
                }
            }
        }
        return count;
    }
    public int MaxConnection(int grid[][]) {
        int n=grid.length,m=grid[0].length,max=0;
        int v[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                v[i][j]=-1;
            }
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int val=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && v[i][j]==-1){
                    int count=dfs(grid,v,i,j,n,m,val);
                    map.put(val,count);
                    val++;
                    if(count>max)
                    max=count;
                }
            }
        }
        ArrayList<Integer> list=new ArrayList<>();
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int sum=1;
                    for(int k=0;k<4;k++){
                        int dx=i+x[k];
                        int dy=j+y[k];
                        if(dx>=0 && dx<n && dy>=0 && dy<m && grid[dx][dy]==1 && !list.contains(v[dx][dy])){
                            sum+=map.get(v[dx][dy]);
                            list.add(v[dx][dy]);
                        }
                    }
                    if(sum>max)
                    max=sum;
                    list.clear();
                }
            }
        }
        return max;
    }
}