package com.itheima.algorithm.Myex;

public class A03BinarSearch {
    public static int search(int[] a,int target){

        return f(a,target,0,a.length - 1);
    }

    private static int f(int[] a,int target,int i,int j){
        if (i >j){
            return -1;
        }
        int m = (i+j) >>> 1 ;
        if (target < a[m]){
           return f(a,target,i,m - 1);
        } else if (a[m] < target) {
           return f(a,target,m + 1,j);
        } else {
            return m;
        }

    }

    public static void main(String[] args) {
        int[] a = {2,15,26,34,55,67,88};
        System.out.println(search(a,2));
        System.out.println(search(a,15));
        System.out.println(search(a,26));
        System.out.println(search(a,34));
        System.out.println(search(a,55));
        System.out.println(search(a,0));
        System.out.println(search(a,60));
    }
}
