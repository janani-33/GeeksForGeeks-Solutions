//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(int i:arr){
            if(i<0)
            neg.add(i);
            else
            pos.add(i);
        }
        int p=0;
        arr.clear();
        while(p<pos.size() && p<neg.size()){
            arr.add(pos.get(p));
            arr.add(neg.get(p));
            p++;
        }
        while(p<pos.size()){
            arr.add(pos.get(p));
            p++;
        }
        while(p<neg.size()){
            arr.add(neg.get(p));
            p++;
        }
    }
}