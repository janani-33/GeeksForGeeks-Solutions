class Solution {
    public ArrayList<Integer> getMinMax(int[] arr) {
        // code Here
        int min=arr[0],max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min) min=arr[i];
            if(arr[i]>max) max=arr[i];
        }
        return new ArrayList(Arrays.asList(min,max));
    }
}
