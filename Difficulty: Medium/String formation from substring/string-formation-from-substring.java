//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input = read.readLine();
            
            Solution ob = new Solution();
            int result = ob.isRepeat(input);
            
            System.out.println(result);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isRepeat(String s) {
        String res=s+s;
        if(res.indexOf(s,1)<s.length())
        return 1;
        return 0;
    }
}