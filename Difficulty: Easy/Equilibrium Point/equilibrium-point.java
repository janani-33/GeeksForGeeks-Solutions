//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            long[] arr = new long[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.equilibriumPoint(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    // arr: input array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[]) {
        int n=arr.length;
        long l[]=new long[n];
        long r[]=new long[n];
        l[0]=arr[0];
        r[n-1]=arr[n-1];
        for(int i=1;i<n;i++)
        l[i]=l[i-1]+arr[i];
        for(int i=n-2;i>=0;i--)
        r[i]=r[i+1]+arr[i];
        for(int i=0;i<n;i++){
            if(l[i]==r[i])
            return i+1;
        }
        return -1;
    }
}
