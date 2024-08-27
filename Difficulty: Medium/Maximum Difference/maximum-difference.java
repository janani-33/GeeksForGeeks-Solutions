//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findMaxDiff(int[] arr) {
        int n=arr.length;
        int l[]=new int[n];
        int r[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>=arr[i])
            st.pop();
            if(!st.isEmpty())
            l[i]=st.peek();
            else
            l[i]=0;
            st.push(arr[i]);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr[i])
            st.pop();
            if(!st.isEmpty())
            r[i]=st.peek();
            else
            r[i]=0;
            st.push(arr[i]);
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        max=Math.max(max,Math.abs(l[i]-r[i]));
        return max;
    }
}
