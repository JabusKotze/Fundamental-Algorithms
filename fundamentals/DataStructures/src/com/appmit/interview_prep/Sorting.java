package com.appmit.interview_prep;

public class Sorting {

    public void bubbleSort(int[] arr){

        int n = arr.length;

        for(int i=0; i<n - 1; i++){
            for(int j=0; j < n - i -1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }


    public void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    public void merge(int[] arr, int l, int m, int r){

        // get size of two arrays
        int s1 = m - l + 1;
        int s2 = r - m;

        // Create temp arrays
        int[] L = new int[s1];
        int[] R = new int[s2];

        // Populate the two temp arrays
        /*Copy data to temp arrays*/
        for (int i=0; i<s1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<s2; ++j)
            R[j] = arr[m + 1+ j];

        // Now merge the two arrays
        int i =0, j = 0;

        // Initial index of merged array
        int k = l;

        while(i < s1 && j < s2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < s1){
            arr[k] = L[i];
            k++;
            i++;
        }

        while(j < s2){
            arr[k] = R[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};

        Sorting os = new Sorting();
        //os.mergeSort(arr, 0, arr.length - 1);
        os.bubbleSort(arr);

        for(int i: arr){
            System.out.println(i);
        }
    }
}
