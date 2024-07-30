//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{  
    public ArrayList<String> permutation(String S)
    {
        ArrayList<String> list=new ArrayList<>();
        permute(0,S,list);
        Collections.sort(list);
        return list;
    }
    public void permute(int index,String s,ArrayList<String> list){
        if(index==s.length()){
            list.add(s.substring(0,index));
            return;
        }
        for(int i=index;i<s.length();i++){
            char c[]=s.toCharArray();
            char t=c[index];
            c[index]=c[i];
            c[i]=t;
            s=String.valueOf(c);
            permute(index+1,s,list);
            c=s.toCharArray();
            t=c[index];
            c[index]=c[i];
            c[i]=t;
            s=String.valueOf(c);
        }
    }
}
