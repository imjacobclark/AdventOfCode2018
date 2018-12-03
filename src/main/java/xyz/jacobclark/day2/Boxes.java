package xyz.jacobclark.day2;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

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

            if (moreThanTwoLetterCount > 0) this.twoLetterChecksumPart += 1;
            if (moreThanThreeLetterCount > 0) this.threeLetterChecksumPart += 1;
        });

        return this.twoLetterChecksumPart * this.threeLetterChecksumPart;
    }

    public Box findFabricBox() {
        int numberOfboxIdsToCheck = this.boxes.size();
        List<String> matchedLetters = new ArrayList<>();
        List<String> missmatchedLetters = new ArrayList<>();

        if (numberOfboxIdsToCheck <= 1 || boxIdsAreNotAllOfSameLength()) {
            return null;
        }

        int idLength = getBoxIdLetters(0).length;

        int currentBoxIndex = 0;
        int currentBoxToCheckIndex = 1;

        while (true) {
            if (currentBoxIndex >= numberOfboxIdsToCheck) {
                return null;
            }

            String[] currentBoxLetters = getBoxIdLetters(currentBoxIndex);
            String[] currentBoxToCheckAgainstLetters = getBoxIdLetters(currentBoxToCheckIndex);

            for (int i = 0; i <= idLength - 1; i++) {
                boolean lettersAtPositionMatch = currentBoxLetters[i].equals(currentBoxToCheckAgainstLetters[i]);

                if (lettersAtPositionMatch) {
                    matchedLetters.add(currentBoxLetters[i]);
                } else {
                    missmatchedLetters.add(currentBoxLetters[i]);
                }
            }

            if (missmatchedLetters.size() == 1) {
                String fabricBoxId = getMatchedLettersAsString(matchedLetters).get();
                return new Box(fabricBoxId);
            }

            currentBoxToCheckIndex++;
            missmatchedLetters.clear();
            matchedLetters.clear();

            boolean shouldMoveOntoNextBox = currentBoxToCheckIndex == numberOfboxIdsToCheck;
            if (shouldMoveOntoNextBox) {
                currentBoxIndex++;
                currentBoxToCheckIndex = 0;
            }
        }
    }

    private Map<String, Integer> countLetterOccurrences(Box box) {
        Map<String, Integer> letterCounts = new HashMap<>();

        asList(box.getId().split("")).forEach(letter -> {
            if (letterCounts.get(letter) == null) {
                letterCounts.put(letter, 0);
            }

            letterCounts.put(letter, letterCounts.get(letter) + 1);
        });

        return letterCounts;
    }

    private String[] getBoxIdLetters(int currentBoxIndex) {
        return this.boxes.get(currentBoxIndex).getId().split("");
    }

    private Optional<String> getMatchedLettersAsString(List<String> matchedLetters) {
        return matchedLetters.stream().reduce((previous, next) -> previous.concat(next));
    }

    private boolean boxIdsAreNotAllOfSameLength() {
        String[] box1 = getBoxIdLetters(0);
        return this.boxes.stream().filter(box -> box.getId().split("").length != box1.length).collect(Collectors.toList()).size() != 0;
    }
}
