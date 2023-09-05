package com.sand.java.techGig;/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Weight {
    private static List<Integer> getInputArray(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> getInputArrayList(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().trim().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        List<Integer> first = getInputArray(br);
        Set<Integer> firstSet = new TreeSet<>(first);
        List<Integer> second = getInputArrayList(br);
        Map<Integer, Integer> map = new HashMap<>();

        for (int s: second) {
            firstSet.add(s);
            if (map.get(s) != null) {
                System.out.println(map.get(s));
                continue;
            }
            ArrayList<Integer> first1 = new ArrayList<>(firstSet);
            Collections.reverse(first1);
            System.out.println(first1.indexOf(s) + 1);
            map.put(s, first1.indexOf(s) + 1);
        }
    }
}