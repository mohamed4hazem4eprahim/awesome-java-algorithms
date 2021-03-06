package leetcode.easy.string;

/**
 * @author Weicools Create on 2018.11.12
 * 459. 重复的子字符串
 * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 *
 * 示例 1:
 * 输入: "abab"
 * 输出: True
 * 解释: 可由子字符串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: "aba"
 * 输出: False
 * 示例 3:
 * 输入: "abcabcabcabc"
 * 输出: True
 *
 * 解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
 * desc: https://leetcode-cn.com/problems/repeated-substring-pattern/description/
 * tag: 字符串
 */
class LC0459RepeatedSubStringPattern {
  /**
   * 二分--三分--四分……
   * 取第一个字符串进行相加得到原字符串就返回true
   */
  public boolean repeatedSubstringPattern (String s) {
    int l = s.length();
    for (int i = l / 2; i >= 1; i--) {
      if (l % i == 0) {
        int m = l / i;
        String sub = s.substring(0, i);
        StringBuilder sb = new StringBuilder(sub);
        for (int j = 1; j < m; j++) {
          sb.append(sub);
        }

        if (s.equals(sb.toString())) {
          return true;
        }
      }
    }

    return false;
  }

  public static void main (String[] args) {
    LC0459RepeatedSubStringPattern s = new LC0459RepeatedSubStringPattern();
    System.out.println(s.repeatedSubstringPattern("abab"));
    System.out.println(s.repeatedSubstringPattern("aba"));
    System.out.println(s.repeatedSubstringPattern("abcabcabcabc"));
  }
}
