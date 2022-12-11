package com.adventofcode.ziva.day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day08 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        try {
            // Read file
            File file = new File("/Users/zli10/IdeaProjects/AdventOfCode-2022/src/com/adventofcode/ziva/day08/input.txt");
            Scanner sc = new Scanner(file);

            // Convert to matrix
            while(sc.hasNextLine()){
                ArrayList<Integer> current = new ArrayList<>();
                String currentLine = sc.nextLine();

                for(int i = 0; i < currentLine.length(); i++){
                    current.add(Character.getNumericValue(currentLine.charAt(i)));
                }
                matrix.add(current);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // part 1
        int[][] canSee = new int[matrix.size()][matrix.get(0).size()];
        int see = 0;

        // Top Left
        int[] topMax = new int[matrix.get(0).size()];
        for(int i = 0; i < matrix.size(); i++){
            int leftMax = Integer.MIN_VALUE;
            for(int j = 0; j < matrix.get(0).size(); j++){
                int n = matrix.get(i).get(j);
                if(i == 0 || j == 0 || i == matrix.size() - 1 || j == matrix.size() - 1){
                    canSee[i][j] = 1;
                }
                else if(n > topMax[j] || n > leftMax){
                        canSee[i][j] = 1;
                }
                topMax[j] = Math.max(n, topMax[j]);
                leftMax = Math.max(n, leftMax);
            }
        }

        // Bottom Right
        int[] bottomMax = new int[matrix.get(0).size()];
        for(int i = matrix.size() - 1; i >= 0; i--){
            int rightMax = Integer.MIN_VALUE;
            for(int j = matrix.get(0).size() - 1; j >= 0; j--){
                int n = matrix.get(i).get(j);
                if(i == 0 || j == 0 || i == matrix.size() - 1 || j == matrix.size() - 1){
                    canSee[i][j] = 1;
                }
                else if(n > bottomMax[j] || n > rightMax){
                        canSee[i][j] = 1;
                }

                bottomMax[j] = Math.max(n, bottomMax[j]);
                rightMax = Math.max(n, rightMax);
            }
        }

        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(0).size(); j++){
                if(canSee[i][j] == 1){
                    see ++;
                }
            }
        }
        System.out.print(see);
    }
}
