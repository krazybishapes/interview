package leetcode;

import java.util.Arrays;

public class PackingBoxes {
    public static int minPackingSpeed(int[] piles, int h) {

        // Binary search for the optimal packing speed
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        while (low < high) {
            int mid = (low + high) / 2;
            if (canFinish(piles, mid, h)) {
                high = mid; // Try a smaller packing speed
            } else {
                low = mid + 1; // Increase the packing speed
            }

            System.out.println(mid +" "+ low +" "+high);
        }
        return low; // The smallest feasible packing speed
    }

    static boolean canFinish(int[] piles, int k, int h) {
        int hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += Math.ceil((double) pile / k);
        }
        return hoursNeeded <= h;
    }


    public static void main(String[] args) {
        int[] piles = {4, 5, 30, 11, 6};
        int h = 8;

        System.out.println("Minimum Packing Speed: " + minPackingSpeed(piles, h));
    }
}
