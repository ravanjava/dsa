package ram.dsa.slidingwindow;

public class CheckAnagrams {

    public static void main(String[] args) {
        solve("forasdsaorfasasrof","for");
    }

    static void solve(String source, String pattern){
        int s=0;
        for(int e=0;e<source.length();e++){
            if(e-s+1==pattern.length()){
                if(isAnagram(source.substring(s,e+1),pattern)){
                    System.out.println(source.substring(s,e+1));
                }
                s++;
            }
        }
    }

    static boolean isAnagram(String source, String target){
        if(source.length()!=target.length())
            return false;
        int[] count = new int[256];

        for(int i=0;i<source.length();i++){
            count[source.toCharArray()[i]]++;
        }

        for(int i=0;i<target.length();i++){
            count[target.toCharArray()[i]]--;
        }

        for (int i=0;i<256;i++){
            if(count[i]!=0)
                return false;
        }
        return true;
    }
}
