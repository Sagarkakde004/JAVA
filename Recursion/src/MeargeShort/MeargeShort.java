//import java.util.Arrays;
//
////////import java.util.Arrays;
////////
////////public class MeargeShort {
////////
////////    public static int[] shorting(int[] arr){
////////        if (arr.length == 1){
////////            return arr;
////////        }
////////        int mid = arr.length / 2;
////////
////////        int[] first = shorting(Arrays.copyOfRange(arr,0,mid));
////////        int[] second = shorting(Arrays.copyOfRange(arr,mid,arr.length));
////////
////////        return shortAccending(first,second);
////////
////////    }
////////
////////    private static int[] shortAccending(int[] first, int[] second) {
////////        int[] mix = new int[first.length + second.length];
////////
////////        int i = 0;
////////        int j = 0;
////////        int k = 0;
////////
////////        while (i<first.length && j <second.length){
////////            if (first[i] < second[j]){
////////                mix[k] =first[i];
////////                i++;
////////            }else {
////////                mix[k] =second[j];
////////                j++;
////////            }
////////            k++;
////////        }
////////
////////        while (i<first.length){
////////            mix[k] = first[i];
////////            i++;
////////            k++;
////////        }
////////
////////        while (j<second.length){
////////            mix[k] = second[j];
////////            j++;
////////            k++;
////////        }
////////        return mix;
////////    }
////////
////////    public static void main(String[] args){
////////        int[] arr= {5,4,7,2,7,8,9};
////////        arr = shorting(arr);
////////        System.out.println(Arrays.toString(arr));
////////    }
////////}
//////
////
////import java.util.Arrays;
////
////public class MeargeShort {
////
////    public static int[] shorting(int[] arr){
////        if (arr.length == 1){
////            return arr;
////        }
////
////        int mid = arr.length/2;
////
////        int[] first = shorting(Arrays.copyOfRange(arr,0,mid));
////        int[] second = shorting(Arrays.copyOfRange(arr,mid,arr.length));
////        return shortingAccending(first,second);
////    }
////
////    private static int[] shortingAccending(int[] first, int[] second) {
////        int[] max = new int[first.length+second.length];
////
////        int i = 0;
////        int j = 0;
////        int k = 0;
////
////        while (i<first.length && j < second.length){
////            if (first[i] < second[j]){
////                max[k] = first[i];
////                i++;
////            }else {
////                max[k] = second[j];
////                j++;
////            }
////            k++;
////        }
////
////        while (i<first.length){
////            max[k] = first[i];
////            i++;
////            k++;
////        }
////
////        while (j<second.length){
////            max[k] = second[j];
////            j++;
////            k++;
////        }
////
////        return max;
////    }
////
////    public static void main(String[] args){
////        int[] arr = {5,2,4,3,1,7,8};
////        arr = shorting(arr);
////        System.out.println(Arrays.toString(arr));
////    }
////}
////
//
//
//
////public class MeargeShort {
////    public static int[] forSorting(int[] arr){
////        if (arr.length == 1){
////            return arr;
////        }
////
////        int mid = arr.length /2;
////
////        int[] first = forSorting(Arrays.copyOfRange(arr,0,mid));
////        int[] second = forSorting(Arrays.copyOfRange(arr,mid,arr.length));
////
////        return shorting(first,second);
////    }
////
////    private static int[] shorting(int[] first, int[] second) {
////        int[] mix = new int[first.length + second.length];
////
////        int i  =0;
////        int j = 0;
////        int k = 0;
////
////        while (i < first.length && j < second.length){
////            if (first[i] < second[j]){
////                mix[k] = first[i];
////                i++;
////            }else {
////                mix[k] = second[j];
////                j++;
////            }
////            k++;
////        }
////
////        while (i < first.length){
////            mix[k] = first[i];
////            i++;
////            k++;
////        }
////
////        while (j < second.length){
////            mix[k] = second[j];
////            j++;
////            k++;
////        }
////        return mix;
////    }
////
////    public static void main(String[] args){
////        int[] arr = {5,4,7,1,8,9,2};
////        arr = forSorting(arr);
////        System.out.println(Arrays.toString(arr));
////    }
////}
//
//
//
//public class MeargeShort {
//    public static void forSorting(int[] arr,int s,int e){
//        if (e-s == 1){
//            return;
//        }
//
//        int mid = (s+e) /2;
//
//       forSorting(arr,s,mid);
//       forSorting(arr,mid,e);
//
//        shorting(arr,s,mid,e);
//    }
//
//    private static void shorting(int[] arr,int s,int mid,int e) {
//        int[] mix = new int[e-s];
//
//        int i  =s;
//        int j = mid;
//        int k = 0;
//
//        while (i < mid && j < e){
//            if (arr[i] < arr[j]){
//                mix[k] = arr[i];
//                i++;
//            }else {
//                mix[k] = arr[j];`
//                j++;
//            }
//            k++;
//        }
//
//        while (i < mid){
//            mix[k] = arr[i];
//            i++;
//            k++;
//        }
//
//        while (j < e){
//            mix[k] = arr[j];
//            j++;
//            k++;
//        }
//
//        for (int l = 0; l < mix.length;l++){
//            arr[s+l] = mix[l];
//        }
//    }
//
//    public static void main(String[] args){
//        int[] arr = {5,4,7,1,8,9,2};
//       forSorting(arr,0,arr.length);
//        System.out.println(Arrays.toString(arr));
//    }
//}