package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorSubtraction {
    @DataProvider
    public static Object [][] subtractCorrectData() {
        return new Object[][] {
                {1, 2, -1},
                {-1, -1, 0},
                {123456, 987654, -864198}
        };
    }

    // {methodName}_when{TestCase}_then{ExpectedResult}
    @Test(dataProvider = "subtractCorrectData")
    public void sub_whenPassingTwoLongs_thenReturnsValidResult(long a, long b, long result) {
        Calculator calculator = new Calculator();

        var actual = calculator.sub(a, b);

        assertThat(actual).isEqualTo(result);
    }
}
