package pl.junitLesson.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcTest {

    @Test
    void shouldAdd1To1AndReturn2() {
        // given
        int a = 1;
        int b = 1;
        Calc calculator = new Calc();

        // when
        int result = calculator.add(a, b);

        // then
        Assertions.assertEquals(2, result);
    }

}
