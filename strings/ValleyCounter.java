public class ValleyCounter {

	public static void main(String... args) {
		String s = args[0];
		int n = Integer.parseInt(args[1]);

		int curr = 0;
		boolean flag = false;
		int val = 0;
		for (int i = 0; i < n; i++) {
			char step = s.charAt(i);

			curr = step == 'U'? curr + 1 : curr - 1;

			if (curr == -1 && !flag) {
				flag = true;
			} else if (curr == 0 && flag) {
				val++;
				flag = false;
			}
		}

		System.out.println(val);
	}
}