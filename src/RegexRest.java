import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexRest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("https?://(www.|ww2.)?(\\w+(\\.[a-zA-Z0-9-]+)+)/\\S+");
        String text = "https://github.com.eu/charles-wangkai/hackerrank/blob/master/detect-the-domain-name/Solution.java https://www.regex101.com/r/SpZnNo/1";
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.toString());
            System.out.println("Matches : " + true);
            System.out.println("Domain : " + matcher.group(2));

            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }
}
