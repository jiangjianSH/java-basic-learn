package com.jiangjian.study.java.advanced.osgi;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double[] parseUserInput(String str) throws NumberFormatException {
        String[] numbers = str.split(" ");
        double[] result = new double[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            result[i] = Double.parseDouble(numbers[i]);
        }
        return result;
    }

    @Override
    public double add(double... numbers) {
        double result = 0;
        for(double number : numbers) {
            result += number;
        }
        return result;
    }

    @Override
    public double multiply(double... numbers) {
        double result = 1;
        for(double number : numbers) {
            result *= number;
        }
        return result;
    }

    @Override
    public void printResult(double result) {
        System.out.println("the result is :" + result);
    }
}
