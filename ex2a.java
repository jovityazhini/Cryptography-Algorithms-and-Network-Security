import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums) {
        
        // Base case
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            
            // Skip if already used
            if (temp.contains(nums[i])) continue;

            // Choose
            temp.add(nums[i]);

            // Explore
            backtrack(result, temp, nums);

            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}