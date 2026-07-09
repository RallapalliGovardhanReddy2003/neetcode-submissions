class Solution {
    public int findDuplicate(int[] nums) {
        // Set<Integer> set = new java.util.HashSet<>();

        // for (int num : nums) {
        //     if (!set.add(num)) {
        //         return num;
        //     }
        // }

        // return -1;

         int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Find the meeting point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
        
    }
}
