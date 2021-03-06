package sort;

import java.util.Arrays;

/**
 * Created by weicools on 2018/3/12.
 * <p>
 * desc: 快速排序
 */
public class QuickSort {
    // 快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。
    // 但若初始序列按关键码有序或基本有序时，快排序反而蜕化为冒泡排序。
    // 为改进之，通常以“三者取中法”来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。
    // 快速排序是一个不稳定的排序方法。

    public static void main(String[] args) {
        int[] num = {3, 2, 6, 8, 4, 5, 9};
        System.out.println("------QuickSort------");
        System.out.println(Arrays.toString(num));
        quick(num);
    }


    /**
     * 快速排序
     *
     * @param numArray 待排序数组
     */
    private static void quick(int[] numArray) {
        //查看数组是否为空
        if (numArray.length > 0) {
            quickSort(numArray, 0, numArray.length - 1);
        }

        System.out.println("---------------------");
        System.out.println(Arrays.toString(numArray));
    }


    /**
     * 递归形式的分治排序算法
     *
     * @param numArray 待排序数组
     * @param low      开始位置
     * @param high     结束位置
     */
    private static void quickSort(int[] numArray, int low, int high) {
        if (low < high) {
            //将numbers数组进行一分为二
            int middle = getMiddle(numArray, low, high);

            //对低字段表进行递归排序
            quickSort(numArray, low, middle - 1);
            //对高字段表进行递归排序
            quickSort(numArray, middle + 1, high);
        }
    }


    /**
     * 查找出中轴（默认是最低位low）的在numbers数组排序后所在位置
     *
     * @param numArray 待查找数组
     * @param low      开始位置
     * @param high     结束位置
     * @return 中轴所在位置
     */
    private static int getMiddle(int[] numArray, int low, int high) {
        int temp = numArray[low];
        while (low < high) {
            while (low < high && numArray[high] >= temp) {
                high--;
            }
            numArray[low] = numArray[high];

            while (low < high && numArray[low] < temp) {
                low++;
            }
            numArray[high] = numArray[low];
        }

        numArray[low] = temp;
        return low;
    }
}
