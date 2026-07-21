class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int target, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);

            // i is passed again because the same number can be reused
            backtrack(nums, target - nums[i], i, current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }
}