public class PermutationBasicTest {

	public static void main(String[] args) {

		for (int i = 1; i <= 3; i++) {

			for (int j = 1; j <= 3; j++) {

				if (i == j) continue;

				for (int k = 1; k <= 3; k++) {

					if (i == k || j == k) continue;
					System.out.println(i + " " +  j + " " + k);
				}
			}
		}
	}

}
