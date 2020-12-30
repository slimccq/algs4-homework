package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

// 递归打印文件夹
public class Exercise43_ListFile {
    private static final String TAB = "-";

    public static void main(String[] args) {
        String folder = ".";
        if (args.length > 1) {
            folder = args[1].trim();
        }
        File file = new File(folder);
        listFileDir(file, 0);
    }

    public static void listFileDir(File file, int depth) {
        if (file.isFile()) {
            String space = "";
            if (depth > 1) {
                space = TAB.repeat(depth);
            }
            StdOut.printf("%s%s\n", space, file.getName());
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                listFileDir(f, depth+1);
            }
        }
    }
}
