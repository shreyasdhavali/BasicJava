package com.sand.java.DataStructures;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ArrayStructure {

    // Linear search
    public static void linearSearch(int[] arr, int search) {
        AtomicInteger count = new AtomicInteger();
        Arrays.stream(arr).forEach(i -> {
            count.getAndIncrement();
            if (i == search) {
                System.out.println("Linear search == found - " + i + " at position " + count);
            }
        });
    }

    // Binary search
    public static void binarySearch(int[] arr, int search) {
        Arrays.sort(arr);
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == search)
                System.out.println("Binary Search == found  - " + (m + 1));

            if (arr[m] < search)
                l = m + 1;
            else
                r = m - 1;
        }
    }

    public static void reverseArray(int[] arr) {
        Arrays.sort(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void largestThree(int[] arr) {
        int n = arr.length, first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

        for (int j : arr) {
            if (j > first) {
                third = second;
                second = first;
                first = j;
            } else if (j > second) {
                third = second;
                second = j;
            } else if (j > third) {
                third = j;
            }
        }
        System.out.println("largest three === " + first + " " + second + " " + third);
    }

    private static void smallestThree(int[] arr) {
        int n = arr.length, first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;

        for (int j : arr) {
            if (j < first) {
                third = second;
                second = first;
                first = j;
            } else if (j < second) {
                third = second;
                second = j;
            } else if (j < third) {
                third = j;
            }
        }
        System.out.println("Smallest three === " + first + " " + second + " " + third);
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    private static void swapZeros() {
        int[] arr = {5, 6, 0, 4, 6, 0, 9, 0, 8};
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                swap(arr, j, i);
                j++;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

    private static void binarySum() {
        int b1 = 101, b2 = 101;
        int[] sum = new int[10];
        int i = 0, reminder = 0;
        System.out.println();
        while (b1 != 0 && b2 != 0) {
            sum[i++] = (b1 % 10 + b2 % 10 + reminder) % 2;
            reminder = (b1 % 10 + b2 % 10 + reminder) / 2;
            b1 = b1 / 10;
            b2 = b2 / 10;
            System.out.println(b1 + " " + b2);
        }
        if (reminder != 0) {
            sum[i] = reminder;
        }
        while (i >= 0) {
            System.out.print(sum[i--]);
        }
    }

    private static int binaryToInt(int binary) {
        int sum = 0, i = 0;
        while (binary != 0) {
            sum += Math.pow(2, i++) * (binary % 10);
            binary /= 10;
        }
        System.out.println(sum);
        return sum;
    }

    private static void intToBinary(int integer) {
        int i = 0;
        int[] binary = new int[20];
        while (integer != 0) {
            binary[i++] = integer % 2;
            integer /= 2;
        }
        --i;
        while (i >= 0) {
            System.out.print(binary[i--]);
        }
    }

    private static void multiplyBinary(int b1, int b2) {
        b1 = binaryToInt(b1);
        b2 = binaryToInt(b2);
        int p = b1 * b2;
        intToBinary(p);
    }

    public static void main(String[] args) {
        int[] arr = {12, 13, 1, 10, 34, 1};
        int search = 1;
        AtomicInteger count = new AtomicInteger();

        // Linear search
        linearSearch(arr, search);


        // Binary search
        binarySearch(arr, search);

        // Reverse array
        reverseArray(arr);
        System.out.println();

        // Three largest
        largestThree(arr);

        // smallest three
        smallestThree(arr);

        // swap zeros to end
        swapZeros();

        // binary sum
        binarySum();
        System.out.println();

        // int to binary
        binaryToInt(110);

        // int to binary
        intToBinary(5);

        // multiply binary
        multiplyBinary(10, 11);

        System.out.println(arr[arr.length-1]);

    }
}
