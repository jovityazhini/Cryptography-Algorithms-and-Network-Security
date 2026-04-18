class Solution {
    public String maximumBinaryString(String binary) {

        int n = binary.length();
        int zeroCount = 0;
        int firstZero = -1;

        // Count zeros and find first zero index
        for (int i = 0; i < n; i++) {
            if (binary.charAt(i) == '0') {
                zeroCount++;
                if (firstZero == -1) {
                    firstZero = i;
                }
            }
        }

        // If 0 or 1 zero → no change
        if (zeroCount <= 1) return binary;

        // Build result
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = '1';
        }

        // Place single zero
        int zeroPos = firstZero + zeroCount - 1;
        result[zeroPos] = '0';

        return new String(result);
    }
}