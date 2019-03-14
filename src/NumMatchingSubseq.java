import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class NumMatchingSubseqSolution{
    public int numMatchingSubseq(String S, String[] words) {
        List<String> wordList = Arrays.asList(words);
        int[] nextMatchIndex = new int[wordList.size()];

        for (char c : S.toCharArray()) {
            for (int i = 0; i < wordList.size(); i++) {
                int indx = nextMatchIndex[i];
                if (indx != -1) {
                    if (c == wordList.get(i).charAt(indx)) {
                        indx++;
                        nextMatchIndex[i] = (indx == wordList.get(i).length() ? -1 : indx);
                    }
                }
            }
        }
        return Arrays.stream(nextMatchIndex).filter(i->i==-1).sum() * -1;
    }

}

public class NumMatchingSubseq {

    public static String[] stringToStringArray(String line) {
        List<String> arr = new ArrayList(2);
        Pattern pattern = Pattern.compile("\"(\\w+)\"");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            arr.add(matcher.group(1));
        }
        return arr.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = line;
            line = in.readLine();
            String[] words = stringToStringArray(line);

            int ret = new NumMatchingSubseqSolution().numMatchingSubseq(S, words);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}