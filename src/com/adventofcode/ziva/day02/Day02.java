package com.adventofcode.ziva.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02 {
    public static void main(String[] args) {
        Integer score = 0;
        try {
            // Read file
            File file = new File("C:\\Users\\zival\\IdeaProjects\\adventofcode\\src\\com\\adventofcode\\ziva\\day02\\input.txt");
            Scanner sc = new Scanner(file);

            // Calculate score part 1
            while(sc.hasNextLine()) {
                String currentLine = sc.nextLine();
                String[] arr = currentLine.split(" ");

                // Shape score
                switch (arr[1]) {
                    case "X" -> score += 1;
                    case "Y" -> score += 2;
                    case "Z" -> score += 3;
                }

                // Win / Draw score
                if ((arr[0].equals("A") && arr[1].equals("Y")) || (arr[0].equals("B") && arr[1].equals("Z")) || (arr[0].equals("C") && arr[1].equals("X"))) {
                    score += 6;
                } else if ((arr[0].equals("A") && arr[1].equals("X")) || (arr[0].equals("B") && arr[1].equals("Y")) || (arr[0].equals("C") && arr[1].equals("Z"))) {
                    score += 3;
                }
            }

//            // Calculate score part 2
//            while(sc.hasNextLine()){
//                String currentLine = sc.nextLine();
//                String[] arr = currentLine.split(" ");
//
//                switch (arr[1]) {
//                    case "X":   // Lose
//                        // Shape score
//                        if (arr[0].equals("A")) {
//                            score += 3;  // you use scissors
//                        } else if (arr[0].equals("B")) {
//                            score += 1;  // you use rock
//                        } else if (arr[0].equals("C")) {
//                            score += 2;  // you use paper
//                        }
//                        break;
//                    case "Y":   // Draw
//                        score += 3;
//                        // Shape score
//                        if (arr[0].equals("A")) {
//                            score += 1;
//                        } else if (arr[0].equals("B")) {
//                            score += 2;
//                        } else if (arr[0].equals("C")) {
//                            score += 3;
//                        }
//                        break;
//                    case "Z":   // Win
//                        score += 6;
//                        // Shape score
//                        if (arr[0].equals("A")) {
//                            score += 2;  // you use paper
//                        } else if (arr[0].equals("B")) {
//                            score += 3;  // you use scissors
//                        } else if (arr[0].equals("C")) {
//                            score += 1;  // you use rock
//                        }
//                        break;
//                }
//            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(score);
    }
}
