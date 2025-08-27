//import java.util.Arrays;
//
//public class QueckShort {
//    public static void main(String[] args){
//        int[] arr = {3,2,5,9,6,1,8,7};
//        shorted(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
//    }
//    static void shorted(int[] arr,int low, int high){
//        if (low >= high){
//            return;
//        }
//
//        int start = low;
//        int end = high;
//        int mid = start + (end - start)/2;
//        int pivot = arr[mid];
//
//        while (start <= end){
//            while (arr[start] < pivot){
//                start++;
//            }
//
//            while (arr[end] > pivot){
//                end--;
//            }
//
//            if (start <= end){
//                int temp = arr[start];
//                arr[start] = arr[end];
//                arr[end] = temp;
//                start++;
//                end--;
//            }
//        }
//
//        // Now my pivot is on correct Index, please short two halph now
//        shorted(arr,low,end);
//        shorted(arr,start,high);
//    }
//
//}
