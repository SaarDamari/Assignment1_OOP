package Sacalars;

import javax.swing.*;

public class Monomial {
    private int exponent;
    private Scalar coeffiecient;

    public Monomial(int exponent, Scalar coeffiecient) {
        this.coeffiecient = coeffiecient;
        this.exponent = exponent;
    }

    public int getExponent() {
        return exponent;
    }

    public Scalar getCoeffiecient() {
        return coeffiecient;
    }

    public Monomial add(Monomial m) {
        if (m.getExponent() != this.exponent) {
            return null;
        } else {
            return new Monomial(this.getExponent(), m.getCoeffiecient().add(this.getCoeffiecient()));
        }
    }

    public Monomial mul(Monomial m) {
        return new Monomial(this.getExponent() + m.getExponent(), m.getCoeffiecient().mul(this.getCoeffiecient()));
    }

    public Scalar evaluate(Scalar s) {
        Scalar temp = s.power(this.getExponent());
        return temp.mul(this.getCoeffiecient());
    }

    public Monomial detrives() {
        Scalar newCoefficient = this.coeffiecient.mul(new Integer(this.exponent));
        if (this.exponent == 0) {
            return new Monomial(0, new Integer(0)); // Return a monomial with coefficient 0
        }
        int newExponent = this.exponent - 1;
        return new Monomial(newExponent, newCoefficient);
    }


    public int sign() {
        return this.getCoeffiecient().sign();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Monomial))
            return false;
        else {
            Monomial other = (Monomial) o;
            if (other.getExponent() == this.getExponent() && this.getCoeffiecient().equals(other.getCoeffiecient()))
                return true;
            else return false;
        }
    }

    @Override
    public String toString() {
        Scalar one = new Integer(1);
        Scalar negOne = new Integer(-1);

        // Case for exponent 0 (constant term)
        if (this.getExponent() == 0) {
            return this.getCoeffiecient().toString();
        }

        // Case for coefficient 1 and exponent 1 (x term)
        if (this.getCoeffiecient().equals(one) && this.getExponent() == 1) {
            return "x";
        }

        // Case for coefficient 1 and exponent > 1 (x^n term)
        if (this.getCoeffiecient().equals(one)) {
            return "x^" + this.getExponent();
        }

        // Case for coefficient -1 and exponent 1 (-x term)
        if (this.getCoeffiecient().equals(negOne) && this.getExponent() == 1) {
            return "-x";
        }

        // Case for coefficient -1 and exponent > 1 (-x^n term)
        if (this.getCoeffiecient().equals(negOne)) {
            return "-x^" + this.getExponent();
        }

        // Case for general exponent 1 (coefficient * x term)
        if (this.getExponent() == 1) {
            return this.getCoeffiecient().toString() + "x";
        }

        // Case for general term (coefficient * x^n)
        return this.getCoeffiecient().toString() + "x^" + this.getExponent();
    }

}



