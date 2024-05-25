package Sacalars;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerTest {
    @Test
    public void test_Add() {
    Scalar s=new Integer(1);
    Scalar check1=s.add(new Integer(99));
    Scalar check2=s.add(new Rational(3,4));
    assertEquals(new Integer(100),check1);
    assertEquals(new Rational(7,4),check2);
    }
    @Test
    public void test_Mul() {
        Scalar one=new Integer(1);
        Scalar zero=new Integer(0);
        Scalar number=new Integer(23);
        Scalar checkone1=one.mul(new Integer(9));
        Scalar checkzero1=zero.mul(new Integer(17));
        Scalar checknumber1=number.mul(new Integer(30));

        Scalar checkone2=one.mul(new Rational(9,4));
        Scalar checkzero2=zero.mul(new Rational(29,14));
        Scalar checknumber2=number.mul(new Rational(12,23));
        assertEquals(new Integer(9),checkone1);
        assertEquals(new Integer(0),checkzero1);
        assertEquals(new Integer(690),checknumber1);
        assertEquals(new Rational(9,4),checkone2);
        assertEquals(new Rational(0,4),checkzero2);
        assertEquals(new Rational(12,1),checknumber2);
    }
    @Test
    public void test_Neg()
    {
        Scalar checkI1=new Integer(1).neg();
        Scalar checkI2=new Integer(0).neg();
        Scalar checkI3=new Integer(-789).neg();
        assertEquals(new Integer(-1),checkI1);
        assertEquals(new Integer(0),checkI2);
        assertEquals(new Integer(789),checkI3);
    }
    @Test
    public void test_Power()
    {
        Scalar checkI1=new Integer(1).power(5);
        Scalar checkI2=new Integer(0).power(9);
        Scalar checkI3=new Integer(2).power(4);
        Scalar checkI4=new Integer(-3).power(3);
        assertEquals(new Integer(1),checkI1);
        assertEquals(new Integer(0),checkI2);
        assertEquals(new Integer(16),checkI3);
        assertEquals(new Integer(-27),checkI4);

    }
    @Test
    public void test_Sign()
    {
        Scalar checkI1=new Integer(-5);
        Scalar checkI2=new Integer(0);
        Scalar checkI3=new Integer(78);
        assertEquals(-1,checkI1.sign());
        assertEquals(0,checkI2.sign());
        assertEquals(1,checkI3.sign());
    }
    @Test
    public void test_Equals()
    {
        Scalar checkI1=new Integer(1);
        Scalar checkI2=new Integer(1);
        Scalar checkI3=new Integer(-78);
        assertEquals(checkI1, checkI2);
        assertNotEquals(checkI1, checkI3);
    }
    @Test
    public void test_ToString()
    {
        Scalar checkI1=new Integer(1);
        Scalar checkI2=new Integer(0);
        Scalar checkI3=new Integer(-78);
        assertEquals("1",checkI1.toString());
        assertEquals("0",checkI2.toString());
        assertEquals("-78",checkI3.toString());
    }
}