package com.sand.java.utils;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int numDisks = 3; // Change the number of disks as needed
        char sourceRod = 'S';
        char auxiliaryRod = 'A';
        char destinationRod = 'D';

        solveTowerOfHanoi(numDisks, sourceRod, auxiliaryRod, destinationRod);
    }

    public static void solveTowerOfHanoi(int numDisks, char sourceRod, char auxiliaryRod, char destinationRod) {
        if (numDisks == 1) {
            System.out.println("Move disk 1 from rod " + sourceRod + " to rod " + destinationRod);
            return;
        }

        // Move top (n-1) disks from sourceRod to auxiliaryRod using destinationRod as auxiliary
        solveTowerOfHanoi(numDisks - 1, sourceRod, destinationRod, auxiliaryRod);

        // Move the nth disk from sourceRod to destinationRod
        System.out.println("Move disk " + numDisks + " from rod " + sourceRod + " to rod " + destinationRod);

        // Move the (n-1) disks from auxiliaryRod to destinationRod using sourceRod as auxiliary
        solveTowerOfHanoi(numDisks - 1, auxiliaryRod, sourceRod, destinationRod);
    }
}

