//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean validate(int i,int j,int b[][]){
        int x=i,y=j;
        while(y>=0){
            if(b[x][y--]==1) 
            return false;
        }
        x=i;
        y=j;
        while(x>=0 && y>=0){ 
            if(b[x--][y--]==1) 
            return false;
        }
        x=i;
        y=j;
        while(x<b.length && y>=0){
            if(b[x++][y--]==1) 
            return false;
        }
        return true;
    }
    public void dfs(int j,ArrayList<Integer> list,ArrayList<ArrayList<Integer>> ans,int n,int b[][]){
        if(j==n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(validate(i,j,b)){
                b[i][j]=1;
                list.add(i+1);
                dfs(j+1,list,ans,n,b);
                b[i][j]=0;
                list.remove(list.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int[][] b=new int[n][n];
        dfs(0,new ArrayList<>(),res,n,b);
        return res;
    }
}