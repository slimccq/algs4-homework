package exercise.chapter1.section2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

// 计算Point2D之间的距离
public class Exercise1_Point2D {
    public static void main(String[] args) {
        int N = 10;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        Point2D[] points = new Point2D[N];
        createAndDrawPoints(points);
        Point2D[] line = new Point2D[2];
        double minDistance = findShortestDistance(points, line);
        StdDraw.line(line[0].x(), line[0].y(), line[1].x(), line[1].y());
        StdOut.printf("min distance is %.3f\n", minDistance);
    }

    private static void createAndDrawPoints(Point2D[] points) {
        StdDraw.setCanvasSize(800, 600);
        StdDraw.setPenRadius(0.005);
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
        for (int i = 0; i < points.length; i++) {
            double ptX = StdRandom.uniform();
            double ptY = StdRandom.uniform();
            StdDraw.point(ptX, ptY);
            points[i] = new Point2D(ptX, ptY);
        }
    }

    private static double findShortestDistance(Point2D[] points, Point2D[] line) {
        double shortest = Double.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = points[i].distanceTo(points[i]);
                if (dist < shortest) {
                    shortest = dist;
                    line[0] = points[j];
                    line[1] = points[i];
                }
            }

        }
        return shortest;
    }
}