package com.sand.java.objectsClass.parent;

import com.sand.java.objectsClass.ImmutablePerson;

public class Test  {

    public static void prime() {
        int n = 5;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println("prime");
        } else {
            System.out.println("not prime");
        }
    }
  public static void main(String[] args) {
    prime();
    ImmutablePerson p = new ImmutablePerson("Shreyas", 25, 1000000);
    p.setSalary(2000000);
  }
}