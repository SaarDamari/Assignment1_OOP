package Sacalars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonomialTest {

    @Test
    void add() {
        Monomial num1=new Monomial(2, new Integer(5));
        Monomial check1=num1.add(new Monomial(2, new Integer(7)));
        Monomial check2=num1.add(new Monomial(2, new Integer(-9)));
        Monomial check3=num1.add(new Monomial(2, new Rational(-9,2)));
        Monomial check4=num1.add(new Monomial(2, new Rational(9,2)));
        assertEquals(new Monomial(2,new Integer(12)),check1);
        assertEquals(new Monomial(2,new Integer(-4)),check2);
        assertEquals(new Monomial(2,new Rational(1,2)),check3);
        assertEquals(new Monomial(2,new Rational(19,2)),check4);
    }

    @Test
    void mul() {
        Monomial num1=new Monomial(2, new Integer(5));
        Monomial check1=num1.mul(new Monomial(3, new Integer(7)));
        Monomial check2=num1.mul(new Monomial(4, new Integer(-9)));
        Monomial check3=num1.mul(new Monomial(7, new Rational(-9,5)));
        Monomial check4=num1.mul(new Monomial(12, new Rational(9,5)));
        assertEquals(new Monomial(5,new Integer(35)),check1);
        assertEquals(new Monomial(6,new Integer(-45)),check2);
        assertEquals(new Monomial(9,new Rational(-45,5)),check3);
        assertEquals(new Monomial(14,new Rational(45,5)),check4);

    }

    @Test
    void evaluate() {
        Scalar num1=new Monomial(2, new Integer(5)).evaluate(new Integer(5));
        Scalar num2=new Monomial(3, new Rational(1,3)).evaluate(new Rational(3,1));
        Scalar num3=new Monomial(5, new Integer(-1)).evaluate(new Integer(2));
        Scalar num4=new Monomial(4, new Rational(1,2)).evaluate(new Rational(-1,2));
        assertEquals(new Integer(125),num1);
        assertEquals(new Rational(9,1),num2);
        assertEquals(new Integer(-32),num3);
        assertEquals(new Rational(1,32),num4);
    }

    @Test
    void detrives() {
        Monomial num1=new Monomial(2,new Integer(3));
        Monomial num2=num1.detrives();
        assertNotSame(num1,num2);
    }

    @Test
    void sign() {
        int num1=new Monomial(2,new Integer(3)).sign();
        int num2=new Monomial(5,new Integer(-33)).sign();
        int num3=new Monomial(7,new Rational(3,9)).sign();
        int num4=new Monomial(1,new Rational(2,-13)).sign();
        int num5=new Monomial(9,new Integer(0)).sign();
        int num6=new Monomial(9,new Rational(0,24)).sign();
        assertEquals(1,num1);
        assertEquals(-1,num2);
        assertEquals(1,num3);
        assertEquals(-1,num4);
        assertEquals(0,num5);
        assertEquals(0,num6);
    }

    @Test
    void testEquals() {
        Monomial num1=new Monomial(2,new Integer(5));
        Monomial num2=new Monomial(2,new Integer(-5));
        Monomial num3=new Monomial(3,new Integer(7));
        Monomial num4=new Monomial(3,new Integer(7));
        Monomial num5=new Monomial(5,new Rational(4,7));
        Monomial num6=new Monomial(5,new Rational(4,7));
        assertNotEquals(num1,num2);
        assertNotEquals(num2,num3);
        assertEquals(num3,num4);
        assertNotEquals(num4,num5);
        assertEquals(num5,num6);
    }

    @Test
    void testToString() {
        String num1=new Monomial(2,new Integer(-5)).toString();
        String num2=new Monomial(3,new Integer(7)).toString();
        String num3=new Monomial(1,new Rational(7,13)).toString();
        String num4=new Monomial(0,new Rational(4,-7)).toString();
        assertEquals("-5x^2",num1);
        assertEquals("7x^3",num2);
        assertEquals("7/13x",num3);
        assertEquals("-4/7",num4);
    }
}