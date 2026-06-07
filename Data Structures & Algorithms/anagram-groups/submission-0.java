class Solution {
    private static final Long MOD = (Long.MAX_VALUE - Integer.MAX_VALUE) / 31;

    public List<List<String>> groupAnagrams(final String[] strs) {
        final var map = new HashMap<Long, List<String>>(strs.length);
        for (final var str : strs) {
            final var hash = getHash(str);
            final var arr = map.computeIfAbsent(hash, k -> new ArrayList<>());
            arr.add(str);
        }
        return map.values().stream().toList();
    }

    private long getHash(final String str) {
        final var arr = new int[26];
        for (final var ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }
        long hash = 0;
        for (final var num : arr) {
            hash = (31 * hash + num) % MOD;
        }
        return hash;
    }
}
