package exercise.chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import exercise.chapter1.Buffer;

// 文本缓冲区
public class Exercise44_EditBuffer {
    public static void main(String[] args)
    {
        Buffer buffer = new Buffer();
        String s1 = "a quick fox";
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            buffer.insert(ch);
        }
        buffer.left(3);
        buffer.delete();
        buffer.left(5);
        buffer.delete();
        buffer.right(8);
        s1 = "jumps over the lazy dog";
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            buffer.insert(ch);
        }
        buffer.left(10);
        StdOut.println(buffer.toString());
    }
}
