package Sacalars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {

    Polynomial polynomial1;
    Polynomial polynomial2;
    Polynomial polynomial3;

    @BeforeEach
    public void setup() {
        polynomial1 = Polynomial.build("1 3 2");
        polynomial2 = Polynomial.build("5 0 -1/2 2/3");
        polynomial3 = Polynomial.build("-1 -3 -2");
    }

    @Test
    public void testToString() {
        assertEquals("1 + 3x + 2x^2", polynomial1.toString().trim());
        assertEquals("5 -1/2x^2 + 2/3x^3", polynomial2.toString().trim());
        assertEquals("-1 -3x -2x^2", polynomial3.toString().trim());
    }

    @Test
    public void testAdd() {
        Polynomial sum12 = polynomial1.add(polynomial2);
        Polynomial sum13 = polynomial1.add(polynomial3);
        Polynomial sum23 = polynomial2.add(polynomial3);

        assertEquals("6 + 3x + 3/2x^2 + 2/3x^3", sum12.toString().trim());
        assertEquals("", sum13.toString().trim());
        assertEquals("4 -3x -5/2x^2 + 2/3x^3", sum23.toString().trim());
    }

    @Test
    public void testMul() {
        Polynomial product12 = polynomial1.mul(polynomial2);
        Polynomial product13 = polynomial1.mul(polynomial3);
        Polynomial product23 = polynomial2.mul(polynomial3);

        assertEquals("5 + 15x + 19/2x^2 -5/6x^3 + x^4 + 4/3x^5", product12.toString().trim());
        assertEquals("-1 -6x -13x^2 -12x^3 -4x^4", product13.toString().trim());
        assertEquals("-5 -15x -19/2x^2 + 5/6x^3 -x^4 -4/3x^5", product23.toString().trim());
    }

    @Test
    public void testEvaluate() {
        Scalar result = polynomial1.evaluate(new Integer(2));
        assertEquals(new Integer(15), result);
    }

    @Test
    public void testEquals() {
        assertTrue(polynomial1.equals(polynomial1));
        assertFalse(polynomial1.equals(polynomial3));
        assertFalse(polynomial1.equals(polynomial2));
        assertFalse(polynomial2.equals(polynomial3));
        assertFalse(polynomial1.equals(null));
        assertFalse(polynomial1.equals("not a polynomial"));
    }

    @Test
    public void testDerivative() {
        Polynomial derivative = polynomial1.derivative();
        assertEquals("3 + 4x", derivative.toString().trim());
    }
}
