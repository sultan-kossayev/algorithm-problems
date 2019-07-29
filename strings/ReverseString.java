import java.util.Arrays;

// https://leetcode.com/problems/reverse-string/
public class ReverseString {
	
	public static void main(String... args) {
		char[] s = new char[]{'w','e','l','c','o','m','e'};

		reverseString(s);

		System.out.println(Arrays.toString(s));
	}

	private static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        
        while (i < j) {
            char t = s[i];
            s[i] = s[j];
            s[j] = t;
            i++;
            j--;
        }
    }
}