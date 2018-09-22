package LeetCode.other.LinkedList.deleteAllDuplicates;

/**
 * @author Weicools Create on 2018/4/26.
 *
 * desc:
 */
public class Solution {
  public static ListNode deleteDuplicates (ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      while (curr.next != null && curr.val == curr.next.val) {
        curr.next = curr.next.next;
      }

      curr = curr.next;
    }

    return head;
  }
}