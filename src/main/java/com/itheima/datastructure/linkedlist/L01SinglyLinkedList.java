package com.itheima.datastructure.linkedlist;

import java.util.Iterator;
import java.util.function.Consumer;

public class L01SinglyLinkedList implements Iterable<Integer> {
    private Node head = new Node(777,null);          //头指针

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head.next;

            @Override
            public boolean hasNext() {    //是否有下一个元素
                return pointer != null;
            }

            @Override
            public Integer next() {       //返回当前元素的值
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    private class NodeIterator implements Iterator<Integer>{
        Node p = head.next;
        @Override
        public boolean hasNext() {
            return  p !=null;
        }

        @Override
        public Integer next() {
            int value = p.value;
            p = p.next;
            return value;
        }
    }


    private class Node{
        int value; //值

        Node next; //下一个指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }


    public void addFirst(int value){

     //   Node node = new Node(value, null);
//        //1.链表为空
//        if (head.next == null) {
//            head.next = node;
//        }
//        //2.链表非空
//        else {
//            node.next = head.next;
//            head.next = node;
//        }
        //1.链表为空
//        head = new Node(value,null);
        //2.链表非空
        //head = new Node(value,head);

        insert(0,value);

    }


    public void  loop(Consumer<Integer> consumer){
        Node pointer = head.next;

        while (pointer !=null){
            //获取节点的值
           // System.out.println(pointer.value);
            consumer.accept(pointer.value);
            //继续向下
            pointer = pointer.next;
        }
    }

    private Node findLast(){
        Node p ;
        for (p = head; p.next != null; p = p.next){

        }
        return p;

    }

    public void addLast(int value){
        Node last = findLast();
        last.next = new Node(value,null);
    }

     private Node findNode(int index){

        int i=-1;
        for (Node p = head; p != null ; p = p.next,i++){
            if (i == index){
                return p;
            }
        }
        return null;
     }

     public int get(int index){
        Node node = findNode(index);
        if (node == null){
            //抛出异常
            throw illegalIndex(index);
        }

        return node.value;
     }

     public void insert(int index,int value){

         Node prev = findNode(index - 1);

         if (prev == null){
          throw illegalIndex(index);
         }
         //
         prev.next  = new Node(value, prev.next);

     }

    private IllegalArgumentException  illegalIndex(int index) {
        return new IllegalArgumentException(String.format("index[%d]不合法%n", index));
    }


    public void removeFirst(){

      remove(0);

    }

    public void remove(int index){

        Node prev = findNode(index - 1);

        if (prev ==null){
            throw illegalIndex(index);
        }

        Node removed = prev.next;

        if (removed ==null){
            throw illegalIndex(index);
        }

        prev.next = removed.next;
    }

    public void loop3(Consumer<Integer> before ,
                      Consumer<Integer> after){
            recursion(head.next,before,after);
    }
    private  void recursion(Node curr,
                            Consumer<Integer> before ,
                            Consumer<Integer> after){
        if (curr == null){
            return;
        }

        before.accept(curr.value);
        recursion(curr.next,before , after);
        after.accept(curr.value);
    }
}

