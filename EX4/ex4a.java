import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> seen = new HashSet<>();
        Set<String> result = new HashSet<>();

        if (s.length() < 10) return new ArrayList<>();

        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);

        int hash = 0;

        // First 9 chars
        for (int i = 0; i < 9; i++) {
            hash = (hash << 2) | map.get(s.charAt(i));
        }

        // Sliding window
        for (int i = 9; i < s.length(); i++) {
            hash = (hash << 2) | map.get(s.charAt(i));

            // Keep only last 20 bits
            hash = hash & ((1 << 20) - 1);

            if (seen.contains(hash)) {
                result.add(s.substring(i - 9, i + 1));
            } else {
                seen.add(hash);
            }
        }

        return new ArrayList<>(result);
    }
}
