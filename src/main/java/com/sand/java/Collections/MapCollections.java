package com.sand.java.Collections;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Lang {
    String name;
    int num;

    Lang(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return this.name + " " + this.num;
    }
}
public class MapCollections {
    public static void main(String[] args) {
        String s = "It seems like you're asking for a general overview or summary of the Java programming language. Here's a brief summary of Java:\n" +
                "\n" +
                "Robust and Secure: Java incorporates strong type checking and runtime checking, which helps catch errors at an early stage. It also provides features like garbage collection to manage memory, making it robust and secure.\n" +
                "\n" +
                "Desktop Applications: Java GUI libraries like Swing and JavaFX are used to create cross-platform desktop applications.\n" +
                "Web Applications: Java EE is used for building enterprise-level web applications using technologies like Servlets, JSP, and EJB.\n" +
                "Mobile Applications: Java ME is used for mobile application development on feature phones.\n" +
                "Server Applications: Java is commonly used for building server-side applications, web services, and APIs.\n" +
                "Big Data and IoT: Java's robustness and platform independence make it suitable for big data and Internet of Things (IoT) projects.\n" +
                "Java's popularity, versatility, and extensive ecosystem have made it one of the most widely used programming languages in the world.";

        String[] list = s.replaceAll("[^A-Za-z0-9 ]", "").split(" ");
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> tree = new TreeMap<>(Collections.reverseOrder());
        for (String i: list) {
            int count = 0;
            if (map.containsKey(i)) {
                count = map.get(i);
            }
            count+=1;
            map.put(i, count);
            tree.put(i, count);
        }
        List<Lang> langs = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            langs.add(new Lang(entry.getKey(), entry.getValue()));
        }
        System.out.println("------------------------");
        langs.stream().sorted(Collections.reverseOrder(Comparator.comparing(Lang::getNum))
                                .thenComparing(Lang::getName))
                .forEach(System.out::println);
        System.out.println("------------------------");
        for (Map.Entry<String, Integer> entry: tree.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println("------------------------");
        langs.stream().sorted(Collections.reverseOrder(Comparator.comparing(Lang::getNum))
                        .thenComparing(Collections.reverseOrder(Comparator.comparing(Lang::getName))))
                .forEach(System.out::println);

        Map<String, String> m = new HashMap<>();
        m.put(null, "1");
        m.put(null, "10");
        m.put(null, null);
        m.put(null, "10");
        m.put("1", "2");
        m.put("1", null);
        m.put("2", "4");
        m.put("3", null);
        System.out.println("hashmap" + m);
        System.out.println(m.get(null));
        m = new LinkedHashMap<>();
        m.put(null, "1");
        m.put(null, "10");
        m.put(null, null);
        m.put(null, "10");
        m.put("1", "2");
        m.put("1", null);
        m.put("2", "4");
        m.put("3", null);
        System.out.println("Linked " + m);
        System.out.println(m.get(null));
        System.out.println("contains -" + m.containsValue("10"));
        m = new TreeMap<>();
//        m = new TreeMap<>(Collections.reverseOrder());
//        m.put(null, "1");
//        m.put(null, "10"); null key not allowed in treeMap NullPointerException
//        m.put(null, null);
//        m.put(null, "10");
        m.put("s", "2");
        m.put("h", null);
        m.put("c", "4");
        m.put("b", null);
        System.out.println("Tree " + m);
        m = new Hashtable<>();
//        m.put(null, "1");
//        m.put(null, "10");null key not allowed in Hashtable NullPointerException
//        m.put(null, null);
//        m.put(null, "10");
        m.put("1", "2");
//        m.put("1", null); null value not allowed in Hashtable NullPointerException
        m.put("2", "4");
        m.put("3", "28");
        System.out.println("Hashtable " + m);
        m = new ConcurrentHashMap<>();
//        m.put(null, "1"); null key not allowed in ConcurrentHashMap NullPointerException
//        m.put(null, "10");
//        m.put(null, null);
//        m.put(null, "10");
        m.put("1", "2");
        m.put("8", "null");
//        m.put("1", null); null value not allowed in ConcurrentHashMap NullPointerException
        m.put("2", "4");
        m.put("3", "something");
        System.out.println("Concurrent Map " + m);

        Map<Color, Integer> enumMap = new EnumMap<>(Color.class);
        enumMap.put(Color.RED, 1);
        enumMap.put(Color.GREEN, 2);
//        enumMap.put(null, 4); null key not allowed in EnumMap NullPointerException
        enumMap.put(Color.BLUE, null);
        System.out.println("enum Map " + enumMap);

    }
}

enum Color { RED, GREEN, BLUE }
