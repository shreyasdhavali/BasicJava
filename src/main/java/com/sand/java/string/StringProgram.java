package com.sand.java.string;

import java.util.*;

public class StringProgram {
    public static void main(String[] args) {
        String s = "    Programming  ";
        System.out.println(s);
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());
        System.out.println(s.length());
        System.out.println(s.toCharArray()[7]);
        System.out.println(s.trim());
        System.out.println(s.isEmpty());
        System.out.println(s.substring(5));
        System.out.println(s.substring(5, 9));//5 inclusive 9 exclusive
        System.out.println(s.split("").length);
        String[] a = new String[]{"a", "b", "c"};
        String []b = new String[]{"a", "b", "c"};
        String c[] = new String[]{"a", "b", "c"};
        System.out.println(a[2]);
        System.out.println(b[1]);
        System.out.println(c[0]);

        String[] d = new String[4];
        System.out.println(d[0]);
        System.out.println(d[3]);
        System.out.println(d[2]);

        String[][] e = {{""}};
        String[][] f = new String[3][3];
        System.out.println(f[0][0]);

        String[] arrayString = {"a", "b", "c", "d"};
        List<String> listString = new ArrayList<>(Arrays.asList("e", "f", "g", "h"));
        arrayString = listString.toArray(arrayString);
        System.out.println(arrayString[3]);

        String[] colors = {"Cricket","Basketball","Football","Badminton","Tennis"};
        Arrays.sort(colors);
        System.out.println(Arrays.toString(colors));
        System.out.println(Arrays.toString(colors).replaceAll("(\\[)|(\\])|(,)",""));
        System.out.println(Collections.nCopies(5, "abc"));

        // sort array for string compare;
        String[] ab = {"z", "d", "e", "t","a", "b"};
        Arrays.sort(ab);
        System.out.println("----------------------------");
        Arrays.stream(ab).sorted(Comparator.comparing(String::toString).reversed()).forEach(System.out::println);
        for (int i=0; i<ab.length-1; i++) {
            for (int j=i+1; j<ab.length; j++) {
                if (ab[i].compareTo(ab[j]) > 0) { // ascending string array.
                    String t = ab[i];
                    ab[i] = ab[j];
                    ab[j] = t;
                }
            }
        }
        System.out.println(Arrays.toString(ab));
        for (int i=0; i<ab.length-1; i++) {
            for (int j=i+1; j<ab.length; j++) {
                if (ab[i].compareTo(ab[j]) < 0) { // descending string array
                    String t = ab[i];
                    ab[i] = ab[j];
                    ab[j] = t;
                }
            }
        }
        System.out.println(Arrays.toString(ab));
        String s1 = 10 + 30 +40 + "Hello" + 10 +20 + "Hii";
        System.out.println(s1);
        System.out.println("Hello" + 10*2 + 10);
        System.out.println(new MyClass().id);

        System.out.println(new MyClass().hashCode());
        MyClass m1 = new MyClass("1");
        MyClass m2 = new MyClass("1");
        System.out.println(m1.equals(m2));

    }


}

class MyClass {
    String id;
    MyClass () {
    }
    MyClass(String id) {
        this.id = id;
    }

//    public String toString() {
//        return "Hello Shreyas";
//    }

//    public int hashCode() {
//        return 200;
//    }

    public boolean equals(MyClass m) {
        if (this.id != null) {
            if (m.id != null) {
                return this.id.equals(m.id);
            }
        }
        return false;
    }
}