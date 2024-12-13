package org.example.aop;

public class CalculatorImpl implements ICalculator {
    @Override
    public double add(double a, double b) {
        double res = a + b;
        System.out.println("add res:" + res);
        return res;
    }

    @Override
    public double sub(double a, double b) {
        double res = a - b;
        System.out.println("sub res:" + res);
        return res;
    }

    @Override
    public double mul(double a, double b) {
        double res = a * b;
        System.out.println("mul res:" + res);
        return res;
    }

    @Override
    public double div(double a, double b) {
        double res = a / b;
        System.out.println("div res:" + res);
        return res;
    }
}
