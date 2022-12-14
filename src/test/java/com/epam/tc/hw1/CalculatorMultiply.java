package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorMultiply {
    @DataProvider
    public static Object [][] multiplyCorrectData() {
        return new Object[][] {
                {1, 2, 2},
                {-1, 0, 0},
                {-1234, 7654, -9445036}
        };
    }

    // {methodName}_when{TestCase}_then{ExpectedResult}
    @Test(dataProvider = "multiplyCorrectData")
    public void mult_whenPassingTwoLongs_thenReturnsValidResult(long a, long b, long result) {
        Calculator calculator = new Calculator();

        var actual = calculator.mult(a, b);

        assertThat(actual).isEqualTo(result);
    }
}
