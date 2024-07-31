//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        int n=arr.length;
        if(n==1)
        return arr[0];
        String str="";
        for(int i=0;i<n;i++){
            char ch=arr[0].charAt(i);
            int c=1;
            for(int j=1;j<n;j++){
                if(j<arr[j].length() && arr[j].charAt(i)==ch)
                c++;
            }
            if(c!=n)
            break;
            str+=ch;
        }
        if(str.equals(""))
        return "-1";
        else
        return str;
    }
}