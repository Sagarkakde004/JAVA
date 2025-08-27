//package mathForDSA;
//
//public class findPrimeWithMinTC {
//
//    static void isPrime(int n,boolean[] arr){
//        if (n <= 1){
//            return;
//        }
//
//        for (int i = 2;i*i <= n;i++){
//            if (!arr[i]){
//                for (int j=i*2;j<=n;j+=i){
//                    arr[j] = true;
//                }
//            }
//        }
//
//        for (int k = 2;k <= n;k++){
//            if (!arr[k]){
//                System.out.print(k+" |");
//            }
//        }
//    }
//    public static void main(String[] args){
//        int n = 40;
//        boolean[] arr = new boolean[n+1];
//        isPrime(n,arr);
//    }
//}
