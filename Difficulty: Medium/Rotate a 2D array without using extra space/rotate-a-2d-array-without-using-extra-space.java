//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[][] arr = new int[n][n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * n + j]);
                }
            }

            new Solution().rotateMatrix(arr, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(arr[i][j] + " ");
                }
            }
            out.println();
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {
    void rotateMatrix(int arr[][], int n) {
        int m=arr[0].length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<m-i-1;j++){
                int temp=arr[n-j-1][i];
                arr[n-j-1][i]=arr[i][j];
                arr[i][j]=arr[j][m-i-1];
                arr[j][m-i-1]=arr[n-i-1][n-j-1];
                arr[n-i-1][n-j-1]=temp;
            }
        }
    }
}