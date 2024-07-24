//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.minCandy(n, a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

// User function Template for Java

class Solution {
    static int minCandy(int N, int ratings[]) {
        // code here
        int c[]=new int[N];
        int l[]=new int[N];
        int r[]=new int[N];
        for(int i=0;i<N;i++)
        l[i]=r[i]=1;
        for(int i=1;i<N;i++){
            if(ratings[i-1]<ratings[i])
            l[i]=l[i-1]+1;
        }
        for(int i=N-2;i>=0;i--){
            if(ratings[i+1]<ratings[i])
            r[i]=r[i+1]+1;
        }
        for(int i=0;i<N;i++)
        c[i]=(r[i]>l[i])?r[i]:l[i];
        int sum=0;
        for(int i=0;i<N;i++)
        sum+=c[i];
        return sum;
    }
}
