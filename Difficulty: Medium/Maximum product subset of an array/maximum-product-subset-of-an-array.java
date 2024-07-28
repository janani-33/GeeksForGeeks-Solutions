//{ Driver Code Starts
import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) list.add(sc.nextInt());

            Solution obj = new Solution();
            long ans = obj.findMaxProduct(list);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    public long findMaxProduct(List<Integer> arr) {
        int n=arr.size();
        if(n==1)
        return arr.get(0);
        long zero=0,neg=0,max=Integer.MIN_VALUE,prod=1;
        for(int i=0;i<n;i++){
            if(arr.get(i)==0){
                zero++;
                continue;
            }
            if(arr.get(i)<0){
                neg++;
                max=Math.max(max,arr.get(i));
            }
            prod=(prod*arr.get(i))%((long)Math.pow(10,9)+7);
        }
        if(zero==n || (neg==1 &&zero==n-1))
        return 0;
        if(neg%2!=0)
        return prod/max;
        else
        return prod;
    }
}