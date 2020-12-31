package exercise.chapter1.section3;

import exercise.chapter1.Deque;

// 双向队列实现2个栈
public class Exercise48_DoubleStack {
    public static void main(String[] args) {
        int N = 20;
        if (args.length > 1) {
            N = Integer.parseInt(args[1]);
        }
        DoubleStack<Integer> ds = new DoubleStack<>();
        for (int i = 0; i < N; i++) {
            ds.upPush(i);
        }
    }

    public static class DoubleStack<E> {
        private Deque<E> deque;
        private int upN = 0; // up stack
        private int botN = 0; // bottom stack

        public DoubleStack() {
            deque = new Deque<>();
        }

        //
        public boolean upIsEmpty() {
            return upN == 0;
        }

        public int upSize() {
            return upN;
        }

        public void upPush(E v) {
            deque.pushLeft(v);
            upN++;
        }

        public E upPeek() {
            return deque.first();
        }

        public E upPop() {
            upN--;
            return deque.popLeft();
        }

        //
        public boolean botIsEmpty() {
            return botN == 0;
        }

        public int botSize() {
            return botN;
        }

        public void botPush(E v) {
            deque.pushRight(v);
            botN++;
        }

        public E botPeek() {
            return deque.last();
        }

        public E botPop() {
            botN--;
            return deque.popRight();
        }
    }
}
