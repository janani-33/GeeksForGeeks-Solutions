//{ Driver Code Starts
// Initial template for JAVA

import java.util.Scanner;

class aToi {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();

            Solution obj = new Solution();
            int num = obj.atoi(str);

            System.out.println(num);
            t--;
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

/*You are required to complete this method */
class Solution {
    public int atoi(String s) {
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9')
            continue;
            else{
                if(i==0 && s.charAt(i)=='-')
                continue;
                else
                return -1;
            }
        }
        return Integer.parseInt(s);
    }
}
