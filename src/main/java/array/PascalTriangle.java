import java.util.*;

// https://leetcode.com/problems/pascals-triangle/
public class PascalTriangle {

	public static void main(String... args) {
		List<List<Integer>> triangle = generate(5);

		System.out.println(triangle);
	}
	
	private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        for (int k = 0; k < numRows;k++) {
            List<Integer> l = new ArrayList<>();
            
            for (int i = 0; i <= k;i++) {
                if (i == 0 || i == k) {
                    l.add(1);
                } else {
                    int left = list.get(k - 1).get(i - 1);
                    int right = list.get(k - 1).get(i);
                    l.add(left + right);
                }
            }
            
            list.add(l);
        }
        
        return list;
    }
}