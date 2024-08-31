//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        Stack<String> st=new Stack<>();
        int n=s.length();
        String res="";
        for(int i=0;i<n;i++){
            while(i<n && s.charAt(i)!=']'){
                st.push(s.substring(i,i+1));
                i++;
            }
            if(s.charAt(i)==']'){
                String temp="";
                while(!st.isEmpty() && !st.peek().equals("["))
                temp=st.pop()+temp;
                st.pop();
                String c="";
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0)))
                c=st.pop()+c;
                int count=Integer.parseInt(c);
                st.push(temp.repeat(count));
            }
        }
        while(!st.isEmpty())
        res+=st.pop();
        return res;
    }
}