//package AA_IntermidiateProblem;
//
//import java.util.HashSet;
//
//class Recursion {
//    private static String[] arr = {".", "abc", "def", "ijk", "lmn", "opqr", "stu", "vwxy"};
//
//    public static void recursion(String str, int i, String combination) {
//        if (i == str.length()){
//            System.out.println(combination);
////            if (set.contains(newString)){
////                return;
////            }else {
////                System.out.println(newString);
////                set.add(newString);
////                return;
////            }
//
//            return;
//        }
//
//        int currentIdx = str.charAt(i) - '0';
//        String indexStr = arr[currentIdx];
//        for (int j = 0; j < indexStr.length(); j++) {
//
//            recursion(str, i + 1, combination+indexStr.charAt(j));
//
//        }
//
//
//
////
////        recursion(str,i+1,newString,set,"");
//
//    }
//}
//
//public class KeypadCombination {
//    public static void main(String[] args) {
//        String str = "23";
////        HashSet<String> set = new HashSet<>();
//        Recursion.recursion(str, 0, " ");
//    }
//}