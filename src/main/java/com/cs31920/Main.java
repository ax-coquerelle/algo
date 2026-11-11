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
        ArrayList<String> Map = new ArrayList<>();
        try {
            // Create a BufferedReader to read input from the console
            BufferedReader r = new BufferedReader(
            new InputStreamReader(System.in));
            String input = r.readLine();
            File f = new File(input);
            System.out.println("File exists: " + f.exists());
            
            Scanner sc = new Scanner(f);

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Map.add(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }

      System.out.println("Map contents:");
      for (String line : Map) {
          System.out.println(line);
      }

    }
}