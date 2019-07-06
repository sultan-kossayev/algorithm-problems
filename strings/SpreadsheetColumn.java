/**
* Spreadsheets often use an alphabetical encoding of the successive columns. 
* Specifically, columns are identified by "A", "B", "C", . . ., "X", "Y", "Z", "AA", "AB", ...,
* "ZZ", "AAA", "AAB",....
* Implement a function that converts a spreadsheet column id to the corresponding
* integer, with "A" corresponding to 1. For example, you should return 4 for "D", 27
* for "AA", 702 for "ZZ", etc.
*	
* Time complexity: O(n)
* Space complexity: O(1)
*/
public class SpreadsheetColumn {
	
	public static void main(String... args) {
		String str = args[0].toUpperCase();

		int res = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int num = c - 'A' + 1;	// 'D' - 'A' + 1 = 3 + 1 = 4

			res = res * 26 + num;	// base 26
		}

		System.out.println(res);
	}
}