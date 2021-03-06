package leetcode.easy.string;

/**
 * @author Weicools Create on 2018.08.18
 *
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * desc: https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/5/strings/40/
 * https://leetcode-cn.com/problems/longest-common-prefix/description/
 * tag: 字符串
 */
class LC0014LongestCommonPrefix {
  /**
   * 找出最短的那个字符串的长度 minLen，
   * 然后在 0...minLen 的范围比较所有字符串，
   * 如果比较到有不同的字符，那么直接返回当前索引长度的字符串即可，
   * 否则最后返回最短的字符串即可
   */
  public String longestCommonPrefix (String[] strs) {
    int len = strs.length;
    if (len == 0) {
      return "";
    }
    int minLen = 0x7fffffff;
    for (String str : strs) {
      minLen = Math.min(minLen, str.length());
    }
    for (int j = 0; j < minLen; ++j) {
      for (int i = 1; i < len; ++i) {
        if (strs[0].charAt(j) != strs[i].charAt(j)) {
          return strs[0].substring(0, j);
        }
      }
    }
    return strs[0].substring(0, minLen);
  }

  public static void main (String[] args) {
    LC0014LongestCommonPrefix s = new LC0014LongestCommonPrefix();
    String[] strs1 = { "flower", "flow", "flight" };
    String[] strs2 = { "dog", "racecar", "car" };

    System.out.println(s.longestCommonPrefix(strs1));
    System.out.println(s.longestCommonPrefix(strs2));
  }
}
