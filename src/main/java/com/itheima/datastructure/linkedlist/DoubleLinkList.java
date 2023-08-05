package com.itheima.datastructure.linkedlist;

import java.util.Iterator;

public class DoubleLinkList implements Iterable<Integer> {

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;
            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    static class Node {
        Node prev; // 上一个节点指针
        int value; // 值
        Node next; // 下一个节点指针

        public Node(Node prev, int value,Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head ;
    private Node tail ;

    public DoubleLinkList() {
        head = new Node(null,666,null);
        tail = new Node(null,666,null);

        head.next = tail;
        tail.prev = head;
    }


     Node findNode(int index){
        int i = -1;
        for (Node p = head;p !=tail; p = p.next,i++){
            if (i == index){
                return p;
            }
        }
        return null;
    }

    private IllegalArgumentException  illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index[%d]不合法%n", index));
    }


    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, value, next);
        prev.next = inserted;
        next.prev = inserted;
    }

    public void  addFirst(int value){
        insert(0,value);
    }


    public void remove(int index){
        Node prev = findNode(index -1);

        if (prev == null){
            throw illegalIndex(index);
        }
        Node removed = prev.next;

        if (removed ==null){
            throw illegalIndex(index);
        }

        Node next = removed.next;
        prev.next = next;
        next.prev = prev;
    }

    public void removeFirst(){
        remove(0);
    }

    public void addLast(int value){
        Node last = tail.prev;
        Node added = new Node(last, value, tail);
        last.next = added;
        tail.prev = added;

    }
    public void removedLast(){
        Node removed = tail.prev;
        if (removed == head){
            throw illegalIndex(0);
        }
       Node prev = removed.prev;
       prev.next = tail;
       tail.prev = prev;

    }
}
