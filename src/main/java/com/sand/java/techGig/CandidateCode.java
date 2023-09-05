package com.sand.java.techGig;// Java program to print all combination of size r in an array of size n
import java.io.*;
import java.util.Scanner;

class CandidateCode {


    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j]+" ");
            System.out.println("");
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
    static void printCombination(int arr[], int n, int r)
    {
        int data[]=new int[r];

        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    public static void main (String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();

    }
}

