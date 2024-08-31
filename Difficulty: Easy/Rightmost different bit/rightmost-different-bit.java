//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		
		//input number of testcases
		int t=sc.nextInt();
		int m,n;
		while(t-->0) {
		    
		    
            Solution obj = new Solution();
            //input m and n
		    m = sc.nextInt();
		    n = sc.nextInt();
		    System.out.println(obj.posOfRightMostDiffBit(m, n));
		}
	}
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
        if(m==n)
        return -1;
        String s1=Integer.toBinaryString(m);
        String s2=Integer.toBinaryString(n);
        int i=s1.length()-1,j=s2.length()-1,c=1;
        while(i>=0 && j>=0){
            if(s1.charAt(i)!=s2.charAt(j))
            return c;
            i--;
            j--;
            c++;
        }
        return c;
    }
}


