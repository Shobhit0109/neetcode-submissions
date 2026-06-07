class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var map = new HashMap<Integer, Integer>(nums.length);
        for (final var num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        final List<Integer>[] buckets = new ArrayList[nums.length];
        map.forEach((key, value) -> {
            var arr = buckets[value - 1];
            if (arr == null) {
                arr = new ArrayList<>();
                arr.add(key);
                buckets[value - 1] = arr;
            } else {
                arr.add(key);
            }
        });

        var result = new int[k];
        int idx = 0;

        for (int freq = buckets.length - 1; freq >= 0 && idx < k; freq--) {
            if (buckets[freq] == null) {
                continue;
            }
            for (int num : buckets[freq]) {
                result[idx++] = num;
                if (idx == k) {
                    return result;
                }
            }
        }
        return result;
    }
}
