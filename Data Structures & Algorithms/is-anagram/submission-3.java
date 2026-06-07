class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        final var map = new HashMap<Character, Integer>();
        for (final var ch: s.toCharArray()) {
            map.merge(ch, 1, Integer::sum);
        }
        for (final var ch: t.toCharArray()) {
            final var count = map.get(ch);

            if (count == null) {
                return false;
            }

            map.put(ch, count-1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }
        return map.size() == 0;
    }
}
