class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var map = new HashMap<Integer, Integer>(nums.length);
        for (final var num: nums) {
            map.merge(num, 1, Integer::sum); 
        }
        final var heap = new PriorityQueue<Map.Entry<Integer, Integer>> (
            Comparator.comparing(Map.Entry::getValue)
        );
        for (var entry : map.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll().getKey();
        }
        return result;
    }
}
