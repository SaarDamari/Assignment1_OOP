import java.util.ArrayList;
import java.util.List;

public class Polynomial {
   private List<Monomial> polynomials;

   public Polynomial() {
      this.polynomials = new ArrayList<>();
   }

   public static Polynomial build(String input) {
      Polynomial polynomial = new Polynomial();
      int exponent = 0;
      int length = input.length();

      for (int i = 0; i < length; ) {
         char currentChar = input.charAt(i);
         boolean isNegative = false;

         if (currentChar == '-') {
            isNegative = true;
            i++;
         }

         if (i < length && Character.isDigit(input.charAt(i))) {
            int numerator = input.charAt(i) - '0';
            i++;

            if (i < length && input.charAt(i) == '/') {
               i++;
               if (i < length && Character.isDigit(input.charAt(i))) {
                  int denominator = input.charAt(i) - '0';
                  i++;
                  Rational scalarR = new Rational(isNegative ? -numerator : numerator, denominator);
                  Monomial monomial = new Monomial(exponent, scalarR);
                  polynomial.polynomials.add(monomial);
               }
            } else {
               Integer scalarI = new Integer (isNegative ? -numerator : numerator);
               Monomial monomial = new Monomial(exponent, scalarI);
               polynomial.polynomials.add(monomial);
            }
            exponent++;
         }
      }
      return polynomial;
   }

   public Polynomial add(Polynomial p) {
      Polynomial newPolynomial = new Polynomial();
      int maxSize = Math.max(this.polynomials.size(), p.polynomials.size());

      for (int i = 0; i < maxSize; i++) {
         if (i < this.polynomials.size() && i < p.polynomials.size()) {
            Monomial monomial = this.polynomials.get(i).add(p.polynomials.get(i));
            newPolynomial.polynomials.add(monomial);
         } else if (i < this.polynomials.size()) {
            newPolynomial.polynomials.add(this.polynomials.get(i));
         } else if (i < p.polynomials.size()) {
            newPolynomial.polynomials.add(p.polynomials.get(i));
         }
      }
      return newPolynomial;
   }
   public Polynomial mul(Polynomial p) {
      Polynomial result = new Polynomial();

      for (Monomial term1 : this.polynomials) {
         Polynomial intermediatePolynomial = new Polynomial();

         for (Monomial term2 : p.polynomials) {
            Monomial product = term1.mul(term2);
            intermediatePolynomial.polynomials.add(product);
         }

         result = result.add(intermediatePolynomial);
      }
      return result;
   }
   public Scalar evaluate(Scalar s) {
      Scalar result = new Integer(0);
      for (Monomial monomial : polynomials) {
         result = result.add(monomial.evaluate(s));
      }
      return result;
   }
   public Polynomial derivative() {
      Polynomial result = new Polynomial();
      for (Monomial monomial : polynomials) {
         result.polynomials.add(monomial.derivative());
      }
      return result;
   }
   public boolean equals(Object o){
      if (o instanceof Polynomial && ((Polynomial) o).polynomials.size() == polynomials.size()) {
         for (Monomial monomial : polynomials) {
            if (!monomial.equals(((Polynomial)o).polynomials)) {
               return false;
            }
         }
      }
      else
         return false;
      return true;
   }
  public String toString(){
      String result = "";
      Scalar zero = new Integer(0);
      for (Monomial monomial : polynomials) {
         if (monomial.getCoeffiecient() != zero)
            if (monomial.sign() == -1)
                result = result + " " + monomial.toString();
            else
               result = result + " + " + monomial.toString();

      }
      if(result.charAt(0) == '+')
         result = result.substring(1);
      return result;
   }

}






