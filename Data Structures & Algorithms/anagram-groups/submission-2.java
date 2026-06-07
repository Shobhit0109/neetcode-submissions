class Solution {
    public List<List<String>> groupAnagrams(final String[] strs) {
        final var map = new HashMap<String, List<String>>(strs.length);
        for (final var str : strs) {
            final var charArr = str.toCharArray();
            Arrays.sort(charArr);
            final var hash = String.valueOf(charArr);
            final var arr = map.computeIfAbsent(hash, k -> new ArrayList<>());
            arr.add(str);
        }
        return map.values().stream().toList();
    }
}
