import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int oddEvenJumps(int[] A) {
        int n  = A.length, result = 1;
        boolean[] higher = new boolean[n];
        boolean[] lower = new boolean[n];

        higher[n - 1] = lower[n - 1] = true;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);

        for (int i = n - 2; i >= 0; --i) {
            Map.Entry high = map.ceilingEntry(A[i]);
            Map.Entry low = map.floorEntry(A[i]);

            if (high != null) {
                higher[i] = lower[(int)high.getValue()];
            }
            if (low != null) {
                lower[i] = higher[(int)low.getValue()];
            }
            if (higher[i]) {
                result++;
            }
            map.put(A[i], i);
        }
        return result;
    }


}

public class OddEvenNumberedJumps {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] A = stringToIntegerArray(line);

            int ret = new Solution().oddEvenJumps(A);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}