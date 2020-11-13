package com.example.chapter1;

public class LinkedNode<E>
{
    E item;
    LinkedNode<E> next;
    LinkedNode<E> prev;

    public LinkedNode(LinkedNode<E> prev, E element, LinkedNode<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }

    public void linkAfter(LinkedNode<E> node) {
        node.next = this.next;
        if (this.next != null) {
            this.next.prev = node;
        }
        this.next = node;
        node.prev = this;
    }

    public void linkBefore(LinkedNode<E> node) {
        node.prev = this.prev;
        if (this.prev != null) {
            this.prev.next = node;
        }
        this.prev = node;
        node.next = this;
    }

    public void unlink()
    {
        if (this.prev != null) {
            this.prev.next = this.next;
        }
        if (this.next != null) {
            this.next.prev = this.prev;
        }
        this.prev = null;
        this.next = null;
        this.item = null;
    }

    public void linkCircle(LinkedNode<E> last) {
        this.prev = last;
        last.next = this;
    }
}
