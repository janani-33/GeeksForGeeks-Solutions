//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int lps(String str) {
        int len=0,i=1,n=str.length();
        int[] arr=new int[n];
        while(i<str.length()){
            if(str.charAt(len)==str.charAt(i)){
                len++;
                arr[i]=len;
                i++;
            }
            else{
               if(len>0)len=arr[len-1]; 
               else i++;
            }
        }
        return arr[n-1];
    }
}