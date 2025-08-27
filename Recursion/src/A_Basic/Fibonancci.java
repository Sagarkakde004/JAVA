////import java.util.ArrayList;
////
////class Recursion {
////    int recursion(int a, int b, int count,int counter){
////        if ( count > counter) {
////            return 0;
////        }
////
////        int c = a + b;
////        System.out.println(c);
////        recursion(b,c,count+1,counter);
////
////         return 0;
////    }
////}
////public class Fibonancci {
////    public static void main(String[] args){
////        Recursion loop = new Recursion();
////        System.out.println(loop.recursion(0,1,1,10));
////    }
////}
//
//
//import java.util.ArrayList;
//
//class Recursion {
//    ArrayList<Integer> recursion(int a, int b, int count, int counter, ArrayList<Integer> list) {
//        if (count > counter) {
//            return list;
//        }
//
//        int c = a + b;
//        list.add(c); // ✅ Add the next Fibonacci number to the list
//        return recursion(b, c, count + 1, counter, list);
//    }
//}
//
//public class Fibonancci {
//    public static void main(String[] args) {
//        Recursion loop = new Recursion();
//
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(0); // First Fibonacci number
//        list.add(1); // Second Fibonacci number
//
//        ArrayList<Integer> result = loop.recursion(0, 1, 1, 10, list);
//
//        System.out.println(result); // Output: [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
//    }
//}
