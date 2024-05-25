package Sacalars;

import org.junit.platform.engine.support.descriptor.FileSystemSource;

import java.sql.SQLOutput;

public class Rational implements Scalar {
    private int numerator;
    private int denominator;

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    @Override
    public Scalar addRational(Rational num) {
        int tempNuminator = this.getDenominator() * num.getNumerator() + this.getNumerator() * num.getDenominator();
        return new Rational(tempNuminator, this.getDenominator() * num.getDenominator());
    }


    public Scalar addInteger(Integer num) {
        return new Rational(this.getDenominator() * num.getNumber() + this.getNumerator(), this.getDenominator());
    }


    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    public Scalar mulInteger(Integer s) {
        Scalar x=new Rational(s.getNumber() * this.getNumerator(), this.getDenominator());
        System.out.println(x);
        return x;
    }

    public Scalar mulRational(Rational s) {
        return new Rational(this.getNumerator() * s.getNumerator(), this.getDenominator() * s.getDenominator());
    }

    public Scalar neg() {
        if(this.getDenominator()<0) {
            return new Rational(this.getNumerator(), this.getDenominator() * (-1));
        }
            return new Rational(this.getNumerator() * (-1), this.getDenominator());
    }

    public Scalar power(int exponent) {
        return new Rational(raiseToThePower(this.getNumerator(), exponent), raiseToThePower(this.getDenominator(), exponent));
    }

    private int raiseToThePower(int num, int exponent) {
        int multiply = 1;
        for (int i = 0; i < exponent; i++) {
            multiply *= num;
        }
        return multiply;
    }

    public int sign() {
        if (this.getNumerator() > 0 ^ this.getDenominator() > 0) {
            if (this.getNumerator() == 0)
                return 0;
            else
                return -1;
        } else
            return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Scalar))
            return false;
        else {
            Rational result=(Rational)(((Scalar)o).add(this.neg()));
            return result.getNumerator()==0;
        }
    }

    public Rational reduce() {
        if(this.getNumerator()==0)
        {
            return this;
        }
        else {
            int numenator = Math.abs(this.getNumerator());
            int denuminator = Math.abs(this.getDenominator());
            int divide = GCD(Math.max(numenator, denuminator), Math.min(numenator, denuminator));
            return new Rational(this.getNumerator() / divide, this.getDenominator() / divide);
        }
        }

    public int GCD(int big, int small) {
        int divide = small;
        divide = big % small;
        while (divide > 1) {
            big = small;
            small = divide;
            divide = big % small;
        }
        if(divide==0)
            return small;
        else
            return 1;
    }

    @Override
    public String toString() {
        if(this.getNumerator()%this.getDenominator()==0)
            return ""+this.reduce().getNumerator();
        else if (this.sign()==-1)
        {
            if(this.getDenominator()<0)
                return "-"+this.getNumerator()+"/"+(-1)*this.getDenominator();
            else
                return this.getNumerator()+"/"+this.getDenominator();
        }
        else
            return this.getNumerator()+"/"+this.getDenominator();
    }
}
