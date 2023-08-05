package com.itheima.algorithm.LeetcodeTest;

public class A034_Test {

    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int x = leftMost(nums,target);
            if (x == -1){
                return new int[] {-1,-1};
            }else {
                int y = rightMost(nums,target);
                return new int[] {x,y};
            }

        }
        public int leftMost(int [] nums, int target){
            int low = 0 , high = nums.length -1 ;
            int condidate = -1 ;
            while (low <= high){
                int mid = (low + high) >>> 1;

                if (target < nums[mid]){
                    high = mid - 1;
                }else if (nums[mid] < target){
                    low = mid + 1;
                } else {
                    condidate = mid;
                    high = mid -1;
                }
            }
            return condidate;
        }

        public int rightMost(int [] nums, int target){
            int low = 0 , high = nums.length -1 ;
            int condidate = -1 ;
            while (low <= high){
                int mid = (low + high) >>> 1;

                if (target < nums[mid]){
                    high = mid - 1;
                }else if (nums[mid] < target){
                    low = mid + 1;
                } else {
                    condidate = mid;
                    low = mid + 1;
                }
            }
            return condidate;
        }
    }
}
