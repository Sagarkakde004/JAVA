//package RecursionFromBasic;
//
//public class BinarySearch {
//    public static int binarySearch(int[] arr, int target, int start,int last){
//        if (start > last){
//            return -1;
//        }
//
//        int m = start + (last - start) / 2 ;
//        if (arr[m] == target) return m;
//       if (arr[m] > target) return binarySearch(arr,target,start,m-1);
//       else return binarySearch(arr,target,m+1,last);
//    }
//    public static void main(String[] args){
//        int[] arr = {1,2,3,4,5,6,7,8};
//        System.out.println(binarySearch(arr,3,0,arr.length-1));
//    }
//}
