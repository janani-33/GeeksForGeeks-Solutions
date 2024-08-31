//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    static int findLastOccurence(String A,String B){
        if(!A.contains(B))
        return -1;
        int n=A.length(),m=B.length();
        String s1=new StringBuilder(A).reverse().toString();
        String s2=new StringBuilder(B).reverse().toString();
        int res=s1.indexOf(s2)+m;
        return n-res+1;
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String A = read.readLine().trim();
             String B = read.readLine().trim();
          

            Solution ob = new Solution();
            System.out.println(ob.findLastOccurence(A,B));
        }
    }
}
// } Driver Code Ends