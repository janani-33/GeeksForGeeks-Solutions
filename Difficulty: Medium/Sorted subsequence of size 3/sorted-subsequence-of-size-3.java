//{ Driver Code Starts
import java.util.*;

public class GFG {
    // Function to check if v2 is a subsequence of v1
    public static boolean isSubSequence(int[] v1, int[] v2) {
        int m = v2.length;
        int n = v1.length;
        int j = 0; // For index of v2

        // Traverse v1 and v2
        for (int i = 0; i < n && j < m; i++) {
            if (v1[i] == v2[j]) {
                j++;
            }
        }
        return j == m;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String[] input = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();
            int n = arr.length;
            Solution obj = new Solution();
            List<Integer> res = obj.find3Numbers(arr);
            if (!res.isEmpty() && res.size() != 3) {
                System.out.println(-1);
            } else {
                int[] resArray = res.stream().mapToInt(Integer::intValue).toArray();
                if (resArray.length == 0) {
                    System.out.println(0);
                } else if (resArray[0] < resArray[1] && resArray[1] < resArray[2] &&
                           isSubSequence(arr, resArray)) {
                    System.out.println(1);
                } else {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

// } Driver Code Ends


/*Complete the function below*/

class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        int n=arr.length;
        List<Integer> list=new ArrayList<>();
        int ar1[]=new int[n];
        int min=0;
        ar1[0]=-1;
        int ar2[]=new int[n];
        int max=n-1;
        ar2[n-1]=-1;
        for(int i=1;i<n;i++){
            if(arr[i]<=arr[min]){
                ar1[i]=-1;
                min=i;
            }
            else
            ar1[i]=min;
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]>=arr[max]){
                ar2[i]=-1;
                max=i;
            }
            else
            ar2[i]=max;
        }
        for(int i=0;i<n;i++){
            if(ar1[i]!=-1 && ar2[i]!=-1){
                list.add(arr[ar1[i]]);
                list.add(arr[i]);
                list.add(arr[ar2[i]]);
                break;
            }
        }
        return list;
    }
}