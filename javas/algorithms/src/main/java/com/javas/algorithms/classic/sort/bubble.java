package com.javas.algorithms.classic.sort;

import java.util.Arrays;

public class bubble {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 6, 2, 7, 2, 10, 34, 23};
        sort2(arr1);
        System.out.print("排序结果：" + Arrays.toString(arr1));
    }

    public static void sort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i -1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }
    public static void sort2(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j >i+1; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }
//
//    public static void sort2(int[] arr){
//        if(null==arr || arr.length==0){
//            return;
//        }
//        for(int i=arr.length-1;i>=0;i--){
//            for(int j=i-1;j>=0;j--){
//                if (arr[i] < arr[j]){
//                    int tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//        }
//        return;
//    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
