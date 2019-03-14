import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class ResultTest {

    /*
     * Complete the 'numberOfPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. LONG_INTEGER k
     */

    public static int numberOfPairs(List<Integer> a, long k) {
        // Write your code here
        int count = 0;
        HashMap<Long, Boolean> map = new HashMap<Long, Boolean>();

        for (int i : a) {
            if (i > k) {
                continue;
            }
            if (map.containsKey(k - i) && !map.get(k - i)) {
                count++;
                map.put((long) i, true);
                map.put((k-i), true);
            } else {
                map.put((long) i, false);
            }
        }
        return count;
    }

}

