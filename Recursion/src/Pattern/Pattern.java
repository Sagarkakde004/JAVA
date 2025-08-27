//public class Pattern {
//    public static void pattern(int r,int c){
//        if (r==0){
//            return;
//        }
//
//        if (r > c){
//            System.out.print("*");
//            pattern(r,c+1);
//        }else{
//            System.out.println();
//            pattern(r-1,0);
//        }
//    }
//
//    public static void main(String[] args){
//        pattern(4,0);
//    }
//}




////import java.util.Arrays;
////
////public class Pattern {
////    public static void pattern(int[] arr, int rows,int c,int max){
////        if (rows==0){
////            return;
////        }
////
////        if (rows > c){
//////            if (arr[c] > arr[c+1]){
//////                int temp = arr[c+1];
//////                arr[c+1] = arr[c];
//////                arr[c] = temp;
//////            }
////            if (arr[c] > arr[max]) {
////                pattern(arr,rows,c+1,c);
////            }else {pattern(arr,rows,c+1,max);}
////        }else{
////            int temp = arr[rows-1];
////                arr[rows-1] = arr[max];
////                arr[max] = temp;
////            pattern(arr,rows-1,0,0);
////        }
////    }
//
//    public static void main(String[] args){
//        int[] arr = {5,2,1,9,6,3};
//        int rows = arr.length;
//        pattern(arr,rows,0,0);
//        System.out.println(Arrays.toString(arr));
//    }
//}





//import java.util.Arrays;
//
//public class Pattern {
//    public static void pattern(int[] arr, int rows,int c){
//        if (rows==0){
//            return;
//        }
//
//        if (rows >= c){
//
//            if (arr[c] > arr[rows]){
//                int temp = arr[rows];
//                arr[rows] = arr[c];
//                arr[c] = temp;
//            }
//
//            pattern(arr,rows,c+1);
//        }else{
//
//            pattern(arr,rows-1,0);
//        }
//    }
//
//    public static void main(String[] args){
//        int[] arr = {6,3,5,2,1,4};
//        int rows = arr.length-1;
//        pattern(arr,rows,0);
//        System.out.println(Arrays.toString(arr));
//    }
//}