package com.jiangjian.study.java.datastruction;

import java.lang.reflect.Array;

public class Stack<T> {
    T[] data;
    int top = -1;

    public Stack(Class clazz, int size) {
        this.data = (T[]) Array.newInstance(clazz, size);
    }

    public boolean isFull() {
        return top == data.length -1;
    }

    public void push(T value) {
        if (isFull()) {
            throw new RuntimeException("stack is overflow");
        }
        data[++top] = value;
    }

    public T pop() {
        if (top == 0) {
            return null;
        }
        return data[top--];
    }

    public T peek() {
        if (top == -1) {
            return null;
        }
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        Stack<String> stacks = new Stack<>(String.class, 4);
        System.out.println(stacks.isEmpty());
        stacks.push("A");
        stacks.push("B");
        stacks.push("C");
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        stacks.push("D");
        stacks.push("E");
        stacks.push("F");
        System.out.println(stacks.peek());
        System.out.println(stacks.isFull());
        System.out.println(Integer.MAX_VALUE + 1);
        stacks.push("G");
    }
}
