//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int findK(int A[][], int n, int m, int k)
    {
        ArrayList<Integer> l=new ArrayList<>();
        for(int i=0;i<n && l.size()<n*m;i++){
            int t=i,b=n-i-1,lt=i,rt=m-i-1;
            for(int j=lt;j<=rt && l.size()<n*m;j++)
            l.add(A[i][j]);
            for(int j=t+1;j<=b && l.size()<n*m;j++)
            l.add(A[j][m-i-1]);
            for(int j=rt-1;j>=i && l.size()<n*m;j--)
            l.add(A[n-i-1][j]);
            for(int j=b-1;j>i && l.size()<n*m;j--)
            l.add(A[j][i]);
        }
        int val=l.get(k-1);
        return val;
    }
}