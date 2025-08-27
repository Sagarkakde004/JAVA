//package Practice;
//
//import java.util.*;
//
//public class Alphabetic_alphanumeric {
//
//    static void recursion(int[] arr1,int[] arr,int i,ArrayList<Integer> list){
//        if (i >= arr1.length){
//            System.out.println(list);
//            return;
//        }
//
//        int key = arr1[i];
//        int count = 0;
//        for (int newArr : arr){
//            if (key == newArr){
//                if (key == 0){
//                    count = 0;
//                }else {
//                    count ++;
//                }
//            }
//        }
//        list.add(count);
//        recursion(arr1,arr,i+1,list);
//    }
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        Set<Integer> newSet = new HashSet<>();
//        int[] arr = {1,0,2,3,3,2,5};
//
//        for (int num:arr){
//            newSet.add(num);
//        }
//
//        ArrayList<Integer> newList = new ArrayList<>(newSet);
//        int size = newList.size();
//
//        int[] arr1 = new int[size];
//        for (int i = 0;i < size;i++){
//            arr1[i] = newList.get(i);
//        }
//
//        recursion(arr1,arr,0,list);
//    }
//}
