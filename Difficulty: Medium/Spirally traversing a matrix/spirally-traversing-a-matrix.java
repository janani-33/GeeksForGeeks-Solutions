//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        int r=matrix.length,c=matrix[0].length;
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<r && l.size()<r*c;i++){
            int t=i,b=r-i-1,lt=i,rt=c-i-1;
            for(int j=lt;j<=rt && l.size()<r*c;j++)
            l.add(matrix[i][j]);
            for(int j=t+1;j<=b && l.size()<r*c;j++)
            l.add(matrix[j][c-i-1]);
            for(int j=rt-1;j>=i && l.size()<r*c;j--)
            l.add(matrix[r-i-1][j]);
            for(int j=b-1;j>i && l.size()<r*c;j--)
            l.add(matrix[j][i]);
        }
        return l;
    }
}
