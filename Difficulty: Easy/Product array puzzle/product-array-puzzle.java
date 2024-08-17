//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        int n=nums.length,c=0;
        long res[]=new long[n];
        long prod=1;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                c++;
                continue;
            }
            prod*=(long)nums[i];
        }
        if(c>1)
        return res;
        for(int i=0;i<n;i++){
            if(c!=0){
                if(nums[i]==0)
                res[i]=prod;
            }
            else
            res[i]=prod/nums[i];
        }
        return res;
    }
}
