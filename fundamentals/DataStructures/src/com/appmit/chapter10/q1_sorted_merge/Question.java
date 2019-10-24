package com.appmit.chapter10.q1_sorted_merge;

public class Question {


    private static void mergesort(int[] array){
        int[] helper = new int[array.length];
        mergesort(array,helper,0,array.length - 1);
    }

    private static void printArray(int[] array){
        System.out.println();
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    private static void mergesort(int[] array, int[] helper, int low, int high){
        if(low < high){
            int mid = low + (high - low)/2;
            mergesort(array,helper,low,mid);
            mergesort(array,helper,mid+1,high);
            merge(array,helper,low,mid,high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int mid, int high){
        for(int i = low; i<=high; i++){
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int current = low;

        while(helperLeft <= mid && helperRight <= high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        int remaining = mid - helperLeft;
        for(int i = 0; i<=remaining; i++){
            array[current + i] = helper[helperLeft + i];
        }
    }

    private static void merge(int[] a, int[] b, int sizeA, int sizeB){
        int indexMerged = sizeA + sizeB - 1; // Last index of merged array
        int indexA = sizeA - 1; // last populated index of array A
        int indexB = sizeB - 1; // last index of array B

        while(indexB >= 0){
            if(indexA >= 0 && a[indexA] > b[indexB]){
                a[indexMerged] = a[indexA];
                indexA--;
            }else{
                a[indexMerged] = b[indexB];
                indexB--;
            }
            indexMerged--;
        }
    }


    public static void main(String[] args){
        /*int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 5, 6, 7, 7};
        merge(a, b, 8, 6);*/

        int[] array = new int[300];
        int j = 299;
        for(int i = 0; i<array.length; i++){
            array[i] = j;
            j--;
        }

        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }

        mergesort(array);
        System.out.println();

        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }


    }

}
