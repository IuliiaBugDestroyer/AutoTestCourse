package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.epam.tat.module4.Calculator;
import org.assertj.core.data.Offset;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CalculatorDivide {
    @DataProvider
    public static Object [][] divideCorrectData() {
        return new Object[][] {
                {1, 2, 0},
                {-15, 5, -3},
                {123456, 987654, 0}
        };
    }

    // {methodName}_when{TestCase}_then{ExpectedResult}
    @Test(dataProvider = "divideCorrectData")
    public void div_whenPassingTwoLongs_thenReturnsValidResult(long a, long b, long result) {
        Calculator calculator = new Calculator();

        var actual = calculator.div(a, b);

        assertThat(actual).isEqualTo(result);
    }

    @DataProvider
    public static Object [][] divideByZeroLong() {
        return new Object[][] {
                {-15, 0}
        };
    }

    // {methodName}_when{TestCase}_then{ExpectedResult}
    @Test(dataProvider = "divideByZeroLong")
    public void div_whenPassingTwoLongs_thenThrowsException(long a, long b) {
        final String expectedExceptionMessage = "Attempt to divide by zero";

        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.div(a, b))
                .isInstanceOf(NumberFormatException.class)
                .withFailMessage(expectedExceptionMessage);
    }

    @DataProvider
    public static Object [][] divideCorrectDataWithDouble() {
        return new Object[][] {
                {1.0, 2.0, 0.5},
                {-15.0, 1.5, -10.0},
                {123456, 987654, 0.12499924}
        };
    }

    // {methodName}_when{TestCase}_then{ExpectedResult}
    @Test(dataProvider = "divideCorrectDataWithDouble")
    public void div_whenPassingTwoDouubles_thenReturnsValidResult(double a, double b, double result) {
        Calculator calculator = new Calculator();

        var actual = calculator.div(a, b);

        assertThat(actual).isEqualTo(result, Offset.offset(0.001));
    }

    @DataProvider
    public static Object [][] divideByZeroDouble() {
        return new Object[][] {
                {1.11, 0.0}
        };
    }

    @Test(dataProvider = "divideByZeroDouble")
    public void div_whenPassingTwoDoubles_thenThrowsException(double a, double b) {
        Calculator calculator = new Calculator();

        assertThatThrownBy(() -> calculator.div(a, b)).isInstanceOf(NumberFormatException.class);
    }
}
