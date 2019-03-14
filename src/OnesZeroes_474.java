import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class OnesZeroes_474Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        int oneCount, zeroCount;

        for (String str : strs) {
            oneCount = 0; zeroCount = 0;
            int i = 0;
            while (i < str.length()) {
                oneCount += str.charAt(i++) - 48;
            }
            zeroCount = i - oneCount;

            for (i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroCount][j-oneCount]+1);
                }
            }
        }
        return dp[m][n];
    }
}

public class OnesZeroes_474 {
    public static String[] stringToStringArray(String line) {
        JsonArray jsonArray = (JsonArray) Json.parse(line);
        String[] arr = new String[jsonArray.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = jsonArray.get(i).asString();
        }
        return arr;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String[] strs = stringToStringArray(line);
            line = in.readLine();
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = new OnesZeroes_474Solution().findMaxForm(strs, m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
