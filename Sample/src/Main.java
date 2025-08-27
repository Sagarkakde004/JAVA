////
////public class Main {
////    public static int binarySearchRotationalArray(int[] arr, int target) {
////        return helper(arr, target, 0, arr.length - 1);
////    }
////
////    public static int helper(int[] arr, int target, int first, int last) {
////        if (first > last) {
////            return -1;
////        }
////
////        int mid = first + (last - first) / 2;
////
////        if (arr[mid] == target) {
////            return mid;
////        }
////
////        if (arr[first] <= arr[mid]) {
////            if (target >= arr[first] && target < arr[mid]) {
////                return helper(arr, target, first, mid - 1);
////            }else {
////                return helper(arr, target, mid+1, last);
////            }
////        }
////
////        if (target > arr[mid] && target <= arr[last]) {
////            return helper(arr, target, mid + 1, last);
////        }else {
////            return helper(arr, target, first, mid-1);
////        }
////
////    }
////
////    public static void main(String[] args) {
////        int[] arr = {5,6,7,8,9,1, 2,4};
////        System.out.println(binarySearchRotationalArray(arr, 6));
////
////    }
////}
////
//
//import java.util.Random;
//
//
//
//
//
//
////public class Main {
////
////    public static int binarySearchRotationalArray(int[] arr, int target) {
////        return helper(arr, target, 0, arr.length - 1);
////    }
////
////
////    private static int helper(int[] arr, int target, int first, int last) {
////        if (first > last) {
////            return -1;
////        }
////
////        int mid = first + (last - first) / 2;
////
////        if (arr[mid] == target) {
////            return mid;
////        }
////
////        // Check if the left half is sorted
////        if (arr[first] <= arr[mid]) {
////            // Check if the target is within the sorted left half
////            if (target >= arr[first] && target < arr[mid]) {
////                return helper(arr, target, first, mid - 1);
////            } else {
////                // Search the unsorted right half
////                return helper(arr, target, mid + 1, last);
////            }
////        }
////        // The right half must be sorted
////
////        // Check if the target is within the sorted right half
////        if (target > arr[mid] && target <= arr[last]) {
////            return helper(arr, target, mid + 1, last);
////        } else {
////            // Search the unsorted left half
////            return helper(arr, target, first, mid - 1);
////        }
////
////    }
////
////    public static void main(String[] args) {
////        int[] arr = {3,4,5,6,7,8,9,1,2};
////        System.out.println(binarySearchRotationalArray(arr, 1)); // Expected output: 1
////    }
////}
//
//
//public class Main {
//    public static int binarySearchInRotationalArray(int[] arr){
//        Random random = new Random();
//        int target = random.nextInt(1,9);
//
//        System.out.println(target);
//        return helper(arr,target, 0,arr.length-1);
//    }
//
//    private static int helper(int[] arr, int target, int start, int end) {
//        if (start > end){
//            return -1;
//        }
//
//        int mid = start + (end-start) / 2;
//
//        if (arr[mid] == target){
//           return mid;
//        }
//
//        if (arr[start] <= arr[mid]){
//            if (target >= arr[start]  && target < arr[mid] ){
//                return helper(arr,target,start,mid-1);
//            }else {
//                return helper(arr,target,mid+1,end);
//            }
//        }
//
//        if (target > arr[mid] && target <= arr[end] ){
//            return helper(arr,target,mid+1,end);
//        }else {
//            return helper(arr,target,start,mid-1);
//        }
//
//    }
//
//    public static void main(String[] args){
//        int[] arr = {3,4,5,6,7,8,9,1,2};
//        System.out.println(binarySearchInRotationalArray(arr));;
//    }
//}