//package AA_IntermidiateProblem;
//
//import java.util.HashSet;
//
//class Recursion{
//    public static void recursion(String str, int i, String newString, HashSet<String> set){
//        if (i == str.length()){
//            if (set.contains(newString)){
//                return;
//            }else {
//                System.out.println(newString);
//                set.add(newString);
//                return;
//            }
//        }
//
//        char currentChar = str.charAt(i);
//
//        recursion(str,i+1,newString+currentChar,set);
//
//        recursion(str,i+1,newString,set);
//    }
//}
//public class J_UniqueSubSequences {
//    public static void main(String[] args){
//        String str = "aaa";
//        HashSet<String> set = new HashSet<>();
//        Recursion.recursion(str,0," ",set);
//    }
//}
