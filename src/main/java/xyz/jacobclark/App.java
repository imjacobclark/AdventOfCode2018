package xyz.jacobclark;

import xyz.jacobclark.day1.ResultingFrequency;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> frequencies = Files.readAllLines(Paths.get("./src/main/resources/day1/input.txt"));
        System.out.println(new ResultingFrequency(frequencies).calculateResultingFrequency());
    }
}
