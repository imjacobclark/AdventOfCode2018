package xyz.jacobclark;

import xyz.jacobclark.day1.ReoccurringFrequency;
import xyz.jacobclark.day1.ResultingFrequency;
import xyz.jacobclark.day2.Boxes;
import xyz.jacobclark.day2.Box;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> frequencies = Files.readAllLines(Paths.get("./src/main/resources/day1/input.txt"));

        System.out.println("Day 1 part 1");
        System.out.println(new ResultingFrequency(frequencies).calculateResultingFrequency());

        System.out.println("Day 1 part 2");
        System.out.println(new ReoccurringFrequency(frequencies).getFirstReoccurringFrequency());

        List<Box> boxes = Files
                .readAllLines(Paths.get("./src/main/resources/day2/input.txt"))
                .stream()
                .map(id -> new Box(id))
                .collect(toList());

        System.out.println("Day 2 part 1");
        System.out.println(new Boxes(boxes).checksum());

        System.out.println("Day 2 part 2");
        System.out.println(new Boxes(boxes).findFabricBox().getId());

    }
}
