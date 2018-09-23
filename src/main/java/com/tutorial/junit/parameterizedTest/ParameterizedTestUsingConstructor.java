package com.tutorial.junit.parameterizedTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTestUsingConstructor {

    // fields used together with @Parameter must be public
    public int m1;
    public int m2;
    public int result;


    public ParameterizedTestUsingConstructor(int m1, int m2, int result) {
        this.m1 = m1;
        this.m2 = m2;
        this.result = result;
    }

    // creates the test data
    @Parameterized.Parameters(name = "{index}: Test with m1={0}, m2 ={1}, result is:{2} ")
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{1, 2, 2}, {5, 3, 15}, {121, 4, 484}};
        return Arrays.asList(data);
    }


    @Test
    public void MultiplyTest() {
        ToTestClass tester = new ToTestClass();
        assertEquals("Result", result, tester.multiply(m1, m2));
    }


    // class to be tested
    private class ToTestClass {
        public int multiply(int i, int j) {
            return i * j;
        }
    }


}
