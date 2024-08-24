//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<String> ans = ob.pattern(n);
            for(int i = 0;i < n;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> pattern(int n){
        List<String> list=new ArrayList<>();
        for(int i=0;i<n;i++)
        list.add("");
        int val=1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<i;j++)
            list.set(i-1,list.get(i-1)+"--");
            for(int j=i;j<=n;j++,val++)
            list.set(i-1,list.get(i-1)+String.valueOf(val)+"*");
        }
        for(int i=n;i>=1;i--){
            for(int j=i;j<n;j++,val++)
            list.set(i-1,list.get(i-1)+String.valueOf(val)+"*");
            list.set(i-1,list.get(i-1)+String.valueOf(val++));
        }
        return list;
    }
}