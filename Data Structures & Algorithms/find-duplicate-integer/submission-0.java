class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> set = new java.util.HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }

        return -1;
        
    }
}
