package problems;

public class P852_PeakIndexinAMountainArray {
    public int peakIndexInMountainArray(int[] A) {
        int index = 0;
        if (A.length < 3) {
            return -1;
        }
        for (int i = 1; i < A.length -1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] A = {0,1,0};
        System.out.println(new P852_PeakIndexinAMountainArray().peakIndexInMountainArray(A));
    }
}
