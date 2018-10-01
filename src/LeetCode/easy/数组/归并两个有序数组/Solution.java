package LeetCode.easy.数组.归并两个有序数组;

import java.util.Arrays;

/**
 * @author Weicools Create on 2018.09.21
 *
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 *
 * desc: https://leetcode.com/problems/merge-sorted-array/description/
 */
class Solution {
  public void merge (int[] nums1, int m, int[] nums2, int n) {
    int index1 = m - 1, index2 = n - 1;
    int indexMerge = m + n - 1;
    while (index1 >= 0 || index2 >= 0) {
      if (index1 < 0) {
        nums1[indexMerge--] = nums2[index2--];
      } else if (index2 < 0) {
        nums1[indexMerge--] = nums1[index1--];
      } else if (nums1[index1] > nums2[index2]) {
        nums1[indexMerge--] = nums1[index1--];
      } else {
        nums1[indexMerge--] = nums2[index2--];
      }
    }
  }

  public static void main (String[] args) {
    Solution s = new Solution();
    int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    int[] nums2 = { 2, 5, 6 };
    s.merge(nums1, 3, nums2, 3);
    System.out.println(Arrays.toString(nums1));
  }
}
