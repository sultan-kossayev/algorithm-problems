import java.util.Arrays;

public class ReplaceDoubleAndRemoveOne {
	
	public static void main(String... args) {
		char[] chars = Arrays.copyOf(args[0].toCharArray(), 100);
		int size = Integer.parseInt(args[1]);

		int insIdx = 0;
		int aCount = 0;
		for (int i = 0; i < size;i++) {
			if (chars[i] != 'b') {
				chars[insIdx++] = chars[i];
			}

			if (chars[i] == 'a') {
				aCount++;
			}
		}


		int currIdx = insIdx - 1;
		insIdx = insIdx + aCount - 1;
		
		while (currIdx >= 0) {
			if (chars[currIdx] == 'a') {
				chars[insIdx--] = 'd';
				chars[insIdx--] = 'd';
			} else {
				chars[insIdx--] = chars[currIdx];			
			}

			currIdx--;
		}

		System.out.println(Arrays.toString(chars));
	}
}