public class allocateminpage {

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int m = 2;
        int n = arr.length;
        int result = 0;
        System.out.println("Minimum number of pages: " + allocateMinPages(arr, 1, m, result));
    }

    private static int allocateMinPages(int[] arr, int partition, int students, int result) {


        if (partition == arr.length) {
            return result;
        }



        return -1;

    }
}
