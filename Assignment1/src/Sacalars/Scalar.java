package Sacalars;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar addInteger(Integer s);
    Scalar addRational(Rational num);
    Scalar mul(Scalar s);
    Scalar mulInteger(Integer s);
    Scalar mulRational(Rational s);
    Scalar neg();
    Scalar power(int exponent);
    int sign();
    boolean equals(Object o);

}
