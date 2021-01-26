package exercise.common;

import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utility {

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object obj) {
        return (T) obj;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i % 10 == 0) {
                StdOut.println();
            }
            StdOut.printf("%2d, ", arr[i]);
        }
        StdOut.println();
    }

    public static void printArray(Number[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                break;
            }
            if (i > 0 && i % 10 == 0) {
                StdOut.println();
            }
            StdOut.printf("%2d, ", arr[i]);
        }
        StdOut.println();
    }

    public static void printArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && i % 10 == 0) {
                StdOut.println();
            }
            StdOut.printf("%.2f, ", arr[i]);
        }
        StdOut.println();
    }

    public static ArrayList<String> readFileLines(String filepath) {
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line.trim());
            }
        } catch(IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return lines;
    }

    public static int[] readIntLines(String filepath)
    {
        ArrayList<Integer> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Integer n = Integer.parseInt(line.trim());
                lines.add(n);
            }
        } catch(IOException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        int[] arr = new int[lines.size()];
        for (int i = 0; i < lines.size(); i++) {
            arr[i] = lines.get(i);
        }
        return arr;
    }
}
