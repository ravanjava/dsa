package ram.dsa.heaps;

import java.util.PriorityQueue;

public class ConnectSticks {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3};
        System.out.println(connectSticks(arr));
    }

    static int connectSticks(int[] sticks) {
        int cost=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s:sticks){
            pq.add(s);
        }
        while(pq.size() > 1){
            int stick1 = pq.remove();
            int stick2 = pq.remove();
            int newStick = stick1+stick2;
            cost +=newStick;
            pq.add(newStick);
        }

        return cost;
    }
}
