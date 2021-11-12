package ram.dsa.fb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MinLenSubString {
// Add any helper functions you may need here


    int minLengthSubstring(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c:t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int end=0;end<s.length();end++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                int count= map.get(c);
                if(count<=1){
                    map.remove(c);
                } else {
                    map.put(c,count-1);
                }
            }
            if(map.isEmpty()){
                return end+1;
            }
        }
        return -1;
    }


    String sortStr(String s){

        String sorted =
                Stream.of(s.split(""))
                        .sorted()
                        .collect(Collectors.joining());
        return sorted;

    }










    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.
    int test_case_number = 1;
    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }
    public void run() throws IOException {
        String s_1 = "dcbefebce";
        String t_1 = "fd";
        int expected_1 = 5;
        int output_1 = minLengthSubstring(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
        String t_2 = "cbccfafebccdccebdd";
        int expected_2 = -1;
        int output_2 = minLengthSubstring(s_2, t_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) throws IOException {
        new MinLenSubString().run();
    }
}
