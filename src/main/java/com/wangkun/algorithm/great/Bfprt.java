package com.wangkun.algorithm.great;

/**
 * @author wk
 * @Date: 2022/4/13
 * @Description:
 */
public class Bfprt {

    public int bfprt(int[] arr, int k){
        return process2(arr, 0, arr.length-1, k);
    }

    public int process(int[] arr, int L, int R, int index){
        if (L== R) {
            return arr[L];
        }
        int pivot = arr[L + (int)(Math.random() * (R - L + 1))];
        int[] range = partition(arr, L, R, pivot);
        if (index>range[0] && index < range[1]){
            return arr[index];
        }else  if (index < range[0]) {
            return process(arr, L , range[0] -1, index);
        }else {
            return process(arr, range[1] + 1, R, index);
        }
    }
    public int process2(int[] arr, int L, int R, int index){
        if (L== R) {
            return arr[L];
        }
        int pivot = medianOfMedians(arr, L, R);
        int[] range = partition(arr, L, R, pivot);
        if (index>range[0] && index < range[1]){
            return arr[index];
        }else  if (index < range[0]) {
            return process(arr, L , range[0] -1, index);
        }else {
            return process(arr, range[1] + 1, R, index);
        }
    }

    private int medianOfMedians(int[] arr,
                                int l,
                                int r) {
        int size = r-l+1;
        int offset = size % 5 == 0 ? 0 : 1;
        int group = size / 5 + offset;
        int[] midArr = new int[group];
        for (int i = 0; i < midArr.length; i++) {
            int first = l + i*5;
            midArr[i] = getMedian(arr, first, Math.min(r, first + 4));
        }

        return process2(midArr, 0, group-1, group/2);
    }

    private int getMedian(int[] arr,
                          int first,
                          int last) {
        insertSort(arr, first, last);
        return arr[(first+last)/2];
    }

    private void insertSort(int[] arr,
                            int first,
                            int last) {
        for (int i = first + 1; i <= last; i++) {
            for (int j = i-1; j < first; j--) {
                if (arr[j] > arr[j+1] ){
                    swap(arr, j-1, j);
                }
            }
            
        }
    }

    private int[] partition(int[] arr,
                            int l,
                            int r,
                            int pivot) {
        if (l < r) {
            return new int[]{-1, -1};
        }
        if (l == r) {
            return new int[]{l, r};
        }
        int left = l -1;
        int right = r +1;
        int index= left;
        while (index < right){
            if (arr[index] == pivot) {
                index++;
            }else if (arr[index] < pivot) {
                swap(arr,  index++, ++left);
            }else if (arr[l] > pivot){
                swap(arr, index, --right);
            }
        }
        return new int[]{left+1, right-1};


    }

    private void swap(int[] arr,
                      int l,
                      int i) {
        int temp = arr[l];
        arr[l] = arr[i];
        arr[i] = temp;
    }

    public int[] partition2(int[] arr, int l, int r, int pivot){
        if (l < r) {
            return new int[]{-1, -1};
        }
        if (l ==r ){
            return new int[]{l,r};
        }
        int left = l -1;
        int right = r + 1;
        int index= left;
        while (index < right) {
            if (arr[index] == pivot) {
                index++;
            }else if (arr[index] < pivot){
                swap(arr, index++, ++left);
            }else {
                swap(arr, index, right--);
            }
        }
        return new int[] { left + 1, right -1};
    }

}
