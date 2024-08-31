//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.reverse(s));                        
        }
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String reverse(String str)
    {
        int i=0,j=str.length()-1;
        char a[]=str.toCharArray();
        while(i<j){
            if(!Character.isLetter(a[i])){
                i++;
                continue;
            }
            if(!Character.isLetter(a[j])){
                j--;
                continue;
            }
            char t=a[i];
            a[i]=a[j];
            a[j]=t;
            i++;
            j--;
        }
        return String.valueOf(a);
    }
}