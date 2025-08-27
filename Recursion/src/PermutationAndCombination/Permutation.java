//package PermutationAndCombination;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Permutation {
//
//    public static ArrayList<String> permutation(String p, String up){
//        if (up.isEmpty()){
//            ArrayList<String> list = new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//
//        ArrayList<String> result = new ArrayList<>();
//        char newChar = up.charAt(0);
//        for (int i = 0; i <= p.length(); i++){
//            String f = p.substring(0,i);
//            String l = p.substring(i,p.length());
//
//            result.addAll(permutation(f + newChar + l, up.substring(1)));
//        }
//        return result;
//    }
//    public static void main(String[] args){
////        System.out.println(permutation("","abc"));
//        ArrayList<String> ans = permutation("", "abc");
//        System.out.println(ans);
//    }
//}
