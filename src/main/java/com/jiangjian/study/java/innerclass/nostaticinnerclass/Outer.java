package com.jiangjian.study.java.innerclass.nostaticinnerclass;

public class Outer {
    private int x;

    public Outer(int x) {
        this.x = x;
    }

    public static void main(String[] args) {
        Outer outer = new Outer(1);

        //非静态内部创建，必须先创建外部类(outer class/ enclosing class)
        NestedClass nestedClass = outer.new NestedClass(5);

        nestedClass.printX();
    }

    class NestedClass {

        /*
        非静态内部类不能定义静态方法和静态变量

        private static int x = 5;

        public static void printHello() {
            System.out.println("Hello");
        }
        */

        private int x;

        public NestedClass(int x) {
            this.x = x;
        }



        public void printX() {
            int x = 10;
            System.out.println(x);
            System.out.println(this.x);
            System.out.println(Outer.this.x);
        }
    }
}
