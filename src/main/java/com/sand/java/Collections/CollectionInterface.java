package com.sand.java.Collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionInterface {

    public static void main(String[] args) throws Exception{
        List<Integer> products = Arrays.asList(1, 2);
//        products.add(5);
//        products.add(4);
//        products.add(3);
//        products.add(2);
//        products.add(1);
        products.toString();

        Iterator<Integer> iterator = products.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Map<String, String> map = new TreeMap();
        map.put("a", "1");
        map.put("w", "2");
        map.put("a", "3");
        map.put("y", "4");
        map.put("u", "5");
        map.put("r", "6");
        map.put("s", "7");
        map.put("j", "7");
        map.put("i", "7");
        map.put("l", "8");

        Set<String> sets = new TreeSet<>();
        sets.add("a");
        sets.add("w");
        sets.add("a");
        sets.add("y");
        sets.add("u");
        sets.add("r");
        sets.add("s");
        sets.add("j");
        sets.add("i");
        System.out.println(sets);

        Collections.sort(products);
        System.out.println(products);
        Collections.reverse(products);
        System.out.println(products);

        ArrayList<Product> productArrayList= new ArrayList<>();
        productArrayList.add(new Product("xyz", 100, 80.5f));
        productArrayList.add(new Product("dfg", 500, 20.5f));
        productArrayList.add(new Product("abc", 400, 77.5f));
        productArrayList.add(new Product("abc", 500, 78.5f));
        productArrayList.add(new Product("abc", 600, 79.5f));
        productArrayList.add(new Product("dfg", 600, 82.5f));
        productArrayList.add(new Product("xyz", 600, 90.5f));

        productArrayList.stream().filter(i -> i.getPrice() > 22f)
                .sorted((i,j) -> j.getName().compareTo(i.getName())) // lowest priority last level of sorting
                .sorted((i,j) -> Integer.compare(j.getWeight(), i.getWeight()))
                .sorted((i,j) -> Double.compare(j.getPrice(), i.getPrice())) // highest priority 1st level of sorting
                                .forEach(System.out:: println);

        System.out.println("---------------------------");

        productArrayList.stream().sorted(Collections.reverseOrder(Comparator.comparing(Product::getPrice))
                .thenComparing(Product::getWeight)
                .thenComparing(Product::getName)).forEach(System.out::println);

        productArrayList.stream().map(Product::getName).forEach(System.out::println);

        System.out.println("By name");
        productArrayList.sort(Product.compareByName());
        productArrayList.forEach(i-> System.out.println(i.toString()));

        System.out.println("By price");
        productArrayList.sort(Product.compareByPrice());
        productArrayList.forEach(i-> System.out.println(i.toString()));

        System.out.println("By weight");
        productArrayList.sort(Product.compareByWeight());
        productArrayList.forEach(i-> System.out.println(i.toString()));
        System.out.println();

        productArrayList.stream().map(Product::getName).sorted().forEach(System.out::println);
        productArrayList.stream()
                .filter(i -> i.getWeight()<450)
                .map(Product::getName)
                .forEach(System.out::println);

        productArrayList.stream()
                .filter(i -> i.getWeight()>450)
                .forEach(i -> System.out.println(i.getName()));

        List<Product> p = productArrayList.stream()
                .filter(i -> i.getPrice()< 71)
                .collect(Collectors.toList());
        System.out.println(p);

        Map<String, List<Product>> m = productArrayList.stream()
                .filter(i -> i.getWeight() > 100)
                .collect(Collectors.groupingBy(Product::getName));

        System.out.println(m);

        Map<String, Long> l = productArrayList.stream()
                .filter(i -> i.getWeight() > 100)
                .collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
        System.out.println(l);
        System.out.println("---------------------");
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(10);
//        a.add(null); null values allowed
        a.add(15);
        a.add(7);
        a.add(9);
//        a.add(null);
        System.out.println(a);
        Collections.rotate(a, 3);
        System.out.println(a);
        Collections.rotate(a, -1);
        System.out.println(a);
        a.sort(Comparator.comparing(Integer::intValue).reversed());
        System.out.println(a);
        int[] i = {1,6,7,2,9,10};
        String[] s = {"d","a","r","q","t","n","j","s",};
        List<Integer> listInt = Arrays.stream(i).boxed().collect(Collectors.toList());
        List<String> listString = Arrays.stream(s).map(String::valueOf).collect(Collectors.toList());
        a = new LinkedList<>();
        a.add(5);
        a.add(0, 10);
        a.add(1, 20);
        a.add(null);
        System.out.println("Linked list " + a);
//        System.out.println(a.stream().max(Comparator.comparing(Integer::valueOf)).get());
        List<String> vector = new Vector<>();
        vector.add("apple");
        vector.add("banana");
        vector.add(null);
        System.out.println("vector " + vector);
        Stack<String> stack = new Stack<>();
        stack.push("apple");
        stack.push("banana");
        stack.push(null);
        System.out.println("Stack " + stack);
        String top = stack.pop(); // Removes and returns the top element
        stack.peek();
        System.out.println(top);
        System.out.println(stack.pop());
//        System.out.println(stack.pop()); class EmptyStackException
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add("apple");
        copyOnWriteArrayList.add("banana");
        System.out.println(copyOnWriteArrayList);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(1);
        set.add(null);
        set.add(6);
        set.add(1);
        set.add(8);
        set.add(null);
        set.add(1);
        set.add(1);
        System.out.println("HashSet " + set);
        set = new LinkedHashSet<>();
        set.add(1);
        set.add(4);
        set.add(1);
        set.add(null);
        set.add(6);
        set.add(1);
        set.add(8);
        set.add(null);
        set.add(1);
        set.add(1);
        System.out.println("LinkedHashSet " + set);
        set = new TreeSet<>();
        set.add(1);
        set.add(4);
        set.add(1);
//        set.add(null);
        set.add(6);
        set.add(1);
        set.add(8);
//        set.add(null);
        set.add(1);
        set.add(1);
        System.out.println("Tree Set " + set);
        Set<Color> enumSet = EnumSet.of(Color.RED, Color.BLUE);
        enumSet.add(Color.GREEN);
//        enumSet.add(null);
        System.out.println("EnumSet " + enumSet);

        // get distinct record without set
        int[] ax = {1,5,6,6,7,9,9,4,2,1,3,5,7,8,0,9};
        Arrays.stream(ax).mapToObj(Integer::valueOf).collect(Collectors.toList())
                .stream().distinct().sorted().forEach(ix -> System.out.print(ix + " "));
        List<String> l1 = new ArrayList<>();
        l1.add("Shreyas");
        l1.add("Dhavali");
        l1.add("John");
        l1.add("Jimmy");
        l1.add("Rakesh");

        List<String> l2 = new ArrayList<>();
        l2.add("Dhav");
        l2.add("Rakesh");
        l2.add("John");
        l2.add("Jimy");
        l2.add("Shreyas");

        System.out.println(l2.contains("Rakesh"));
        l2.clear();
        System.out.println(l2);

/*
numbers.clear(); // Removes all elements
boolean contains20 = numbers.contains(20);
numbers.add(1, 15); // Adds 15 at index 1
numbers.remove(Integer.valueOf(15)); // Removes the first occurrence of 15
Integer[] array = {1, 2, 3};
List<Integer> listFromArray = Arrays.asList(array);
Collections.reverse(numbers);
List<Integer> sublist = numbers.subList(1, 3); // Sublist from index 1 to 2
numbers.removeAll(Collections.singletonList(20)); // Removes all 20s
numbers.retainAll(Arrays.asList(10, 15)); // Retains only 10 and 15
int min = Collections.min(numbers);
int max = Collections.max(numbers);
List<Integer> synchronizedList = Collections.synchronizedList(numbers);
Collections.fill(numbers, 0); // Fills the list with 0
List<Integer> unmodifiable = Collections.unmodifiableList(numbers);
numbers.removeIf(n -> n % 2 == 0); // Removes even numbers
List<String> strings = Arrays.asList("apple", "banana", "orange");
strings.sort(Comparator.comparingInt(String::length));
Map<Boolean, Set<Integer>> partitioned = numbers.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0,
                                       Collectors.toSet()));
int sum = numbers.stream().mapToInt(Integer::intValue).sum();
OptionalDouble average = numbers.stream().mapToInt(Integer::intValue).average();
String setAsString = numbers.stream()
    .map(Object::toString)
    .collect(Collectors.joining(", "));

Maps
boolean hasScore80 = scores.containsValue(80);
scores.entrySet().stream()
    .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
Map<String, Integer> updatedScores = scores.entrySet().stream()
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        entry -> entry.getValue() + 5
    ));

 Map<String, Integer> highScores = scores.entrySet().stream()
    .filter(entry -> entry.getValue() > 80)
    .collect(Collectors.toMap(
        Map.Entry::getKey,
        Map.Entry::getValue
    ));
Set<String> keys = scores.keySet();
Collection<Integer> values = scores.values();
List<Person> people = ...; // List of Person objects
Map<String, List<Person>> peopleByCity = people.stream()
    .collect(Collectors.groupingBy(Person::getCity));

scores.compute("Alice", (key, value) -> value + 10); // Updates Alice's score
double averageScore = scores.values().stream().mapToInt(Integer::intValue).average().orElse(0);






 */

    }
}

