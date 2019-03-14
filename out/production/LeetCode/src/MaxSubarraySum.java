import java.io.*;
import java.util.*;

public class MaxSubarraySum {

    // Complete the maxSubsetSum function below.
        static int maxSubsetSum(int[] arr) {
            List<int []> list = new ArrayList<int[]>(){{
                add(new int[]{0});
            }};
            int s = 0, e = 0;
            int[] subArray;
            for (int a : arr) {
                for (int i = s; i < e; i++) {
                    subArray = list.get(i);
                }
            }

            return 0;
        }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
