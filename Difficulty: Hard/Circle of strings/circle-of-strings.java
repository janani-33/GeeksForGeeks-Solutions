//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String A[] = in.readLine().trim().split(" ");
            int N = Integer.parseInt(A[0]);
            A = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.isCircle(A));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public void dfs(int i,List<List<Integer>> adj,boolean v[]){
        v[i]=true;
        for(int val:adj.get(i)){
            if(!v[val])
            dfs(val,adj,v);
        }
    }
    public int isCircle(String arr[]) {
        int n=arr.length;
        int st[]=new int[26];
        int end[]=new int[26];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<26;i++)
        adj.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            char c1=arr[i].charAt(0);
            char c2=arr[i].charAt(arr[i].length()-1);
            st[c1-'a']++;
            end[c2-'a']++;
            adj.get(c1-'a').add(c2-'a');
        }
        for(int i=0;i<26;i++){
            if(st[i]!=end[i])
            return 0;
        }
        boolean v[]=new boolean[26];
        dfs(arr[0].charAt(0)-'a',adj,v);
        for(int i=0;i<26;i++){
            if(st[i]>0 && !v[i]){
            return 0;
            }
        }
        return 1;
    }
}