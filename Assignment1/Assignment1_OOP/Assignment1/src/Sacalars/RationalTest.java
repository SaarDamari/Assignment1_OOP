package Sacalars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RationalTest {

    @Test
    public void add() {
        Scalar num1=new Rational(1,1);
        Scalar num2=new Rational(0,5);
        Scalar num3=new Rational(9,4);
        Scalar num4=new Rational(-5,25);
        Scalar checkR1=num1.add(new Integer(2));
        Scalar checkR2=num2.add(new Integer(3));
        Scalar checkR3=num3.add(new Integer(2));
        Scalar checkR4=num4.add(new Integer(1));
        Scalar checkR5=num1.add(new Rational(3,4));
        Scalar checkR6=num2.add(new Rational(1,4));
        Scalar checkR7=num3.add(new Rational(-1,4));
        Scalar checkR8=num4.add(new Rational(30,25));
        assertEquals(new Rational(3,1),checkR1);
        assertEquals(new Rational(15,5),checkR2);
        assertEquals(new Rational(17,4),checkR3);
        assertEquals(new Rational(20,25),checkR4);
        assertEquals(new Rational(7,4),checkR5);
        assertEquals(new Rational(5,20),checkR6);
        assertEquals(new Rational(8,4),checkR7);
        assertEquals(new Rational(25,25),checkR8);
    }

    @Test
    void mul() {
        Scalar num1=new Rational(1,1);
        Scalar num2=new Rational(0,5);
        Scalar num3=new Rational(9,4);
        Scalar num4=new Rational(-5,25);
        Scalar checkR1=num1.mul(new Integer(2));
        Scalar checkR2=num2.mul(new Integer(3));
        Scalar checkR3=num3.mul(new Integer(2));
        Scalar checkR4=num4.mul(new Integer(1));

        Scalar checkR5=num1.mul(new Rational(3,4));
        Scalar checkR6=num2.mul(new Rational(1,4));
        Scalar checkR7=num3.mul(new Rational(-1,4));
        Scalar checkR8=num4.mul(new Rational(30,25));

        assertEquals(new Rational(2,1),checkR1);
        assertEquals(new Rational(0,5),checkR2);
        assertEquals(new Rational(18,4),checkR3);
        assertEquals(new Rational(-5,25),checkR4);
        assertEquals(new Rational(3,4),checkR5);
        assertEquals(new Rational(0,20),checkR6);
        assertEquals(new Rational(-9,16),checkR7);
        assertEquals(new Rational(-150,625),checkR8);

    }

    @Test
    void neg() {
        Scalar checkR1=new Rational(1,1).neg();
        Scalar checkR2=new Rational(0,5).neg();
        Scalar checkR3=new Rational(9,4).neg();
        Scalar checkR4=new Rational(-5,25).neg();

        assertEquals(new Rational(-1,1),checkR1);
        assertEquals(new Rational(0,5),checkR2);
        assertEquals(new Rational(-9,4),checkR3);
        assertEquals(new Rational(5,25),checkR4);
    }

    @Test
    void power() {
        Scalar checkR1=new Rational(1,1);
        Scalar checkR2=new Rational(0,5);
        Scalar checkR3=new Rational(9,4);
        Scalar checkR4=new Rational(-5,25);
        assertEquals(new Rational(1,1),checkR1.power(7));
        assertEquals(new Rational(0,125),checkR2.power(3));
        assertEquals(new Rational(729,64),checkR3.power(3));
        assertEquals(new Rational(25,625),checkR4.power(2));
    }

    @Test
    void sign() {
        Scalar checkR1=new Rational(1,1).neg();
        Scalar checkR2=new Rational(0,5).neg();
        Scalar checkR3=new Rational(9,4).neg();
        Scalar checkR4=new Rational(-5,25).neg();
        assertEquals(new Rational(-1,1),checkR1);
        assertEquals(new Rational(0,5),checkR2);
        assertEquals(new Rational(-9,4),checkR3);
        assertEquals(new Rational(5,25),checkR4);
    }

    @Test
    void testEquals() {
        Scalar checkR1=new Rational(0,5);
        Scalar checkR2=new Rational(0,5);
        Scalar checkR3=new Rational(-5,25);
        Scalar checkR4=new Rational(-1,5);
        Scalar checkR5=new Rational(1,-5);
        assertEquals(checkR1, checkR2);
        assertNotEquals(checkR2, checkR3);
        assertEquals(checkR4, checkR3);
        assertEquals(checkR4, checkR5);
    }

    @Test
    void reduce() {
        Scalar checkR1=new Rational(2,4).reduce();
        Scalar checkR2=new Rational(16,48).reduce();
        Scalar checkR3=new Rational(-5,25).reduce();
        Scalar checkR4=new Rational(13,25).reduce();
        Scalar checkR5=new Rational(98,6).reduce();
        assertEquals(new Rational(1,2),checkR1);
        assertEquals(new Rational(1,3),checkR2);
        assertEquals(new Rational(-1,5),checkR3);
        assertEquals(new Rational(13,25),checkR4);
        assertEquals(new Rational(49,3),checkR5);
    }

    @Test
    void testToString() {
        Scalar checkR1=new Rational(2,4);
        Scalar checkR2=new Rational(16,48);
        Scalar checkR3=new Rational(-5,25);
        Scalar checkR4=new Rational(13,25);
        assertEquals("2/4",checkR1.toString());
        assertEquals("16/48",checkR2.toString());
        assertEquals("-5/25",checkR3.toString());
        assertEquals("13/25",checkR4.toString());
    }
}