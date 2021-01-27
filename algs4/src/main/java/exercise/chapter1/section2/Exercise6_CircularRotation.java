package exercise.chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

// 回环变位字符串
public class Exercise6_CircularRotation {
    public static void main(String[] args)
    {
        String s1 = "ACTGACC";
        String s2 = "TGACCAC";
        if (args.length > 2) {
            s1 = args[1].trim();
            s2 = args[2].trim();
        }
        boolean f = isCircularRotation(s1, s2);
        StdOut.printf("%s and %s %s circular rotation\n", s1, s2, f ? "is" : "is not");
    }

    // 连接2个字符串s把环展开
    public static boolean isCircularRotation(String s1, String s2)
    {
        if (s1.length() == s2.length()) {
            return s1.concat(s1).indexOf(s2) >= 0;
        }
        return false;
    }
}