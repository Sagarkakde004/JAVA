////package RecursionFromBasic;
////
////public class CountZeroFromNum {
////    public static int countZeroFromNum(int n,int count){
////        if (0 == n){
////            return count;
////        }
////
////        int lastNum = n % 10;
////         if (lastNum == 0){
////             return countZeroFromNum(n/10,count+1);
////         }else {
////            return countZeroFromNum(n/10,count);
////         }
////    }
////    public static void main(String[] args){
////        System.out.println(countZeroFromNum(1010400,0));;
////    }
////}
//
//
//// Encapsulate this on this process
//
//package RecursionFromBasic;
//
//class Count{
//    static int countZeroFromNum(int n){
//
//        return helper(n,0);
//
//    }
//
//    private static int helper(int n, int count) {   //Use Private method for incapsulate
//        if (0 == n) {
//            return count;
//        }
//
//        int lastNum = n % 10;
//        if (lastNum == 0) {
//            return helper(n / 10, count + 1);
//        } else {
//            return helper(n / 10, count);
//        }
//    }
//}
//public class CountZeroFromNum {
//    public static void main(String[] args){
//        System.out.println(Count.countZeroFromNum(1010400));
//    }
//}
//
//
//
