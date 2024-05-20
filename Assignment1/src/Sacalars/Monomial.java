package Sacalars;

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

    Monomial detrives() {
        return new Monomial(this.getExponent(), this.getCoeffiecient());
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
            if (other.getExponent() == this.getExponent() && other.getCoeffiecient().equals(this))
                return true;
            else return false;
        }
    }

    @Override
    public String toString() {
        if (this.getExponent() == 0) {
            return this.getCoeffiecient().toString();
        } else if (this.getExponent() == 1) {
            return this.getCoeffiecient().toString() + "x";
        } else
            return this.getCoeffiecient().toString() + "x^" + this.getExponent();
    }
}


