package com.jiangjian.study.java.designpattern.behavior.iterator;

import java.util.Iterator;

public class NameRepository implements Iterable<String> {
    private String[] names = {"alice", "bob"};
    @Override
    public Iterator<String> iterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator<String> {
        private int index;

        @Override
        public boolean hasNext() {
            if(index < names.length){
                return true;
            }
            return false;        }

        @Override
        public String next() {
            if(hasNext()) {
                return names[index++];
            }
            return null;
        }
    }

    public static void main(String[] args) {
        NameRepository nameRepository = new NameRepository();
        Iterator<String> iterator = nameRepository.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
