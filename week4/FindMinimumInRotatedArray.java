public class FindMinimumInRotatedArray {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // Compare mid to the rightmost element
            if (nums[mid] > nums[right]) {
                // Minimum must be in the right half
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
