package ram.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println("1: "+findSubstring("aabdec","abc"));
        System.out.println("2: "+findSubstring("abdbca","abc"));
        System.out.println("3: "+findSubstring("adcad","abc"));
    }

    public static String findSubstring(String str, String pattern) {
        Map<Character,Integer> map = new HashMap<>();
        loadPattern(pattern,map); // Load Pattern
        while(!patterMatch(str,map)){
            str = str.substring(1,str.length());
        }

        return str;
    }

    static boolean patterMatch(String s,Map<Character,Integer> givenMap){
        Map<Character,Integer> tmap = new HashMap<>();
        loadPattern(s,tmap);
        for(char c:givenMap.keySet()){
            if(null== tmap.get(c)){
                return false;
            }
            int diff = givenMap.get(c)-tmap.get(c);
            if(diff!=0){
                return false;
            }
        }
     return true;
    }

    static void loadPattern(String str,Map<Character,Integer> map){
        char[] arr = str.toCharArray();
        for(char c:arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
    }
}
