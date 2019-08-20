/**
*	Performs base conversion;
* 	Input: str which represents an integer in base fromBase;
* 	Output: str which represents the integer in base toBase;
* 	Zero and negative values are supported;
* 	Time complexity: O(n(1 + log toBase fromBase))
* 	Space complexity: O(1)
*
* 	Online tool for testing: https://www.tools4noobs.com/online_tools/base_convert/
* 	
*/
public class BaseConversion {

	public static void main(String... args) {		
		String str = args[0];
		int fromBase = Integer.parseInt(args[1]);
		int toBase = Integer.parseInt(args[2]);

		// first convert from source base to base 10
		int num = toBase10(str, fromBase);

		// and then convert base 10 to target base
		String res = toTargetBase(num, toBase, str.charAt(0) == '-');

		System.out.println(res);
	}

	private static int toBase10(String str, int fromBase) {
		int firstIndx = str.charAt(0) == '-'? 1:0;
		int num = 0;
		for (int i = firstIndx; i < str.length(); i++) {
			int n = Character.isDigit(str.charAt(i))? str.charAt(i) - '0' : str.charAt(i) - 'A' + 10; // 'C' - 'A' + 10 = 2 + 10 = 12
			num = num * fromBase + n;
		}

		return num;
	}

	private static String toTargetBase(int base10, int toBase, boolean negative) {
		StringBuilder res = new StringBuilder();		
		int num = base10;
		do {
			int n = num % toBase;
			String s = n >= 10 ? ""+(char)('A' + n - 10): n+"";	// 'A' + 12 - 10 = 'A' + 2 = 'C'
			res.append(s);

			num /= toBase;
		} while(num != 0);

		if (negative) {
			res.append("-");
		}

		return res.reverse().toString();
	}
}