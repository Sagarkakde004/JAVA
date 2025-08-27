//class Recursion{
//    public void recursion(int i ,int n, int sum){
//        if (i == n){
//            sum += i;
//            System.out.println(sum);
//            return;
//        }
//
//
//        sum += i;
//        recursion(i+1,n,sum); // Third Approch for Simplify
//
////      int sumOf_NM1  =  recursion(i+1,n); // Second Approch to simplify Problem
////      return i+ sumOf_NM1;
//
////        int sum;
////       int sumOf_MN = recursion(n - 1);// after return 0 , these 0 is plus with the top of stack value whic is 1 means 0 + 1 = 1 then these one return as sumOf_MN and these while add with the second last of stack
////        sum = n + sumOf_MN;
////        return sum;
//    }
//}
//public class C_SumOf_n_Numbers {
//    public static void main(String[] args){
//        Recursion loop = new Recursion();
////        System.out.println(loop.recursion(5,10));
////        loop.recursion(5,10,0);
////        System.out.println(loop.recursion(5));
//    }
//}
