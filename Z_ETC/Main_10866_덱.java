package Z_ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10866_덱 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] deque = new int[N + 1];
		int lastIdx = -1;

		int num;
		for (int i = 0; i < N; i++) {
			//System.out.println(Arrays.toString(deque));
			//System.out.println(lastIdx);
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case ("push_front"):
				num = Integer.parseInt(st.nextToken());
				if (lastIdx != -1) {
					for (int j = lastIdx + 1; j > 0; j--) {
						deque[j] = deque[j - 1];
					}
				}
				deque[0] = num;
				lastIdx++;
				break;
			case ("push_back"):
				num = Integer.parseInt(st.nextToken());
				lastIdx++;
				deque[lastIdx] = num;
				break;

			case ("pop_front"):
				if (lastIdx == -1) {
					System.out.println(-1);
				} else {
					System.out.println(deque[0]);
					deque[0] = 0;
					for (int j = 0; j < lastIdx; j++) {
						deque[j] = deque[j + 1];
					}
					deque[lastIdx] = 0;
					lastIdx--;
				}
				break;

			case ("pop_back"):
				if (lastIdx == -1) {
					System.out.println(-1);
				} else {
					System.out.println(deque[lastIdx]);
					deque[lastIdx] = 0;
					lastIdx--;
				}
				break;

			case ("size"):
				System.out.println(lastIdx + 1);
				break;

			case ("empty"):
				System.out.println(lastIdx == -1 ? 1 : 0);
				break;

			case ("front"):
				System.out.println(lastIdx == -1 ? -1 : deque[0]);
				break;

			case ("back"):
				System.out.println(lastIdx == -1 ? -1 : deque[lastIdx]);
				break;

			}
		}

		br.close();
		bw.close();
	}
}
