/**
*	Converts int to String;
*	Negative values are supported;
*/
public class Int2Str {

	public static void main(String... args) {
		int num = Integer.parseInt(args[0]);

		StringBuilder str = new StringBuilder();

		boolean negative = false;
		if (num < 0) {			
			num *= -1;
			negative = true;
		}

		// 456 => "6" + "56" + "456"
		do {
			str.append(num % 10);
			num /= 10;
		}while(num != 0);

		if (negative) {
			str.append("-");
		}

		System.out.println(str.reverse());
	}
}