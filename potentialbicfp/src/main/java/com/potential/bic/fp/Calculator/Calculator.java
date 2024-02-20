package com.potential.bic.fp.Calculator;

public class Calculator {

    public static int div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        } else {
            return a / b;
        }
    }
}
