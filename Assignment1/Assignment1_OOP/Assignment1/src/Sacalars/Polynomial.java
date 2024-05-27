package Sacalars;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Polynomial {
   private List<Monomial> polynomials;

   public Polynomial() {
      this.polynomials = new ArrayList<>();
   }

   public static Polynomial build(String input) {
      Polynomial polynomial = new Polynomial();
      String[] parts = input.trim().split("\\s+");
      int maxExponent = parts.length - 1;

      for (int exponent = 0; exponent <= maxExponent; exponent++) {
         String part = parts[exponent];
         boolean isNegative = false;
         if(part.equals("0")) {
            polynomial.polynomials.add(new Monomial(exponent, new Integer(0)));
         }
         else {

            if (part.startsWith("-")) {
               isNegative = true;
               part = part.substring(1);
            }
            Scalar coefficient;
            if (part.contains("/")) {
               String[] fractionParts = part.split("/");
               if (fractionParts.length == 2) {
                  int numerator = manualParseInt(fractionParts[0]);
                  int denominator = manualParseInt(fractionParts[1]);
                  coefficient = new Rational(isNegative ? -numerator : numerator, denominator);
               } else {
                  throw new IllegalArgumentException("Invalid fraction format: " + part);
               }
            } else {
               int coefficientValue = manualParseInt(part);
               coefficient = new Integer(isNegative ? -coefficientValue : coefficientValue);
            }
            Monomial monomial = new Monomial(exponent, coefficient);
            polynomial.polynomials.add(monomial);
         }
      }
      return polynomial;
   }

   private static int manualParseInt(String str) {
      int result = 0;
      for (char c : str.toCharArray()) {
         if (Character.isDigit(c)) {
            result = result * 10 + (c - '0');
         } else {
            throw new NumberFormatException("Invalid character in integer: " + c);
         }
      }
      return result;
   }

   public Polynomial add(Polynomial p) {
      int maxSize = Math.max(this.polynomials.size(), p.polynomials.size());
      int minSize = Math.min(this.polynomials.size(), p.polynomials.size());
      Polynomial result = new Polynomial();
      for (int i = 0; i < maxSize; i++) {
         if (i < minSize) {
            result.polynomials.add(this.polynomials.get(i).add(p.polynomials.get(i)));
         } else {
            if (maxSize == this.polynomials.size()) {
               result.polynomials.add(this.polynomials.get(i));
            } else {
               result.polynomials.add(p.polynomials.get(i));
            }
         }
      }
      return result;
   }


   public Polynomial mul(Polynomial p) {
      Polynomial result = new Polynomial(); // Initialize result as an empty polynomial

      for (Monomial term1 : this.polynomials) {
         Polynomial intermediatePolynomial = new Polynomial(); // Initialize intermediate polynomial for each term of 'this'

         for (Monomial term2 : p.polynomials) {
            Monomial product = term1.mul(term2); // Multiply the monomials

            // Ensure intermediate polynomial has enough space for the product
            while (intermediatePolynomial.polynomials.size() <= product.getExponent()) {
               intermediatePolynomial.polynomials.add(new Monomial(intermediatePolynomial.polynomials.size(), new Integer(0)));
            }

            // Add the product to the appropriate place
            Monomial existing = intermediatePolynomial.polynomials.get(product.getExponent());
            Monomial sum = existing.add(product);
            intermediatePolynomial.polynomials.set(product.getExponent(), sum);
         }

         result = result.add(intermediatePolynomial); // Add the intermediate polynomial to the result
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
         result.polynomials.add(monomial.detrives());
      }
      return result;
   }


   public boolean equals(Object o) {
      if (this == o) {
         return true; // Same reference, objects are equal
      }
      if (!(o instanceof Polynomial)) {
         return false; // Object is not an instance of Polynomial, cannot be equal
      }
      Polynomial other = (Polynomial) o;
      if (this.polynomials.size() != other.polynomials.size()) {
         return false; // Different number of terms, not equal
      }
      // Compare each monomial individually
      for (int i = 0; i < this.polynomials.size(); i++) {
         if (!this.polynomials.get(i).equals(other.polynomials.get(i))) {
            return false; // Monomials at index i are not equal, polynomials are not equal
         }
      }
      return true; // All monomials are equal, polynomials are equal
   }


   public String toString() {
      if (polynomials.isEmpty())
         return "";
         String result = "";
         Scalar zero = new Integer(0);
         for (Monomial monomial : polynomials) {
            if (!monomial.getCoeffiecient().equals(zero))
               if (monomial.sign() == -1)
                  result = result + " " + monomial.toString();
               else
                  result = result + " + " + monomial.toString();

         }
         if (!result.isEmpty() && result.charAt(1) == '+')
            result = result.substring(2);
         return result;
      }

   }







