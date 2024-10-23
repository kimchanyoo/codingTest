package D29;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int arr[];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (binarySearch(num)) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.close();
        br.close();
    }

    private static boolean binarySearch(int num) {
        int leftIndex = 0;
        int rightIndex = n - 1;

        while (leftIndex <= rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            int mid = arr[midIndex];

            if (num < mid) {
                rightIndex = midIndex - 1;
            } else if (num > mid) {
                leftIndex = midIndex + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
