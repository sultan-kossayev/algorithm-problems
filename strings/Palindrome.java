//https://www.firecode.io/pages/explore/402142
public class Palindrome {
	
	public static void main(String... args) {
		String str = "moom";
		boolean b = isPalindrome(str);

		System.out.println(b);
	}

	private static boolean isPalindrome(String str) {
		if (str == null || str.equals("")) {
	        return true;
	    }
	    
	    for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
	        char b = str.charAt(i);
	        char e = str.charAt(j);
	        
	        if (b != e) {
	            return false;
	        }
	    }
	    
	    return true;
	}
}