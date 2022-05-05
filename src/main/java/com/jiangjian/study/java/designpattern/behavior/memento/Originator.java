package com.jiangjian.study.java.designpattern.behavior.memento;

public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("Originator: Setting state to " + state);
    }

    public Memento saveToMemento() {
        System.out.println("Saving to memento");
        return new Memento(this.state);
    }

    public void restoreFromMemento(Memento memento) {
        this.state = memento.getState();
        System.out.println("restore state from memento:" + this.state);
    }

    public static class Memento {
        private final String state;

        public Memento(String state) {
            this.state = state;
        }

        private String getState() {
            return state;
        }
    }

    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("向左");
        originator.setState("向前");
        Memento memento = originator.saveToMemento();
        originator.setState("向后");
        originator.restoreFromMemento(memento);
    }
}
