// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] height = new int[]{1,8,6,2,5,4,8,3,7};

		int area = maxArea(height);

		System.out.println(area);
	}

	// 1. the farther the lines the more will be the area
	// 2. the area formed between 2 lines will always be limited by the shorter one
	// 3. once we identified the shorter line, we should check the line which is next or before it, because
	// we will never get the bigger area that we have already if we stay on this line. 
	// So, we should move on and hope that there will a higher line.
	private static int maxArea(int[] height) {
        int max = 0;
        
        for (int i = 0, j = height.length - 1; i < j;) {
            max = Math.max(max, Math.min(height[j],height[i]) * (j - i));
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        
        return max;
    }
}