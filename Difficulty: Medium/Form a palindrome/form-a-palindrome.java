//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String str)
    {
        int n=str.length();
        int dp[][]=new int[n][n];
        for(int i=1;i<n;i++) {
            for(int j=0,k=i;k<n;j++,k++) {
                dp[j][k]=(str.charAt(j)==str.charAt(k))?dp[j+1][k-1]:(Math.min(dp[j][k-1],dp[j+1][k])+1);
            }
        }
        return dp[0][n-1];
    }
}