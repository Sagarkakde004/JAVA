public class Practice {
    public static void main(String[] args){
        int arr[] = {7,8,3,1,2,4};
        int size = arr.length;
        int temp;

        for (int i : arr){
            System.out.print(i);
        }

        System.out.println();
        for (int i = 0; i < size-1; i++){
            for (int j = i+1; j > 0;j--){
                if (arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i : arr){
            System.out.print(i);
        }
    }
}
