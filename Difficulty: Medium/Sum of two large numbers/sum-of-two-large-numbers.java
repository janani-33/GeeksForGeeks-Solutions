//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String x = read.readLine();
            String y = read.readLine();
            Solution ob = new Solution();
            String result = ob.findSum(x, y);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String findSum(String X, String Y) {
        int p1=X.length()-1,p2=Y.length()-1,carry=0,i=0;
        String res="";
        while(p1>=0 || p2>=0){
            int a=0,b=0;
            if(p1>=0)
            a=Integer.parseInt(X.substring(p1,p1+1));
            if(p2>=0)
            b=Integer.parseInt(Y.substring(p2,p2+1));
            int sum=a+b+carry;
            res=sum%10+res;
            if(carry==1)
            carry=0;
            if(sum>=10)
            carry=1;
            p1--;
            p2--;
        }
        if(carry==1)
        res="1"+res;
        int p=res.length();
        while(i<p && res.charAt(i)=='0')
        i++;
        if(i==p)
        return "0";
        else
        return res.substring(i);
    }
}