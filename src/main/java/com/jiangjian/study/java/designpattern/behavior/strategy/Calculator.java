package com.jiangjian.study.java.designpattern.behavior.strategy;

public class Calculator {
    private MathOperation mathOperation;

    public void doMathOperation(int x, int y) {
        int result = mathOperation.operation(x, y);
        System.out.println("result is " + result);
    }

    public void setMathOperation(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }

    public static void main(String[] args) {
        AddOperation addOperation = new AddOperation();
        SubstractOperation substractOperation = new SubstractOperation();

        Calculator calculator = new Calculator();
        calculator.setMathOperation(addOperation);
        calculator.doMathOperation(1, 2);

        calculator.setMathOperation(substractOperation);
        calculator.doMathOperation(1, 2);
    }
}
