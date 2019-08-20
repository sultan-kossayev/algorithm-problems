import java.util.Arrays;

public class ReplaceChar {
	
	public static void main(String[] args) {
		char[] str = Arrays.copyOf(args[0].toCharArray(), 100);

		int d = 0;
		char r = ' ';
		for (int i = 0; i < str.length; i++) {
			if (str[i] == 'a') {
				d++;
			} else if (d > 0) {
				r = str[i];
				str[i] = '@';
				d--;
			} else if (r != ' ') {
				char t = str[i];
				str[i] = r;
				r = t;
			}
		}

		System.out.println(Arrays.toString(str));
	}
}