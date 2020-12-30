package exercise.chapter1;


// 文本缓冲区
public class Buffer {
    private ArrayStack<Character> left;
    private ArrayStack<Character> right;

    public Buffer() {
        left = new ArrayStack<>();
        right = new ArrayStack<>();
    }

    public int size() {
        return left.size() + right.size();
    }

    // 插入字符到光标
    public void insert(char c) {
        left.push(c);
    }

    // 删除光标字符
    public char delete() {
        if (!left.isEmpty()) {
            return left.pop();
        }
        return 0;
    }

    // 光标左移k个字符
    public void left(int k) {
        while(k-- > 0 && !left.isEmpty()) {
            char c = left.pop();
            right.push(c);
        }
    }

    // 光标右移k个字符
    public void right(int k) {
        while(k-- > 0 && !right.isEmpty()) {
            char c = right.pop();
            left.push(c);
        }
    }

    public String toString() {
        String rightS = "";
        if (!right.isEmpty()) {
            // 右边的栈需要先反转
            StringBuilder sb = new StringBuilder(right.toString());
            rightS = sb.reverse().toString();
        }
        return left.toString() + rightS;
    }
}
