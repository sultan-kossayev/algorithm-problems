// https://leetcode.com/problems/longest-common-prefix/
public class LongestCommonPrefix {
	
	public static void main(String... args) {
		String[] strs = new String[]{"hello", "he", "h"};

		String prefix = longestCommonPrefix(strs);

		System.out.println(prefix);
	}

	private static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String first = strs[0];        
        for (int i = 0; i < first.length();i++) {
            char c = first.charAt(i);
            for (int j = 1; j < strs.length;j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }
        
        return first;
    }
}