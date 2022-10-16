public class RotateNumber {
    public void RotateNumber(int[] nums, int k) {
        if (k == 0) {

        } else {
            int n = nums.length;
            k = k % n;
            int[] res = new int[n];
            for (int i = 0; i < k; i++) {
                res[i] = nums[i + n - k];
            }
            for (int i = k; i < n; i++) {
                res[i] = nums[i - k];
            }
            for (int i = 0; i < n; i++) {
                nums[i] = res[i];
            }
        }
    }
}
