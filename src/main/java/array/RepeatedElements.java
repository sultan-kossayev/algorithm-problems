import java.util.*;

// https://www.firecode.io/pages/explore/402105
public class RepeatedElements {
	
	public static void main(String... args) {
		int[] nums = new int[]{1,3,4,2,1,2,4};
		String str = duplicate(nums);

		System.out.println(str);
	}

	private static String duplicate(int[] numbers){
	    Arrays.sort(numbers);
	    
	    List<Integer> list = new ArrayList<>();
	    boolean allow = true;
	    for (int i = 1; i < numbers.length;i++) {
	        if (numbers[i] == numbers[i - 1] && allow) {
	            list.add(numbers[i]);
	            allow = false;
	        } else {
	            allow = true;
	        }
	    }
	    
	    return list.toString();
	}
}