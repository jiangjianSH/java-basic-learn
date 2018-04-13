package com.jiangjian.study.java.advanced.osgi;

public interface CalculatorService {
    double[] parseUserInput(String str) throws NumberFormatException;

    double add(double... numbers);

    double multiply(double... numbers);

    void printResult(double result);
}
