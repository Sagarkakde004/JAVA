//package AA_IntermidiateProblem;
//
//class Recursion{
//    public static int first = -1;
//    public static int last = -1;
//    void recursion(String str,int i){
//        if(i>str.length()-1){
//            System.out.println(first+" "+last);
//            return;
//        }
//       if(str.charAt(i) == 'a') {
//
//           if (first == -1) {
//               first = i;
//           } else {
//               last = i;
//           }
//       }
//       recursion(str,i+1);
//    }
//}
//public class FirstNLastAccuranceChar {
//    public static void main(String[] args) {
//        Recursion loops = new Recursion();
//        loops.recursion("abaacdaefaah",1);
//    }
//}
