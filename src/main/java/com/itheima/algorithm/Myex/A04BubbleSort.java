package com.itheima.algorithm.Myex;

public class A04BubbleSort {

    public static void sort(int[] a){
        bubble(a,a.length-1);
    }

    //j代表未排序的右边界
    public static void bubble(int[] a,int j){
        if (j == 0){
            System.out.println(a[0]);
            return;
        }
        for (int i = 0; i < j; i++) {
            int t;
            if (a[i] > a[i+1]){
                t = a[i];
                a[i] = a[i+1];
                a[i+1] = t;
            }
        }
        bubble(a,j-1);
        System.out.println("a["+j+"]是"+a[j]);
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        A04BubbleSort.sort(a);
        System.out.println(a);
    }
}
