//package Backtracking;
//
//import java.util.ArrayList;
//
//public class MazePathCount {
////    public static int mazePathCount(int r,int c){
////        if (r==1 || c == 1){
////            return 1;
////        }
////
////        int left = mazePathCount(r-1,c);
////        int right = mazePathCount(r,c-1);
////        return left+right;
////    }
////
////    public static int pathPrint(String path, int r,int c){
////        if (r==1 || c == 1){
////            System.out.println(path);
////            return 1;
////        }
////
////        int left = pathPrint(path+"D",r-1,c);
////        int right = pathPrint(path+"L",r,c-1);
////        return left+right;
////    }
////
////    public static ArrayList<String> pathPrintWithLinkedList(String path, int r, int c){
////        if (r==1 || c == 1){
////            ArrayList<String> list = new ArrayList<>();
////            list.add(path);
////            return list;
////        }
////
////        ArrayList<String> ans = new ArrayList<>();
////
////        ans.addAll(pathPrintWithLinkedList(path+"D",r-1,c));
////        ans.addAll(pathPrintWithLinkedList(path+"L",r,c-1));
////        return ans;
////    }
//
//    public static ArrayList<String> fullPathPrintWithLinkedList(String path, int r, int c){
//        if (r == 1 || c == 1){
//            ArrayList<String> list = new ArrayList<>();
//            list.add(path);
//            return list;
//        }
//
//        ArrayList<String> list = new ArrayList<>();
//
//        if (r > 1){
//            list.addAll(fullPathPrintWithLinkedList(path+'D',r-1,c));
//        }
//
//        if (c > 1){
//            list.addAll(fullPathPrintWithLinkedList(path+'R',r,c-1));
//        }
//
//        return list;
//    }
//
//    public static void main(String[] args){
////        System.out.println(mazePathCount(3,3));
////        System.out.println(pathPrint("",3,3));
////        System.out.println(pathPrintWithLinkedList("",3,3));
//        System.out.println(fullPathPrintWithLinkedList("",3,3));
//    }
//}
