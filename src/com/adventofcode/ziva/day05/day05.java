package com.adventofcode.ziva.day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day05 {
    public static void main(String[] args) {
        // Original State
        ArrayList<ArrayList> total = new ArrayList<>();
        total.add(new ArrayList<>(Arrays.asList('B', 'G', 'S', 'C')));
        total.add(new ArrayList<>(Arrays.asList('T', 'M', 'W', 'H', 'J', 'N', 'V', 'G')));
        total.add(new ArrayList<>(Arrays.asList('M', 'Q', 'S')));
        total.add(new ArrayList<>(Arrays.asList('B', 'S', 'L', 'T', 'W', 'N', 'M')));
        total.add(new ArrayList<>(Arrays.asList('J', 'Z', 'F', 'T', 'V', 'G', 'W', 'P')));
        total.add(new ArrayList<>(Arrays.asList('C', 'T', 'B', 'G', 'Q', 'H', 'S')));
        total.add(new ArrayList<>(Arrays.asList('T', 'J', 'P', 'B', 'W')));
        total.add(new ArrayList<>(Arrays.asList('G', 'D', 'C', 'Z', 'F', 'T', 'Q', 'M')));
        total.add(new ArrayList<>(Arrays.asList('N', 'S', 'H', 'B', 'P', 'F')));
        try {
            // Read file
            File file = new File("/Users/zli10/IdeaProjects/AdventOfCode-2022/src/com/adventofcode/ziva/day05/input.txt");
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){
                // Read instructions
                String currentLine = sc.nextLine();
                Matcher m = Pattern.compile("\\d{1,2}").matcher(currentLine);
                List<Integer> numbers = new ArrayList<>();
                while(m.find()) {
                    numbers.add(Integer.parseInt(m.group()));
                }

                // Move items
                int num = numbers.get(0);
                List<Character> origin = total.get(numbers.get(1) - 1);
                List<Character> destination = total.get(numbers.get(2) - 1);

                // Add to destination
                List<Character> todo = origin.subList(origin.size() - num, origin.size());
                destination.addAll(todo);

                // Remove from origin
                for(int i = 0; i < num; i++){
                    origin.remove(origin.size() - 1);
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (ArrayList arrayList : total) {
            int lastIdx = arrayList.size() - 1;
            System.out.print(arrayList.get(lastIdx));
        }
    }
}
