package ram.dsa.pramp;

public class BracketMatch {
    static int bracketMatch(String text) {

        if(null==text || "".equals(text)){
            return 0;
        }

        char[] charArray = text.toCharArray();

        int diff =0;
        int ans =0;

        for(char c:charArray){
            if(c=='('){
                diff +=1;
            }else if(c==')'){
                diff -=1;
            }
            if(diff<0){
                diff++;
                ans++;
            }
        }

        return ans+diff;

    }

    public static void main(String[] args) {
        System.out.println(bracketMatch("))))))"));

    }

}
