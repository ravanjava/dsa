package ram.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {

    public static int findLength(String str, int k) {
        int ans = 0;
        int start = 0;
        int rank = 0;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            frequencyMap.put(right, frequencyMap.getOrDefault(right, 0) + 1);
            rank = Math.max(rank, frequencyMap.get(right));
            int windowSize = end - start + 1;
            // check the Win size and shrink it if needed
            if (windowSize - rank > k) {
                char left = str.charAt(start);
                frequencyMap.put(left, frequencyMap.get(left) - 1); //update freqMap
                start++; // shrink window
                windowSize = end - start + 1;// update Window Size
            }
            ans = Math.max(ans, windowSize);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(CharacterReplacement.findLength("aabccbb", 2));
        System.out.println(CharacterReplacement.findLength("abbcb", 1));
        System.out.println(CharacterReplacement.findLength("abccde", 1));
    }
}
