package com.itheima.datastructure.linkedlist;

import org.springframework.beans.factory.annotation.Value;

import java.util.Iterator;

public class DoublelyLinkList implements Iterable<Integer>{
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
               int Value = p.value;
                p = p.next;
                return Value;
            }
        };
    }

    private static class Node{
        Node prev;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        int value;

        Node next;

    }

    private Node sentinel = new  Node(null,-1,null);

    public DoublelyLinkList() {
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(int value){
        Node a =sentinel;
        Node b = sentinel.next;
        Node added = new Node(a, value, b);
        a.next = added;
        b.prev = added;
    }
    public  void insert(int index,int value){

    }


    public void addLast(int value){
        Node a = sentinel.prev;
        Node b = sentinel;
        Node added = new Node(a,value,b);
        a.next =added;
        b.prev =added;
    }

    public void removeFirst(){
        Node removed = sentinel.next;
        if (removed == sentinel){
            throw new IllegalArgumentException("链表内没有节点");
        }
        Node next = removed.next;
        sentinel.next = next;
        next.prev = sentinel;
    }

    public void removedLast(){
        Node removed = sentinel.prev;
        if (removed == sentinel){
            throw new IllegalArgumentException("链表内没有节点");
        }
        Node prev = removed.prev;
        sentinel.prev = prev;
        prev.next = sentinel;
    }

    public void removedByValue(int value){
        Node removed = findByValue(value);
        if (removed == null){
            return;
        }

        Node a = removed.prev;
        Node b = removed.next;

        a.next = b;
        b.prev = a;
    }

    public Node findByValue(int value){
        Node p = sentinel.next;
        while (p != sentinel){
            if (p.value == value){
                return p;
            }
            p = p.next;
        }

        return null;
    }
}
