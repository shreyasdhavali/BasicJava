package com.sand.java.FileInputOutputStreams;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InputOutputStreams {

    public static void main(String[] args) throws IOException {
        char[] buff = new char[26];
        int len;
//        try (Reader reader = Helper.openReader("file1.txt")) {
//            while ((len = reader.read(buff)) >= 0) {
//                System.out.println("length = " + len);
//                for (char i: buff) {
//                    System.out.print(i);
//                }
//            }
//
//            if (reader != null) {
//                reader.close();
//            }
//        } catch (IOException e) {
//            System.out.println(e.getClass().getSimpleName() + " - " + e.getMessage());
//        }
//        Formatter formatter = new Formatter(Files.newBufferedWriter(Paths.get("myFile.txt")));
//
//        try (BufferedReader br = new BufferedReader(new FileReader("src/com/shreyas/streams/file1.txt"))) {
//            char[] arr = new char[8];
//            BufferedReader brr = Files.newBufferedReader(Paths.get("from contentroot"));
//            while ((len = br.read(arr)) >= 0) {
//                System.out.println("lenght = " + len);
//                for (char i: arr) {
//                    System.out.print(i);
//                }
//            }
//            if (br != null) {
//                br.close();
//            }
//        } catch (IOException e) {
//
//        }
        File file = new File("file1.txt");
        System.out.println(new File("file1.txt").length());
        System.out.format("\nCurrent Date time: %tc%n\n", Instant.now().toEpochMilli());
        System.out.println("Now:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss.SSS")));
    }

}
