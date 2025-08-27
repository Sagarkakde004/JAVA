//package AA_IntermidiateProblem;
//
//class Recursion{
//    void recursion(String str,int i, String newString){
//        if (i==0){
//            newString+=str.charAt(i);
//            System.out.println(newString);
//            return;
//        }
//
//        newString += str.charAt(i);
//        recursion(str,i-1,newString);
//    }
//}
//public class B_ReverseString {
//    public static void main(String[] args){
//        String str = "abcd";
//        String newString = "";
//        int i = str.length()-1;
//        Recursion loop = new Recursion();
//        loop.recursion(str,i,newString);
//    }
//}