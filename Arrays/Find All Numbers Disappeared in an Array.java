import java.util.*;

/**
 * LeetCode Problem: Find All Numbers Disappeared in an Array
 * Problem link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), 
 * some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 */

public class FindAllNumbersDisappeared {

    // --------------------- Approach 1 ---------------------
    // Binary Search after Sorting (Time: O(n log n), Space: O(1))
    // ------------------------------------------------------
    static class Approach1 {
        // Helper method for binary search
        private boolean binarySearch(int key, int[] nums, int low, int high) {
            if (low > high) return true;
            int mid = low + (high - low) / 2;
            if (nums[mid] == key) return false;
            if (nums[mid] < key) return binarySearch(key, nums, mid + 1, high);
            return binarySearch(key, nums, low, mid - 1);
        }

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> missingNumbers = new LinkedList<>();
            int n = nums.length;
            Arrays.sort(nums); // Sort the array

            // Check each number from 1 to n using binary search
            for (int i = 1; i <= n; i++) {
                if (binarySearch(i, nums, 0, n - 1)) {
                    missingNumbers.add(i);
                }
            }

            return missingNumbers;
        }
    }

    // --------------------- Approach 2 ---------------------
    // In-place Marking using Negatives (Time: O(n), Space: O(1))
    // -------------------------------------------------------
    static class Approach2 {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();

            // Mark indices corresponding to the numbers as negative
            for (int i = 0; i < nums.length; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] > 0) {
                    nums[index] *= -1;
                }
            }

            // Numbers corresponding to positive indices are missing
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    result.add(i + 1);
                }
            }

            return result;
        }
    }

    // --------------------- Approach 3 ---------------------
    // Swapping (Time: O(n), Space: O(1))
    // ------------------------------------------------------
    static class Approach3 {
        // Swap utility
        private void swap(int i, int j, int[] arr) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> result = new ArrayList<>();
            int n = nums.length;

            // Place each element at its correct index
            for (int i = 0; i < n; i++) {
                while (nums[i] != nums[nums[i] - 1]) {
                    swap(i, nums[i] - 1, nums);
                }
            }

            // Find indices where the value doesn't match index+1
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    result.add(i + 1);
                }
            }

            return result;
        }
    }

    // --------------------- Driver Code (Optional) ---------------------
    public static void main(String[] args) {
    int[] input = {4, 3, 2, 7, 8, 2, 3, 1};

    // Call each approach with a fresh copy of the input
    System.out.println("Approach 1 Output: " + new Approach1().findDisappearedNumbers(input.clone()));
    System.out.println("Approach 2 Output: " + new Approach2().findDisappearedNumbers(input.clone()));
    System.out.println("Approach 3 Output: " + new Approach3().findDisappearedNumbers(input.clone()));
}

}
