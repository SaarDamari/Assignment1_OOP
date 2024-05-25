package Sacalars;

public class Integer implements Scalar{
    private int number;
    public Integer(int number) {
        this.number=number;
    }
    public int getNumber() {
        return number;
    }

    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }
    public Scalar addRational(Rational num) {
        return new Rational(getNumber()*num.getDenominator()+num.getNumerator(),num.getDenominator());
    }
    public Scalar addInteger(Integer num) {
        return new Integer(this.getNumber()+num.getNumber());
    }

    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }
    public Scalar mulInteger(Integer s) {
        return new Integer(this.getNumber()*s.getNumber());
    }
    public Scalar mulRational(Rational s) {
        return new Rational(this.getNumber()*s.getNumerator(),s.getDenominator());
    }
    public Scalar neg() {
        return new Integer(-1*this.getNumber());
    }


    public Scalar power(int exponent) {
        int mul=1;
        for (int i = 0; i < exponent; i++) {
            mul*=this.getNumber();
        }
        return new Integer(mul);
    }

    public int sign() {
        if(this.getNumber()>0)
            return 1;
        else if (this.getNumber()<0)
        {
        return -1;
        }
        else
            return 0;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Scalar))
            return false;
        else {
             Integer result=(Integer)(((Scalar)o).add(this.neg()));
            return result.getNumber()==0;
        }
    }

    @Override
    public String toString() {
        return ""+this.getNumber();
    }
}
