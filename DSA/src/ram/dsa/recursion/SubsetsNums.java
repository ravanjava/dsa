package ram.dsa.recursion;

import java.util.*;

public class SubsetsNums {

        public static Map<String,List<Integer>> findSubsets(int[] nums) {
            Map<String,List<Integer>> subSetMap = new HashMap<>();
            recurr(nums,new int[0],subSetMap);
            return subSetMap;
        }

        public static void recurr(int[] ip, int[] op, Map<String,List<Integer>> subsets){

            if(ip.length==0){
                List<Integer> targetList =new ArrayList<>();
                for (int n:op) {
                    targetList.add(n);
                }
                String key = "";
                for (int n:op) {
                    key +=n;
                }
                subsets.put(key,targetList);
                return;
            }

            int[] no = Arrays.copyOf(op, op.length);
            int[] yes = addFirst(op,ip[0]);

            int[] reducedIp = removeFirst(ip);


            recurr(reducedIp,no,subsets);
            recurr(reducedIp,yes,subsets);

        }

        private static int[] addFirst(int[] arr,int element){
            int[] temp = new int[arr.length+1];
            temp[0] = element;
            for(int i=0;i<arr.length;i++){
                temp[i+1] = arr[i];
            }
            return temp;
        }

        private static int[] removeFirst(int[] arr){
            int[] temp = new int[arr.length-1];
            for(int i=1;i<arr.length;i++){
                temp[i-1] = arr[i];
            }
            return temp;
        }


    public static void main(String[] args) {
        Map<String,List<Integer>> result = SubsetsNums.findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result.values());

        result = SubsetsNums.findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result.values());
    }
}