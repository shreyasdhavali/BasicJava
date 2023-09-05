package com.sand.java.utils;//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Utils {
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        Map<String, String> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String k = in.nextLine();
            String v = in.nextLine();
            map.put(k, v);
        }
        for (int i=0; i<n; i++) {
            String key = in.nextLine();
            if (map.containsKey(key)) {
                System.out.println(key + "=" + map.get(key));
            } else {
                System.out.println("Not found");
            }
        }
    }
}



