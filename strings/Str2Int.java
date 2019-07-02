/**
*	Converts String to int;
* 	Negative values are supported;
*/
public class Str2Int {

	public static void main(String... args) {
		String str = args[0];

		int fistIndx = str.charAt(0) == '-'? 1:0;
		int num = 0;		
		for (int i = fistIndx; i < str.length();i++) {
			int n = str.charAt(i) - '0';			

			// "456" => 4 + (4 * 10 + 5) + (45 * 10 + 6)
			num = num * 10 + n;
		}

		// support for negatives
		if (fistIndx == 1) {
			num *= -1;
		}

		System.out.println(num);
	}
}