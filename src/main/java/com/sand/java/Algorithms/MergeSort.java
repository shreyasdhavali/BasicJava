package com.sand.java.Algorithms;

// Java program for Merge Sort
import java.io.*;
import java.util.Arrays;

class MergeSort {

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    void merge(int arr[], int start, int middle, int r)
    {
        System.out.println("-------merge code-------------");
        printArray(arr);
        // Find sizes of two subarrays to be merged
        int n1 = middle - start + 1;
        int n2 = r - middle;
        System.out.println( "merging -- start: " + start + " middle: " + middle + " r: " + r
        + " n1: " + n1 + " n2: " + n2);
        // Create temp arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            left[i] = arr[start + i];
        System.out.println("left");
        printArray(left);
        for (int j = 0; j < n2; ++j)
            right[j] = arr[middle + 1 + j];
        System.out.println("right");
        printArray(right);
        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = start;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        printArray(arr);
    }

    // Main function that sorts arr[l..r] using
    // merge()
    void sort(int arr[], int start, int r)// 12, 11, 13, 5, 6, 7 -- s = 0, r = 5
    {
        System.out.println("---------sort code----------");
        printArray(arr);
        if (start < r) {

            // Find the middle point
            int m = start + (r - start) / 2; // m = 2
            // m = 1
            // m = 0
            System.out.println( "sorting -- start: " + start + " middle: " + m + " r: " + r);
            // m = 4
            // m = 0

            // Sort first and second halves
            sort(arr, start, m); // 12, 11, 13, 5, 6, 7 -- s = 0, r = 2
            // 12, 11, 13, 5, 6, 7 -- s = 0, r = 1
            // 12, 11, 13, 5, 6, 7 -- s = 0, r = 0
            sort(arr, m + 1, r); // 12, 11, 13, 5, 6, 7 -- s = 3, r = 5
            // 12, 11, 13, 5, 6, 7 -- s = 5, r = 5
            // Merge the sorted halves
            merge(arr, start, m, r);
        }
    }

    // A utility function to print array of size n
    static void printArray(int arr[])
    {
        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7};

        System.out.println("Given array is");
        printArray(arr);
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array is");
        printArray(arr);
    }
}

