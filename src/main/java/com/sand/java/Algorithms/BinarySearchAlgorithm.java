package com.sand.java.Algorithms;

import java.util.Scanner;

public class BinarySearchAlgorithm {
    public static void binarySearch(int search, int[] a) {
        int start = 0, r = a.length - 1;
        while(start <=r) {
            int m = start + (r - start)/2;
            if (a[m] == search) {
                System.out.println("found " + search + " at position " + (m+1));
                return;
            }
            if (a[m] < search) {
                start = m +1;
            } else {
                r = m-1;
            }
        }
        System.out.println(search  + " not found");
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int search = s.nextInt();
        binarySearch(search, new int[]{1,2,3,4,5,6,7,8,9});
        main(new String[]{});
    }
}
