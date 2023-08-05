package com.itheima.datastructure.array;

import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArrayTest implements Iterable<Integer>{

    private int size = 0; //逻辑大小
    private int capcity = 8 ; //初始容量

    private int[] array = new int[] {};


    public void addList(int element){
      add(size,element);
    }

    public void add(int index , int element) {
        checkAndGroup();

        //添加逻辑
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array, index + 1, size - index);
        }

        array[index] = element;
        size++;

    }

    private void checkAndGroup() {
        //容量检查
        if (size == 0 ){
            array = new int[capcity];
        }else if (size == capcity){
            //进行扩容
             capcity += capcity >>> 1;
             int[] newArray = new int[capcity];
             System.arraycopy(array,0,newArray,0,size);
             array = newArray;
        }
    }

    public int get(int index){
        return array[index];
    }


    public  void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);

            consumer.accept(array[i]);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int i = 0;
            @Override
            public boolean hasNext() {  //有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() {     //返回当前元素,并移动到下一个元素
                return array[i++];
            }
        };
    }

    public IntStream stream(){
        return IntStream.of(array);
    }


    public int remove(int index){
            int removed = array[index];
            if (index < size -1)
            System.arraycopy(array,index+1,array,index,size-index-1);
            size--;
            return removed;
    }
}
