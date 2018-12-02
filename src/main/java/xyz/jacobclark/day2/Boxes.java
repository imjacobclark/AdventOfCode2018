package xyz.jacobclark.day2;

import java.util.*;

public class Boxes {
    List<Box> boxes = new ArrayList<>();
    private int twoLetterChecksumPart = 0;
    private int threeLetterChecksumPart = 0;

    public Boxes(List<Box> boxes) {
        this.boxes = boxes;
    }


    public int checksum() {
        boxes.stream().forEach(box -> {
            Map<String, Integer> letterCounts = countLetterOccurrences(box);

            final long moreThanTwoLetterCount = letterCounts.values().stream().filter(letterCount -> letterCount == 2).count();
            final long moreThanThreeLetterCount = letterCounts.values().stream().filter(letterCount -> letterCount == 3).count();

            if(moreThanTwoLetterCount > 0) this.twoLetterChecksumPart += 1;
            if(moreThanThreeLetterCount > 0) this.threeLetterChecksumPart += 1;
        });

        return this.twoLetterChecksumPart * this.threeLetterChecksumPart;
    }

    private Map<String, Integer> countLetterOccurrences(Box box) {
        Map<String, Integer> letterCounts = new HashMap<>();

        Arrays.asList(box.getId().split("")).forEach(letter -> {
            if(letterCounts.get(letter) == null){
                letterCounts.put(letter, 0);
            }

            letterCounts.put(letter, letterCounts.get(letter) + 1);
        });

        return letterCounts;
    }
}
