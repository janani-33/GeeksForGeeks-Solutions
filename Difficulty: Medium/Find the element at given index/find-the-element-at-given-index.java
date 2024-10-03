//{ Driver Code Starts

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int k = Integer.parseInt(inputLine[2]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int[][] ranges = new int[k][2];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < k; i++) {
                ranges[i][0] = Integer.parseInt(inputLine[2 * i]);
                ranges[i][1] = Integer.parseInt(inputLine[2 * i + 1]);
            }

            int ans = new Solution().findElement(arr, n, x, ranges, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Solution {
    int findElement(int[] arr, int n, int x, int[][] ranges, int k) {
        // code here
        for(int i=k-1;i>=0;i--){
            int left=ranges[i][0],right=ranges[i][1];
            if(left<x && x<=right)
            x--;
            else if(left==x)
            x=right;
        }
        return arr[x];
    }
}
