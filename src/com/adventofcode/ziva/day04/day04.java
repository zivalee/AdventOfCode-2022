package com.adventofcode.ziva.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day04 {
    public static void main(String[] args) {
        Integer duplicate = 0;
        try {
            // Read file
            File file = new File("C:\\Users\\zival\\IdeaProjects\\adventofcode\\src\\com\\adventofcode\\ziva\\day04\\input.txt");
            Scanner sc = new Scanner(file);

            // Calculate number of duplicated pairs
            while(sc.hasNextLine()){
                String currentLine = sc.nextLine();
                String[] pairs = currentLine.split(",");
                String[] first = pairs[0].split("-");
                String[] second = pairs[1].split("-");
                int a = Integer.parseInt(first[0]);
                int b = Integer.parseInt(first[1]);
                int x = Integer.parseInt(second[0]);
                int y = Integer.parseInt(second[1]);

                // part 1
                if((a <= x && b >= y) || (x <= a && y >= b)){
                    duplicate ++;
                }

//                // part 2
//                if(a <= x){
//                    if(b >= x){
//                        duplicate++;
//                    }
//                }
//                else{
//                    if(a <= y){
//                        duplicate++;
//                    }
//                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println(duplicate);
    }
}
