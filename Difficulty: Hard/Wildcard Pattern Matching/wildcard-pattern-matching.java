//{ Driver Code Starts
import java.util.*;

class WildcardPattern {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String pat = sc.nextLine();
            String text = sc.nextLine();
            Solution g = new Solution();
            System.out.println(g.wildCard(pat, text));
            t--;
        }
    }
}
// } Driver Code Ends


class Solution {
    public int wildCard(String pattern, String str) {
        int n=pattern.length(),m=str.length();
        int[][] dp=new int[n][m];
        for(int[] i:dp)
        Arrays.fill(i,-1);
        if(check(pattern, str, n-1, m-1,dp))
        return 1;
        else
        return 0;
    }
    public boolean check(String pattern,String str,int n,int m,int[][] dp){
        if(n<0 && m<0)
        return true;
        if((n<0 && m>=0) || (m<0 && n>=0 && pattern.charAt(n)!='*'))
        return false;
        if(m<0 && n>=0 && pattern.charAt(n)=='*')
        return check(pattern, str, n-1,m,dp);
        if(dp[n][m]!=-1) {
            if(dp[n][m]==1)
            return true;
            else
            return false;
        }
        boolean s=false,ns=false;
        if(pattern.charAt(n)=='*'){
            boolean mul=check(pattern,str,n,m-1,dp);
            boolean emp=check(pattern,str,n-1,m,dp);
            boolean one=check(pattern,str,n-1,m-1,dp);
            s=mul || emp || one;
        }
        else if(pattern.charAt(n)=='?'){
            s=check(pattern,str,n-1,m-1,dp);
        }
        else if(pattern.charAt(n)==str.charAt(m))
        ns=check(pattern,str,n-1,m-1,dp);
        dp[n][m]=s || ns?1:0;
        return s||ns;
    }
}
