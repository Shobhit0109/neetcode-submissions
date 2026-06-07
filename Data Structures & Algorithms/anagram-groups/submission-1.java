class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        final var map = new HashMap<String, List<String>>(strs.length);
        for (final var str : strs) {
            final var hash = getHash(str);
            final var arr = map.computeIfAbsent(hash, k -> new ArrayList<>());
            arr.add(str);
        }
        return map.values().stream().toList();
    }

    private String getHash(final String str) {
        final var arr = new int[26];
        for (final var ch : str.toCharArray()) {
            arr[ch - 'a']++;
        }
        return Arrays.toString(arr);
    }
}
