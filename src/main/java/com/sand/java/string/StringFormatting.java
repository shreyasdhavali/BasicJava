package com.sand.java.string;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Formatter;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringFormatting {

    public StringFormatting() {
    }
    public static void main(String[] args) throws IOException {
        StringJoiner sj = new StringJoiner(",");
        sj.add("Hello");
        sj.add("Hii");
        sj.add("How");
        sj.add("you");
        sj.add("Doing?");
        sj.setEmptyValue("EMPTY");
        System.out.println(sj);//Hello,Hii,How,you,Doing?
        StringJoiner sj1 = new StringJoiner(",", "{", "]");
        sj1.add("Hello");
        sj1.add("Hii");
        sj1.add("How");
        sj1.add("you");
        sj1.add("Doing?");
        System.out.println(sj1);//{Hello,Hii,How,you,Doing?]

        int a = 10;
        int b = 20;
        int c = 30;
        int d = 40;
        System.out.println(String.format("My nephews are %d, %d, %d and %d years old", a, b, c, d));
        System.out.printf("My nephews are %d, %d, %d and %d years old", a, b, c, d);
        double avg = (a+b+c+d)/4d;
        System.out.println("\n" +String.format("My average is %.4f", avg)); //My average is 25.0000
        System.out.println(String.format("A:%d B: %d", a, b));      //A:10 B: 20
        System.out.println(String.format("A:%4d B: %4d", a, b));    //A:  10 B:   20
        System.out.println(String.format("A:%05d B: %05d", a, b));  //A:00010 B: 00020
        System.out.println(String.format("A:%-5d B: %-5d", a, b));  //A:10    B: 20
        System.out.println(String.format("A:%,d B: %,d", 1000000, 12345678));  //A:1,000,000 B: 12,345,678
        System.out.println(String.format("A:%.2f B: %.2f", 1000000f, 12345678f));  //A:1000000.00 B: 12345678.00
        System.out.println(String.format("A:%,.3f B: %,.3f", 1000000.0, 12345678.0));  //A:1,000,000.000 B: 12,345,678.000
        System.out.println(String.format("A:%05d B: %05d", 1000000, 12345678));  //A:1,000,000 B: 12,345,678

        System.out.println(String.format("%d", 123));    //123
        System.out.println(String.format("%d", -123));   //-123
        System.out.println(String.format("% d", 123));   // 123
        System.out.println(String.format("% d", -123));  //-123
        System.out.println(String.format("%+d", 123));   //+123
        System.out.println(String.format("%+d", -123));  //-123
        System.out.println(String.format("%(d", 123));   //123
        System.out.println(String.format("%(d", -123));  //(123)

        System.out.println(String.format("%d, %d, %d", a,b,c));         // 10, 20, 30
        System.out.println(String.format("%3$d, %1$d, %2$d", a,b,c));   // 30, 10, 20
        System.out.println(String.format("%3$d, %<05d, %1$d", a,b,c));   // 30, 00030, 10
        Formatter formatter = new Formatter(Files.newBufferedWriter(Paths.get("myFile.txt")));

        // reverse string
        reverseString("Shreyas");

        // print charset
        System.out.println("List of available character sets: ");
        for (String str : Charset.availableCharsets().keySet()) {
            System.out.println(str);
        }

        // ASCII value of characters to integers
        System.out.println((int)'a');

        // Multiple copies
        System.out.print("3.0");
        Collections.nCopies(3, "3.0").forEach(System.out::print);

        System.out.println("\ngetEnv " + System.getenv());
        System.out.println("getProperties " + System.getProperties());
        System.out.println("security manager " + System.getSecurityManager());
        System.out.println("path " + System.getenv("PATH"));
        System.out.println("temp " + System.getenv("TEMP"));
        System.out.println("username " + System.getenv("USERNAME"));
        System.out.println("\nJava Version: "+System.getProperty("java.version"));
        System.out.println("Java Runtime Version: "+System.getProperty("java.runtime.version"));
        System.out.println("Java Home: "+System.getProperty("java.home"));
        System.out.println("Java Vendor: "+System.getProperty("java.vendor"));
        System.out.println("Java Vendor URL: "+System.getProperty("java.vendor.url"));
        System.out.println("Java Class Path: "+System.getProperty("java.class.path")+"\n");

    }

    private static void reverseString(String str) {
        String[] c = str.split("");
        for (int i = c.length-1; i>=0; i--) {
            System.out.print(c[i]);
        }
    }

    public static void count(String x){
        char[] ch = x.toCharArray();
        int letter = 0;
        int space = 0;
        int num = 0;
        int other = 0;
        for(int i = 0; i < x.length(); i++){
            if(Character.isLetter(ch[i])){
                letter ++ ;
            }
            else if(Character.isDigit(ch[i])){
                num ++ ;
            }
            else if(Character.isSpaceChar(ch[i])){
                space ++ ;
            }
            else{
                other ++;
            }
        }
        System.out.println("The string is : Aa kiu, I swd skieo 236587. GH kiu: sieo?? 25.33");
        System.out.println("letter: " + letter);
        System.out.println("space: " + space);
        System.out.println("number: " + num);
        System.out.println("other: " + other);
    }
}
