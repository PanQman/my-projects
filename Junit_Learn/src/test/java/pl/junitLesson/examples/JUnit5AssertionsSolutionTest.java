package pl.junitLesson.examples;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JUnit5AssertionsSolutionTest {

    private JUnit5AssertionsSolution sut = new JUnit5AssertionsSolution();

    @Test
    public void shouldBePrimeFor1() {
        boolean result = sut.isPrimeNumber(1);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldBePrimeFor2() {
        boolean result = sut.isPrimeNumber(2);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotBePrimeFor10() {
        boolean result = sut.isPrimeNumber(10);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldNotBePrimeFor11() {
        boolean result = sut.isPrimeNumber(11);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotBePrimeFor13() {
        boolean result = sut.isPrimeNumber(13);
        Assertions.assertTrue(result);
    }

    @Test
    public void shouldNotBePrimeFor9() {
        boolean result = sut.isPrimeNumber(9);
        Assertions.assertFalse(result);
    }

    @Test
    public void shouldReturnValidCode() {
        JUnit5AssertionsSolution.Code code = sut.getCode("a");

        Assertions.assertEquals("a", code.getKey());
        Assertions.assertNotNull(code.getCreatedAtTimestamp());
        Assertions.assertNotNull(code.getCode());
    }

    @Test
    public void shouldReturnSameObjects() {
        JUnit5AssertionsSolution.Code code = sut.getCode("a");
        JUnit5AssertionsSolution.Code code2 = sut.getCode("a");

        Assertions.assertSame(code, code2);
    }

    @Test
    public void shouldReturnDifferentObjects() {
        JUnit5AssertionsSolution.Code code = sut.getCode("a");
        JUnit5AssertionsSolution.Code code2 = sut.getCode("b");

        Assertions.assertNotSame(code, code2);
    }

}