////package RecursionFromBasic;
////
////public class ReverseNum {
////    public static int sum = 0;
////    public static void reverse(int n){
////        if((n%10) == n){
////            sum = sum * 10 + n;
////            return;
////        }
////
////        int remender = n % 10;
////        sum = sum * 10 + remender;
////
////        reverse(n/10);
////    }
////    public static void main(String[] args){
////        reverse(1234);
////        System.out.println(sum);
////    }
////}
//
//
//
//
//package RecursionFromBasic;
//
//public class ReverseNum {
//    public static int reverse(int n){
//
//        int digit = (int) Math.log10(n)+1;
//        int reverseNum = helper(n,digit);
//        pelidrome(reverseNum,n);
//        return reverseNum;
//    }
//    static int helper(int n, int digit){
//
//        if (n%10 == n){
//            return n;
//        }
//
//
//
//        int reverseNum = n % 10;
//       return reverseNum * (int) (Math.pow(10,digit-1)) + helper(n/10,digit-1);
//
//    }
//    static void pelidrome(int n,int x){
//        if (n == x){
//            System.out.println("Palidrome");
//        }
//    }
//    public static void main(String[] args){
//
//        System.out.println(reverse(12381)); //For cheack palidrome 12321
//    }
//}
//
