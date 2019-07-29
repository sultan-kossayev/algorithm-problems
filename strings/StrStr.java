// https://leetcode.com/problems/implement-strstr
public class StrStr {
	
	public static void main(String... args) {
		String h = "hello";
		String n = "ll";

		int idx = strStr(h, n);

		System.out.println(idx);
	}

	// this is a brute-force alg
	// for implementation of KMP, Boyer-Moore, Rabin-Karp go to
	private static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        
        int h = haystack.length();
        int n = needle.length();
        for (int i = 0; i <= h - n;i++) {
            int j;
            for (j = 0; j < n;j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            
            if (j == n) {
                return i;
            }
        }
        
        return -1;
    }
}