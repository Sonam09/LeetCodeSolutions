import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class ShoppingOffersSolutions {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shoppingHelper(price, special, needs, 0);
    }

    private int shoppingHelper(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int position) {
        int res = priceWithoutOffer(price, needs);

        for (int i = position; i < special.size(); i++) {
            List<Integer> offer = special.get(i);
            List<Integer> updatedNeeds = new ArrayList();
            for (int j = 0; j < needs.size(); j++) {
                if (needs.get(j) < offer.get(j)) {
                    updatedNeeds = null;
                    break;
                } else {
                    updatedNeeds.add(needs.get(j) - offer.get(j));
                }
            }
            if (updatedNeeds != null) {
                System.out.println(updatedNeeds);
                res = Math.min(res, offer.get(offer.size()-1) + shoppingHelper(price, special, updatedNeeds, i));
            }
        }
        return res;
    }

    private int priceWithoutOffer(List<Integer> price, List<Integer> needs) {
        int totalPrice = 0;
        for (int i = 0; i < needs.size(); i++) {
            totalPrice += needs.get(i)*price.get(i);
        }
        return totalPrice;
    }
}

public class ShoppingWithMinimalExpenditure {
    public static ArrayList<Integer> stringToIntegerArrayList(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");
        ArrayList<Integer> output = new ArrayList<Integer>();
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output.add(Integer.parseInt(part));
        }
        return output;
    }

    private static List<Integer> stringToIntegerList(String input) {
        JsonArray jsonArray = (JsonArray) Json.parse(input);
        List<Integer> arr = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            arr.add(jsonArray.get(i).asInt());
        }
        return arr;
    }

    public static List<List<Integer>> stringToInt2dList(String input) {
        JsonArray jsonArray = (JsonArray) Json.parse(input);
        if (jsonArray.size() == 0) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> list = new ArrayList<>(jsonArray.size());
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonArray cols = jsonArray.get(i).asArray();
            list.add(stringToIntegerList(cols.toString()));
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            List<Integer> price = stringToIntegerArrayList(line);
            line = in.readLine();
            List<List<Integer>> special = stringToInt2dList(line);
            line = in.readLine();
            List<Integer> needs = stringToIntegerArrayList(line);

            int ret = new ShoppingOffersSolutions().shoppingOffers(price, special, needs);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}