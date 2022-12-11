package com.adventofcode.ziva.day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day10 {
    public static void main(String[] args) {
        // Part 1
//        int cycle = 0;
//        int x = 1;
//        int sum = 0;
//        int n = 20;
//
//        try {
//            // Read file
//            File file = new File("/Users/zli10/IdeaProjects/AdventOfCode-2022/src/com/adventofcode/ziva/day10/input.txt");
//            Scanner sc = new Scanner(file);
//
//            while(sc.hasNextLine()){
//                String currentLine = sc.nextLine();
//                cycle++; // Read
//                if(cycle == n){
//                    sum += cycle * x;
//                    n += 40;
//                }
//
//                if(currentLine.contains("addx")){
//                    cycle++;
//                    if(cycle == n){
//                        sum += cycle * x;
//                        n += 40;
//                    }
//                    x += Integer.parseInt(currentLine.split(" ")[1]);
//                }
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.print(sum);

        // Part 2
        int cycle = 0;
        int x = 1;

        try {
            // Read file
            File file = new File("/Users/zli10/IdeaProjects/AdventOfCode-2022/src/com/adventofcode/ziva/day10/input.txt");
            Scanner sc = new Scanner(file);

            while(sc.hasNextLine()){
                String currentLine = sc.nextLine();
                cycle++; // Read

                if((cycle % 40 == 0 && x <= 40 && 40 <= x + 2) || (cycle % 40 != 0 && x <= cycle % 40 && cycle % 40 <= x + 2)){
                    System.out.print("#");
                }
                else{
                    System.out.print(".");
                }
                if(cycle % 40 == 0){
                    System.out.print("\n");
                }

                if(currentLine.contains("addx")){
                    cycle++;
                    if((cycle % 40 == 0 && x <= 40 && 40 <= x + 2) || (cycle % 40 != 0 && x <= cycle % 40 && cycle % 40 <= x + 2)){
                        System.out.print("#");
                    }
                    else{
                        System.out.print(".");
                    }
                    if(cycle % 40 == 0){
                        System.out.print("\n");
                    }
                    x += Integer.parseInt(currentLine.split(" ")[1]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
