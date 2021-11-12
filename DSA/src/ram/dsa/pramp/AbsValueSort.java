package ram.dsa.pramp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AbsValueSort {

    public static void main(String[] args) {

        //2, -7, -2, -2, 0
        LinkedList<Integer> l = new LinkedList<>();
        l.add(-2);
        l.add(-7);
        l.add(2);
        l.add(-2);
        l.add(0);
        sort(l);
        System.out.println(l.toString());
    }


        public static void sort(LinkedList<Integer> arr){
            if(arr.size()==1)
                return;
            int temp = arr.getLast();
            arr.removeLast();
            sort(arr);
            insert(arr,temp);
        }

    public static void insert(LinkedList<Integer> list, int ele){

        if(list.size()!=0){
            int curr = Math.abs(list.getLast());

            if(curr==Math.abs(ele)){
                if(list.getLast()<ele){
                    list.add(ele);
                    return;
                }
            }else{
                if(curr<Math.abs(ele)){
                    list.add(ele);
                    return;
                }
            }
        }else{
            list.add(ele);
            return;
        }

        int temp = list.getLast();
        list.removeLast();
        insert(list,ele);
        list.add(temp);
    }
}
