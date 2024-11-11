package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Calculator calculator = new Calculator();
    }

    @Test
    public void testAdditionWithInsufficientArguments() {
//        Calculator calculator = new Calculator();

        // Expecting an exception because only one argument is provided
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add(5); // Only one argument provided
        });
        assertEquals("At least two numbers required.", exception.getMessage());
    }

    @Test
    public void testAdditionWithNonIntegerArguments() {

        // Test with a double argument
        assertThrows(IllegalArgumentException.class, () -> calculator.add(5, 3.5));

        // Test with a float argument
        assertThrows(IllegalArgumentException.class, () -> calculator.add(5, 3.0f));

        // Test with a String argument
        assertThrows(IllegalArgumentException.class, () -> calculator.add(5, "3"));

        // Test with null as an argument
        assertThrows(IllegalArgumentException.class, () -> calculator.add(5, null));
    }

    @Test
    public void testForCorrectResultWhenAdding() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-5, 5));
        assertEquals(-10, calculator.add(-5, -5));
    }
}