/*
* Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
* Given an integer, n, find and print the number of letter a's in the first  letters of Lilah's infinite string.
* N can be very big, up to 10^12.
*/
public class RepeatedString {
	
	public static void main(String... args) {
		String s = args[0];
		long n = Long.parseLong(args[1]);

		long count = 0;
		for(int i = 0; i < s.length();i++) {
			if (s.charAt(i) == 'a') {
				count++;
			}
		}
		
		count = count * (n / s.length());
		for (int i = 0; i < n % s.length();i++) {
			if (s.charAt(i) == 'a') {
				count++;
			}
		}

		System.out.println(count);
	}
}