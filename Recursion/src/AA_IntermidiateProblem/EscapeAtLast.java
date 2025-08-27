//package AA_IntermidiateProblem;
//
//
//class Recursion {
//public static int count = 0;
//    public static String recursion(String str, int i, String newString){
//        if (i > str.length()-1){
//            System.out.println(newString);
//
//            return newString;
//        }
//       if (str.charAt(i) == 'g') {
//           count ++;
//       }else {
//           newString += str.charAt(i);
//       }
//
//       return recursion(str,i+1,newString);
//    }
//}
//public class EscapeAtLast { // sory enghish kamjor h escape in move honga
//    public static void main(String[] args){
//        String str = "gfg";
//        String newString = "";
//        String newStringForLoop = Recursion.recursion(str,0,newString);
//
//        for (int j=0; j < Recursion.count;j++){
//            newStringForLoop += "g";
//        }
//        System.out.println(newStringForLoop);
//    }
//}
