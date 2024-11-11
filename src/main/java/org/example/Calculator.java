package org.example;

public class Calculator {
    public static int add(Object... numbers) {
        int total = 0;
        // must have at least two arguments
        if (numbers.length < 2) {
            throw new IllegalArgumentException("At least two numbers required.");
        }
        for (Object num : numbers) {
            if (!(num instanceof Integer)) {
                throw new IllegalArgumentException("Only integer values are allowed.");
            }
            total += (Integer) num;
        }

        return total;
    }
}
