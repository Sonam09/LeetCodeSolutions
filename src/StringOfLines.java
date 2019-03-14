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



class ResultT {

    /*
     * Complete the 'numberOfPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. LONG_INTEGER k
     */

    static final Pattern htmlRegex = Pattern.compile("https?://(www.|ww2.|web.)?([a-z0-9-]+(\\.[a-z0-9-]+)+)");


    public static String getPotentialDomains(List<String> lines) {
        // Write your code here

        // Write your code here
        TreeSet domainSet = new TreeSet();
        for (String l : lines) {
            Matcher matcher = htmlRegex.matcher(l);

            if (matcher.find()) {
                String domainName = matcher.group(2);
                domainSet.add(domainName);
            }
        }

        List domainList = (List) domainSet.stream().collect(Collectors.toList());
        return String.join(";", domainList);
    }

}

