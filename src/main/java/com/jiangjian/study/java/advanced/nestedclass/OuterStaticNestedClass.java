package com.jiangjian.study.java.advanced.nestedclass;

/**
 * Created by Administrator on 2017/1/22 0022.
 */
public class OuterStaticNestedClass {
    private static int a = 0;
    public static class StaticNestedClass {
        private int b = 0;
        public StaticNestedClass(int b) {
            this.b = b;
        }

        public void display() {
            System.out.println(a);
        }

        public void displayInstance() {
            System.out.println(b);
        }
    }

    public void show() {
        System.out.println("just show");
    }

    public static void main(String[] args) {
        StaticNestedClass staticNestedClass = new OuterStaticNestedClass.StaticNestedClass(1);
        staticNestedClass.display();
        staticNestedClass.displayInstance();
    }
}
