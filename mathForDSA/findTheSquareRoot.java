package mathForDSA;

public class findTheSquareRoot {
    public static void main(String[] args){
//        int[] arr = new int[40];
//        for (int i = 0; i<40;i++){
//            arr[i] = i+1;
//        }

        double mid = 1;
        double start = 1;
        double end = 40;

        while (start<end && (!(mid*mid == 0))){
            mid = start + (end-start)/2;

            if (mid*mid < 40 && (mid+1)*(mid+1) > 40){
                start = mid + 0.1;
            } else if (mid*mid < 40) {
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        System.out.println(mid);
    }
}
