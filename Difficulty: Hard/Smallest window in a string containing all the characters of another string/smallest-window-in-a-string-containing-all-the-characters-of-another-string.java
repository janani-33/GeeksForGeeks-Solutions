//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        if(s.length()<p.length()) 
        return "-1";
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:p.toCharArray()) 
        map.put(ch,map.getOrDefault(ch, 0)+1);
        int l=0,min=Integer.MAX_VALUE,minst=0,c=0;
        HashMap<Character,Integer> window=new HashMap<>();
        for(int r=0;r<s.length();r++){
            char rch=s.charAt(r);
            if(map.containsKey(rch)){
                window.put(rch,window.getOrDefault(rch,0)+1);
                if(window.get(rch)<=map.get(rch)) 
                c++;
            }
            while(c==p.length()){
                if(r-l+1< min){
                    min=r-l+1;
                    minst=l;
                }
                char left=s.charAt(l);
                if(map.containsKey(left)){
                    window.put(left,window.get(left)-1);
                    if(window.get(left)<map.get(left)) 
                    c--;
                }
                l++;
            }
        }
        return min==Integer.MAX_VALUE ?"-1":s.substring(minst,minst+min);

    }
}