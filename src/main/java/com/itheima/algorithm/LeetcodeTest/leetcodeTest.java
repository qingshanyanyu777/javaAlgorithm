package com.itheima.algorithm.LeetcodeTest;

public class leetcodeTest {
    /*

       [-1,0,3,5,9,12]
       9
        */
    class Solution {
        public int search(int[] nums, int target) {
            int start = 0 , end = nums.length-1;
            int f = -1;

            //缩小范围
            while (1 <end - start){
                int m = (start +end) >>> 1;
                if (target < nums[m]){
                    end = m;
                }else {
                    start = m;
                }
            }

            return (nums[start] == target) ? start : -1;
        }
    }

}
