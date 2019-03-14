import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Result {

    /*
     * Complete the 'romanizer' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER_ARRAY numbers as parameter.
     */


    static final HashMap<Integer, String> romanMap = new HashMap<Integer, String>() {{
        put(1, "I");
        put(2, "II");
        put(3, "III");
        put(4, "IV");
        put(5, "V");
        put(6, "VI");
        put(7, "VII");
        put(8, "VIII");
        put(9, "IX");
        put(10, "X");
        put(20, "XX");
        put(30, "XXX");
        put(40, "XL");
        put(50, "L");
        put(60, "LX");
        put(70, "LXX");
        put(80, "LXXX");
        put(90, "XC");
        put(100, "C");
        put(200, "CC");
        put(300, "CCC");
        put(400, "CD");
        put(500, "D");
        put(600, "DC");
        put(700, "DCC");
        put(800, "DCCC");
        put(900, "CM");
        put(1000, "M");
    }};

    public static List<String> romanizer(List<Integer> numbers) {
        // Write your code here
        List<String> romanStrList = new ArrayList<String>();

        int t = 0;
        int divisor = 1000;

        for (int n : numbers) {
            String temp = "";
            while (n > 0) {
                if (n >= divisor) {
                    t = n%divisor;
                    temp += romanMap.get(t);
                    n = n/divisor;
                }
                divisor = divisor/10;
            }
            romanStrList.add(temp);
        }
        return  romanStrList;
    }

}