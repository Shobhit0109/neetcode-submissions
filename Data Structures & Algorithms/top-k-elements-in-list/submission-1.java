class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        final var map = new HashMap<Integer, Integer>(nums.length);
        for (final var num: nums) {
            map.merge(num, 1, Integer::sum); 
        }
        final var list = map.entrySet()
            .stream()
            .sorted(Comparator.comparing(Map.Entry<Integer, Integer>::getValue).reversed())
            .toList();

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }
}
