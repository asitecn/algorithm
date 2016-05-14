/*
4.  抓阿里巴巴。 一排洞，一个阿里巴巴呆在某个洞里。白天，你去开某“一个”格
子，如果阿里巴巴就在这里，你抓住他了。如果没抓住，晚上，阿里巴巴会躲到相邻
的某个格子里。注意，只能而且一定左或右跳一格。
题目： input, n 个洞穴, 一个Check 序列 ，你判断一下，这个序列能不能抓住阿里
巴巴。 比如，n = 3. { 1, 1 }.  这肯定能抓住, 返回true.  
*/

import java.util.*;
public class CatchAlibaba {

    public boolean canCatch(int[] arr, int n) {
        Set<Integer> q1 = new HashSet<Integer>();
        for(int i = 0; i < n; i++) {
            q1.add(i);
        }
        Set<Integer> q2 = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++) {
            for(Integer val : q1) {
                if (val != arr[i]) {
                    if (i > 0) {
                        q2.add(i - 1);
                    }
                    if (i < n - 2) {
                        q2.add(i + 1);
                    }
                }
            }
            if (q2.isEmpty()) {
                return true;
            }
            Set<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
            q2.clear();
        }
        return false;
    }

    public void test() {
        {
            int[] arr = new int[]{1, 1};
            int n = 3;
            boolean canCatch = canCatch(arr, n);
            System.out.println(canCatch);
        }
        {
            int[] arr = new int[]{1, 2, 1, 2, 1, 2};
            int n = 3;
            boolean canCatch = canCatch(arr, n);
            System.out.println(canCatch);
        }
        {
            int[] arr = new int[]{2, 2};
            int n = 3;
            boolean canCatch = canCatch(arr, n);
            System.out.println(canCatch);
        }
        {
            int[] arr = new int[]{2, 2, 1};
            int n = 3;
            boolean canCatch = canCatch(arr, n);
            System.out.println(canCatch);
        }
    }

    public static void main(String[] args) {
        CatchAlibaba can = new CatchAlibaba();
        can.test();
    }
}
