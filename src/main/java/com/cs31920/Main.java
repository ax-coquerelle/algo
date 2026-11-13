package com.cs31920;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Get input from console, store relevant file in map.
        ArrayList<String> map = getInput();
        // Further processing can be done here.
        // First line is the dimensions of the map.
        // x,y,demand.
        int dimensions = Integer.parseInt(map.get(0))*2+1;

        int[][] mapArray = new int[dimensions][dimensions];
          for(int x = 0; x < dimensions; x++) {
                    if (x%2 == 1) {
                    for(int y = 0; y < dimensions; y++) {
                        if(y%2 == 0) {
                            mapArray[x][y] = 9;
                        }
                    }
                }
         }
        for (int i = 1; i < map.size(); i++) {
            String[] line = map.get(i).split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int demand = Integer.parseInt(line[2]);

            // Ensure the coordinates are valid, and withion the bounds 
            if(x%2 == y%2 &&
             x < dimensions &&
             y < dimensions &&
             x >= 0 && y >= 0) {
                mapArray[x][y] = demand;
            }
        }

          printMap(mapArray);
    }
    public static ArrayList<String> getInput() {

        // INPUT FILE READING
        ArrayList<String> Map = new ArrayList<>();
        try {
            // Create a BufferedReader to read input from the console
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            String input = r.readLine();
            File f = new File(input);
            System.out.println("File exists: " + f.exists());
            Scanner sc = new Scanner(f);

            // Read each line from the file and add it to the ArrayList used to build the map
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Map.add(line);
            }
          

            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + "oopsies can't find the fiwe :3333");
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
        return Map;
    }

    // Function to print the map in as a grid#
    // non existing nodes still exist but are represented as 9s
    public static void printMap(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}