package com.sand.java.FileInputOutputStreams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class HugeFileReading {

    public static void main(String[] args) {
//        always from source
        String filename = "C:\\CodePracticing\\SampleData\\";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
//            br.lines().sorted().collect(Collectors.toSet());
            List<String> lines = Files.readAllLines(Paths.get("C:\\CodePracticing\\SampleData\\Student_original.csv"));
            Random random1 = new Random();
            lines = lines.stream().map(i -> {
                StringJoiner j = new StringJoiner(",");
                j.add("STDN" + i.split(",")[0].replaceAll(".*", String.valueOf(random1.nextInt(1000000000))));
                j.add(i.substring(i.indexOf(",")));
                return j.toString();
            }).collect(Collectors.toList());

            Files.write(Paths.get("C:\\CodePracticing\\SampleData\\Student_original.csv"), lines);
            //Buffer reader .lines will give you stream so directly apply sorted
            String line;
            while ((line = br.readLine()) != null) {

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
