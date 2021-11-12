package ram.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public static void main(String[] args) {
        String ip = "a1c2B";
        /*for(String s:genAllSubSets(ip)){
            if(s.isEmpty()){
                System.out.println("EMPTY");
            }else{
                System.out.println(s);
            }
        }*/

        for(String s:genAllSubCases(ip)){
              System.out.println(s);
        }
    }

    public static List<String> genAllSubSetSpace(String ip){
        List<String> list = new ArrayList<>();
        String char1 = ip.charAt(0)+"";
        String subs = ip.substring(1);
        genSubsSpace(subs,char1,list);
        return list;
    }

    public static List<String> genAllSubCases(String ip){
        List<String> list = new ArrayList<>();
        genSubsCase(ip,"",list);
        return list;
    }

    public static List<String> genAllSubSets(String ip){
        List<String> list = new ArrayList<>();
        genSubs(ip,"",list);
        return list;
    }

    private static void genSubs(String ip, String op, List<String> list){

        if(ip.length()==0){ // base condition
            list.add(op);
            System.out.println(op);
            return;
        }

        String no = op; // same as prev result
        String yes = op+ip.charAt(0); // prev result + current char
        ip = ip.substring(1);//ip.deleteCharAt(0); // reduce the input
        genSubs(ip,no,list);
        genSubs(ip,yes,list);
    }

    private static void genSubsSpace(String ip, String op, List<String> list){

        if(ip.length()==0){ // base condition
            list.add(op);
            return;
        }

        String yes = op+"_"+ip.charAt(0);
        String no = op+ip.charAt(0);
        ip = ip.substring(1);//ip.deleteCharAt(0); // reduce the input

        genSubsSpace(ip,no,list);
        genSubsSpace(ip,yes,list);
    }

    private static void genSubsCase(String ip, String op, List<String> list){

        if(ip.length()==0){ // base condition
            list.add(op);
            return;
        }
        char c = ip.charAt(0);
        String cc = c+"";
        String no = op+cc;
        String yes = op+cc.toUpperCase();
        ip = ip.substring(1);//ip.deleteCharAt(0); // reduce the input

        if(Character.isDigit(c)){
            genSubsCase(ip,no,list);
        }else{
            genSubsCase(ip,no,list);
            genSubsCase(ip,yes,list);
        }
    }
}
