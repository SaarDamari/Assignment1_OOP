package Sacalars;

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
        int tempnuminator = this.getDenominator() * num.getNumerator() + this.getNumerator() * this.getDenominator();
        return new Rational(tempnuminator, this.getDenominator() * num.getDenominator());
    }


    public Scalar addInteger(Integer num) {
        return new Rational(this.getDenominator() * num.getNumber() + this.getNumerator(), this.getDenominator());
    }


    public Scalar mul(Scalar s) {
        return s.mul(this);
    }

    public Scalar mulInteger(Integer s) {
        return new Rational(s.getNumber() * this.getNumerator(), this.getDenominator());
    }

    public Scalar mulRational(Rational s) {
        return new Rational(this.getNumerator() * s.getNumerator(), this.getDenominator() * s.getDenominator());
    }

    public Scalar neg() {
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
        if (this.getNumerator() > 0 ^ this.getDenominator() < 0) {
            if (this.getNumerator() > 0)
                return 0;
            else
                return -1;
        } else
            return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rational))
            return false;
        else {
            Rational other = (Rational) o;
            if (other.getNumerator() == this.getNumerator() && other.getDenominator() == this.getDenominator())
                return true;
            else
                return false;
        }
    }

    public Rational reduce() {
        int divide = GCD(Math.max(this.getNumerator(), this.getDenominator()), Math.min(this.getNumerator(), this.getDenominator()));
        return new Rational(this.getNumerator()/divide,this.getDenominator()/divide);
    }

    public int GCD(int big, int small) {
        int divide = small;
        while (divide > 1) {
            divide = big % small;
            big = small;
            small = divide;
        }
        if(divide==0)
            return small;
        else
            return 1;
    }

    @Override
    public String toString() {
        Rational temp=this.reduce();
        if(this.getDenominator()==1 || this.getDenominator()==-1)
            return ""+this.getNumerator();
        else if (this.sign()==-1)
        {
            return "-"+this.getNumerator()+"/"+this.getDenominator();
        }
        else
            return this.getNumerator()+"/"+this.getDenominator();
    }
}
