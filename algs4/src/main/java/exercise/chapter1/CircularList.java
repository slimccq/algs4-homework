package exercise.chapter1;


// 循环链表
public class CircularList {
    // first dummy node
    public ListNode first = null;
    public ListNode last = null;

    public CircularList() {
        last = first;
    }

    public int size() {
        int n = 0;
        ListNode node = first;
        while(node != null) {
            node = node.next;
            n++;
        }
        return n;
    }

    // 插入节点到尾部
    public void insertTail(ListNode node)
    {
        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }
        node.next = first;
        last = node;
    }

    // 插入节点到头部
    public void insertHead(ListNode node) {
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.next = first;
        }
        last.next = node;
        first = node;
    }

    // 删除头节点
    public ListNode removeHead() {
        if (first == null) {
            return null;
        }
        ListNode node = first;
        first = node.next;
        return node;
    }

    // 删除尾节点
    public ListNode removeTail() {
        if (last == null) {
            return null;
        }
        ListNode prev = first;
        while (prev.next != last) {
            prev = prev.next;
        }
        prev.next = first;
        ListNode node = last;
        last = prev;
        return node;
    }

    public static class ListNode {
        public ListNode next = null;
        public Object value;

        public ListNode(Object value) {
            this.value = value;
        }
    }
}