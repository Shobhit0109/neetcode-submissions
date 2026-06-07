class Solution {
    public int[] twoSum(int[] nums, int target) {
        final var map = new HashMap<Integer, Integer>(nums.length / 2);
        for (int i =0; i<nums.length; i++) {
            final var mapPos = map.get(target - nums[i]);
            if (mapPos != null) {
                return new int[]{mapPos, i};
            }
            map.putIfAbsent(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
