// https://leetcode.com/problems/add-binary
public class AddBinary {
	
	public static void main(String... args) {
		String a = "11";
		String b = "1";

		String res = addBinary(a,b);
		System.out.println(res);
	}

	private static String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        
        int carryout = 0;
        while(i >= 0 || j >= 0) {
            int sum = carryout;
            
            if (i >= 0) {
                sum += a.charAt(i) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
            }
            
            str.append(sum % 2);
            carryout = sum / 2;
            i--;
            j--;
        }
        
        if(carryout != 0) {
            str.append(carryout);
        }
        
        return str.reverse().toString();
    }
}