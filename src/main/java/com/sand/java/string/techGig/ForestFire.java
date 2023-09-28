package com.sand.java.string.techGig;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ForestFire {
    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int n = Integer.parseInt(input.split(" ")[0]);
        int x = Integer.parseInt(input.split(" ")[1]);
        String arrayString = scanner.nextLine();
        ArrayList<Integer> a = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            a.add(Integer.parseInt(arrayString.split(" ")[i]));
        }
        Collections.sort(a);
        Collections.reverse(a);
        System.out.println(a);

        AtomicInteger count  = new AtomicInteger();
        a.stream().forEach(i -> {
            if (i >= a.get(x-1)) {
                count.getAndAdd(1);
            }
        });

        if (count.get() == x) {
            System.out.println(a.get(x-1));
        } else {
            System.out.println("-1");
        }
        // 5,4,3,2,1  5 <=2     1,
//        for (int i = 0; i<=n; i++) {
//            if (a.get(i) >= a.get(x-1)) {
//                count.getAndAdd(1);
//            } else {
//                break;
//            }
//        }

//        n, x= map(int, input().split())
//        animals = list (map(int, input().split()))
//        animals.sort(reverse=True)
//        count = 0
//        for i in range(n):
//        if animals[i] >= animals [x-1]:
//        count += 1
//    else:
//        break
//        if count == x:
//        print (animals [x-1])
//else:
//        print("-1")


//        int count  = 0;
//        for (int i = a.size() -1; i >= 0; i--) {
//            if (a.get(i) >= a.get(x-1)) {
//                count +=1;
//            } else {
//                break;
//            }
//        }
//
//        if (count == x) {
//            System.out.println(a.get(x-1));
//        } else {
//            System.out.println("-1");
//        }










    }
}

