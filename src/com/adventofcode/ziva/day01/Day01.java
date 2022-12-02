package com.adventofcode.ziva.day01;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01 {
    public static void main(String[] args) {
        PriorityQueue<Integer> calories  = new PriorityQueue<>(Comparator.reverseOrder());
        try {
            // Read file
            File file = new File("C:\\Users\\zival\\IdeaProjects\\adventofcode\\src\\com\\adventofcode\\ziva\\day01\\input.txt");
            Scanner sc = new Scanner(file);

            // Calculate calories each elf carries
            Integer num = 0;
            while(sc.hasNextLine()){
                String currentLine = sc.nextLine();
                if(currentLine.isEmpty()){
                    calories.add(num);
                    num = 0;
                    continue;
                }
                num += Integer.parseInt(currentLine);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Get top three
        Integer sum = 0;
        for(int i = 0; i < 3; i ++){
            sum += calories.poll();
        }
        System.out.print(sum);
    }
}
