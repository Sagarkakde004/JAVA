////                                        stack Height  O(n)
//
////class Recursion{
////    int recursion(int x, int n){
////        if (n == 0){
////            return 1;
////        }
////
////        if (x == 0){
////            return 0;
////        }
////
////        int previusResult = recursion(x,n-1);
////        int result = x * previusResult;
////        return result;
////    }
////}
////
////public class X_Power_n_WithStackHeightN {
////    public static void main(String[] args){
////        Recursion loop = new Recursion();
////        System.out.println(loop.recursion(5,4));
////    }
////}
//
//
//
//
//
////                        Stack Height O(logn)
//
//
//
//
//
//
//class Recursion{
//    int recursion(int x, int n){
//        if (n == 0){
//            return 1;
//        }
//
//        if (x == 0){
//            return 0;
//        }
//
//        if (n%2 == 0){
//            return recursion(x,n/2) * recursion(x,n/2);
//        }else {
//            return recursion(x,n/2) * recursion(x,n/2) * x;
//
//        }
//    }
//}
//
//public class I_X_Power_n_WithStackHeightN {
//    public static void main(String[] args){
//        Recursion loop = new Recursion();
//        int result = loop.recursion(5,3);
//        System.out.println(result);
//    }
//}
