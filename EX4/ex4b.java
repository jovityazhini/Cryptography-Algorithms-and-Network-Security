class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;

        // Step 1: Build prefix XOR array
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] ^ arr[i];
        }

        // Step 2: Answer queries
        int[] ans = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            int L = queries[i][0];
            int R = queries[i][1];

            if(L == 0){
                ans[i] = prefix[R];
            } else {
                ans[i] = prefix[R] ^ prefix[L - 1];
            }
        }

        return ans;
    }
}
