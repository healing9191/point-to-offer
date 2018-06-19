package learn;

import java.util.Arrays;

/**
 * @Author: Skye
 * @Date: 20:58 2018/6/19
 * @Description: 插入排序
 */
public class Code_01_InsertionSort {
    public static void insertionSort(int[] arr){
        if (arr == null || arr.length < 2)
            return;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j-1]; j--) {
                swap(arr,j,j-1);
            }
        }

    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // for test, java 默认实现，一个保证对的方法
    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    // for test, 产生一个随机数组
    public static int[] generateRandomArray(int maxSize,int maxValue){
        // random array size
        int[] arr = new int[(int)((1 + maxSize) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }

        return arr;
    }
    //for test
    public static int[] copyArray(int[] arr){
        if (arr == null)
            return null;
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    //for test
    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // 与保证正确的答案对比多次，验证结果
        int testTime = 50000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize,maxValue);
            int[] arr2 = copyArray(arr1);
            insertionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1,arr2)){
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!":"Fucking!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        insertionSort(arr);
        printArray(arr);

    }
}
