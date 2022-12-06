package com.adventofcode.ziva.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class day06 {
    public static void main(String[] args) {
        int start = 0;
        try {
            // Read file
            File file = new File("/Users/zli10/IdeaProjects/AdventOfCode-2022/src/com/adventofcode/ziva/day06/input.txt");
            Scanner sc = new Scanner(file);

            // Calculate calories each elf carries
            String input = sc.nextLine();
            while(start != input.length() - 14){
                HashMap<Character, Integer> map = new HashMap<>();
                for(int i = start; i < start + 14; i++){
                    Character current = input.charAt(i);
                    if(map.containsKey(current)){
                        start = map.get(current);
                        break;
                    }
                    map.put(current, i);
                }
                if(map.size() == 14){
                    break;
                }
                start ++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Get top three
        System.out.print(start + 14);
    }
}
