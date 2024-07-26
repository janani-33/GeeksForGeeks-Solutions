//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean kPangram(String str, int k) {
        int s=0;
        Set<Character> hs=new HashSet<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>='a' && ch<='z'){
                if(!hs.contains(ch))
                hs.add(ch);
                else
                s++;
            }
        }
        int changes=26-hs.size();
        if(hs.size()==26 || (s>=changes && changes<=k))
        return true;
        else
        return false;
    }
}