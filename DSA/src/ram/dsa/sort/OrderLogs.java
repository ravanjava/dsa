package ram.dsa.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderLogs {

    public static void main(String[] args) {

        String[] ip = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
        System.out.println(Arrays.toString(reorderLogFiles(ip)));
    }

    static String[] reorderLogFiles(String[] logs) {

        List<LeetLog> logList = new ArrayList<>();
        for(String log:logs){
            logList.add(new LeetLog(log));
        }

        Collections.sort(logList);

        String[] result = new String[logs.length];
        for(int i=0;i<logList.size();i++){
            result[i] = logList.get(i).log;
        }

        return result;
    }
}

class LeetLog implements Comparable<LeetLog> {
    String id;
    String content;
    String log;

    public LeetLog(String log) {
        this.log = log;
        String[] split = log.split(" ",2);
        this.id = split[0];
        this.content = split[1];
    }

    public boolean isDigit() {
        return Character.isDigit(this.content.charAt(0));
    }

    @Override
    public int compareTo(LeetLog o) {

        // if both logs are digits
        if (this.isDigit() && o.isDigit()) {
            return 0;
        // if one of logs are digits
        } else if (this.isDigit() && !o.isDigit()) {
            return 1;
        } else if (!this.isDigit() && o.isDigit()) {
            return -1;
        }

        // if both logs are text and contents are equal sort on ID
        if (this.content.equals(o.content)) {
            return this.id.compareTo(o.id);
        }
        // if both logs are text and contents are NOT equal, sort on content
        return this.content.compareTo(o.content);
    }
}