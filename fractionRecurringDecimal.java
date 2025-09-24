import java.util.HashMap;

public class fractionRecurringDecimal {
    
    // Leetcode 166
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        if(numerator < 0 && denominator > 0) result.append("-");
        if(numerator > 0 && denominator < 0) result.append("-");

        long n = Math.abs((long) numerator);
        long d = Math.abs((long) denominator);

        // Integer part
        result.append(n / d);
        long remainder = n % d;

        if (remainder == 0) {
            return result.toString(); // If no decimal part
        }

        result.append(".");
        HashMap<Long, Integer> remainderMap = new HashMap<>();

        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                result.insert(remainderMap.get(remainder), "(");
                result.append(")");
                break;
            }
            remainderMap.put(remainder, result.length());

            remainder *= 10;
            result.append(remainder/d);
            remainder %= d;
        }
        return result.toString();    
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4,333));
    }
}
