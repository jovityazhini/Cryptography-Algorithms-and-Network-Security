import java.util.*;

class Solution {

    public long countPairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            String pattern = getPattern(word);
            map.put(pattern, map.getOrDefault(pattern, 0) + 1);
        }

        long count = 0;

        for (int freq : map.values()) {
            count += (long) freq * (freq - 1) / 2;
        }

        return count;
    }

    private String getPattern(String word) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < word.length(); i++) {
            int diff = (word.charAt(i) - word.charAt(i - 1) + 26) % 26;
            sb.append(diff).append(",");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] words = new String[n];

        // Input words
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }

        Solution sol = new Solution();
        long result = sol.countPairs(words);

        System.out.println(result);
    }
}
