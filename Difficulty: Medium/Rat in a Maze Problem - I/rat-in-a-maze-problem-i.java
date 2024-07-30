//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        int n=mat.length;
        ArrayList<String> res=new ArrayList<>();
        if(mat[0][0]==0 || mat[n-1][n-1]==0)
        return res;
        boolean[][] v=new boolean[n][n];
        v[0][0]=true;
        reachdest(mat,n,0,0,v,res,"");
        Collections.sort(res);
        return res;
    }
    public static void reachdest(int[][] m,int n,int cx,int cy,boolean[][] v,ArrayList<String> res,String str){
        int x[]={-1,1,0,0};
        int y[]={0,0,-1,1};
        char c[]={'U','D','L','R'};
        if(cx==n-1 && cy==n-1){
            res.add(str);
            return;
        }
        for(int i=0;i<4;i++){
            int dx=cx+x[i];
            int dy=cy+y[i];
            if(dx>=0 && dx<n && dy>=0 && dy<n && !v[dx][dy] && m[dx][dy]==1){
                v[dx][dy]=true;
                str=str+c[i];
                reachdest(m,n,dx,dy,v,res,str);
                str=str.substring(0,str.length()-1);
                v[dx][dy]=false;
            }
        }
    }
}