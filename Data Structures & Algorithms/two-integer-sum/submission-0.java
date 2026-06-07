class Solution {
    public int[] twoSum(int[] nums, int target) {
        final var map = new HashMap<Integer, Integer>();
        for (int i =0; i<nums.length; i++) {
            final var diff = target - nums[i];

            final var mapPos = map.get(diff);
            if (mapPos != null) {
                return new int[]{mapPos, i};
            }

            map.putIfAbsent(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
