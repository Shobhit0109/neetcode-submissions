class Solution {
    public boolean hasDuplicate(int[] nums) {
        final var set = new HashSet<>();
        for (final var num: nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}