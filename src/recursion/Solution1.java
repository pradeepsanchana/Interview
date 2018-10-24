package recursion;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by pradeepsanchana on 25/08/18.
 */
public class Solution1 {




    public static void main(String[] args) {
        System.out.println(solution(0));
    }
    public static  int solution(int N) {
        // convert the int to char array
        char[] inChars = String.valueOf(N).toCharArray();

        // create a map of digit count.. e.g. '1' ---> 2, '3' --> 1
        Map<Character, Integer> digitCount = getDigitCount(inChars);
        int zeroCount = 0;
        if(digitCount.containsKey('0')){
            zeroCount = digitCount.get('0');
        }
        // calculate the denominator to avoid counting twice
        int denom = getDenom(digitCount);

        if(zeroCount == 0 || N == 0)
            return factorial(inChars.length) / denom;
        else
            return (factorial(inChars.length) / denom) - (factorial(inChars.length - 1)/denom * zeroCount);
    }

    private static int getDenom(Map<Character, Integer> digitCount) {
        int denom = 1;
        for (Map.Entry<Character, Integer> entry : digitCount.entrySet()) {
            denom = denom * factorial(entry.getValue());
        }

        return denom;
    }

    // create a map of digit count.. e.g. '1' ---> 2, '3' --> 1
    static Map<Character, Integer> getDigitCount(char[] inChars){
        Map<Character, Integer> digitCount = new HashMap<Character, Integer>();

        for (char c : inChars) {
            if (digitCount.containsKey(c)) {
                digitCount.put(c, digitCount.get(c) + 1);
            } else {
                digitCount.put(c, 1);
            }
        }
        return digitCount;
    }

    static int factorial(int n) {
        int factValue = 1;
        for (int i = 1; i <= n; i++) {
            factValue *= i;
        }
        return factValue;
    }
}

