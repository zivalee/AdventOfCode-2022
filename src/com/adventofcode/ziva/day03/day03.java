package com.adventofcode.ziva.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class day03 {
    public static void main(String[] args) {
        Integer sum = 0;
        try {
            // Read file
            File file = new File("C:\\Users\\zival\\IdeaProjects\\adventofcode\\src\\com\\adventofcode\\ziva\\day03\\input.txt");
            Scanner sc = new Scanner(file);

            // Calculate sum part 1
            while(sc.hasNextLine()){
                String currentLine = sc.nextLine();
                HashSet<Character> set = new HashSet<>();
                for(int i = 0; i < currentLine.length() / 2; i++){
                    set.add(currentLine.charAt(i));
                }

                for(int i = currentLine.length() / 2; i < currentLine.length(); i++){
                    if(set.contains(currentLine.charAt(i))){
                        if(Character.isUpperCase(currentLine.charAt(i))){
                            sum += currentLine.charAt(i) - 'A' + 27;
                        }
                        else{
                            sum += currentLine.charAt(i) - 'a' + 1;
                        }
                        break;
                    }
                }
            }

//            // Caculate sum part 2
//            int lineNum = 0;
//            HashSet<Character> set = new HashSet<>();
//
//            while(sc.hasNextLine()){
//                String currentLine = sc.nextLine();
//
//                if(lineNum % 3 == 0){
//                    set.clear();
//                    for(int i = 0; i < currentLine.length(); i++){
//                        set.add(currentLine.charAt(i));
//                    }
//                }
//                else{
//                    // Create new set and add only same character into it
//                    HashSet<Character> setSame = new HashSet<>();
//                    for(int i = 0; i < currentLine.length(); i++){
//                        if(set.contains(currentLine.charAt(i))){
//                            setSame.add(currentLine.charAt(i));
//                        }
//                    }
//                    // Replace old set with new set
//                    set = setSame;
//                }
//
//                if(lineNum % 3 == 2){
//                    Character same = set.iterator().next();
//                    if(Character.isUpperCase(same)){
//                        sum += same - 'A' + 27;
//                    }
//                    else{
//                        sum += same - 'a' + 1;
//                    }
//                }
//                lineNum ++;
//            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
    }
}
