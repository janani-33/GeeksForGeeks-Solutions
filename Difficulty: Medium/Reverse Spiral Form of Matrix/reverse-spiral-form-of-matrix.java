//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        int arr[]=new int[R*C];
        int c=0,p=R*C-1;
        for(int i=0;i<R && c<R*C;i++){
            int t=i,b=R-i-1,lt=i,rt=C-i-1;
            for(int j=lt;j<=rt && c<R*C;j++,c++,p--)
            arr[p]=a[i][j];
            for(int j=t+1;j<=b && c<R*C;j++,c++,p--)
            arr[p]=a[j][C-i-1];
            for(int j=rt-1;j>=i && c<R*C;j--,c++,p--)
            arr[p]=a[R-i-1][j];
            for(int j=b-1;j>i && c<R*C;j--,c++,p--)
            arr[p]=a[j][i];
        }
        return arr;
    }
}