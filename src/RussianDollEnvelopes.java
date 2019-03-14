import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class RussianDollEnvelopsSolution {
    /*public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (pair1, pair2) -> pair1[0]-pair2[0]);
        int i = 0, count = 1;
        int[] currentEnvelope = envelopes[0];
        int n = envelopes.length;

        while (i < n) {
            while(envelopes[i][0] <= currentEnvelope[0]) {
                i++;
            }
            if (envelopes[i][0] > currentEnvelope[0] && envelopes[i][1] > currentEnvelope[1]) {
                count++;
                currentEnvelope = envelopes[i];
            }
            i++;
        }

        System.out.println(Arrays.deepToString(envelopes));
        return count;
    }*/
    public int maxEnvelopes_mySolution(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (pair1, pair2) -> pair1[0]-pair2[0]);
        return maxEnvelopesHelper(envelopes, 0);
    }

    private int maxEnvelopesHelper(int[][] envelopes, int position) {
        int result = 1;

        for (int i = position; i < envelopes.length; i++) {
            int j = i+1;
            while (j < envelopes.length) {
                if (envelopes[i][0] < envelopes[j][0] && envelopes[i][1] < envelopes[j][1]) {
                    result = Math.max(result, 1+maxEnvelopesHelper(envelopes, j));
                }
                j++;
            }
        }
        return result;
    }

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });
        int count = 1, n = envelopes.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(dp, 0, count, envelopes[i][1]);
            if (index < 0) {
                index = -(index+1);
            }
            dp[index] = envelopes[i][1];
            if (index == count) {
                count++;
            }
        }

        return count;
    }
}

public class RussianDollEnvelopes
{
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

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = (JsonArray) Json.parse(input);
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] pairs = stringToInt2dArray(line);

            int ret = new RussianDollEnvelopsSolution().maxEnvelopes(pairs);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
