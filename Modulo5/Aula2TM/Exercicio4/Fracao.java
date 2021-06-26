// Author: Bruno Waldvogel
// Exercise: Exercicio 4

package Aula2TM.Exercicio4;

import java.util.Objects;

public class Fracao {
    private int numerator;
    private int denominator;

    public Fracao() {}

    public Fracao(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fracao simplify(int numerator, int denominator) {
        int commonMultiple = leastCommonMultiple(numerator, denominator);
    
        int simplifiedNumerator = numerator / commonMultiple;
        int simplifiedDenominator = denominator / commonMultiple;

        return new Fracao(simplifiedNumerator, simplifiedDenominator);
    }

    public static int leastCommonMultiple(int number1, int number2) {
        if (number1 == 0)
            return number2;
        return leastCommonMultiple(number2 % number1, number1);
    }

    public Fracao add(Fracao other) {
        int commonMultiple = leastCommonMultiple(this.denominator, other.denominator);
        int finalDenominator = (this.denominator * other.denominator) / commonMultiple;
        int finalNumerator = 
            (this.numerator) * (finalDenominator / this.denominator) + 
            (other.numerator) * (finalDenominator / other.denominator);

        return simplify(finalNumerator, finalDenominator);
    }

    public Fracao add(int numero) {
        return add(new Fracao(numero, 1));
    }

    public Fracao subtract(Fracao other) {
        int commonMultiple = leastCommonMultiple(this.denominator, other.denominator);
        int finalDenominator = (this.denominator * other.denominator) / commonMultiple;
        int finalNumerator = 
            (this.numerator) * (finalDenominator / this.denominator) - 
            (other.numerator) * (finalDenominator / other.denominator);

        return simplify(finalNumerator, finalDenominator);
    }

    public Fracao subtract(int numero) {
        return subtract(new Fracao(numero, 1));
    }

    public Fracao multiply(Fracao other) {
        int finalNumerator = this.numerator * other.numerator;
        int finalDenominator = this.denominator * other.denominator;

        return simplify(finalNumerator, finalDenominator);
    }

    public Fracao multiply(int numero) {
        return multiply(new Fracao(numero, 1));
    }

    public Fracao divide(Fracao other) {
        int finalNumerator = this.numerator * other.denominator;
        int finalDenominator = this.denominator * other.numerator;

        return simplify(finalNumerator, finalDenominator);
    }

    public Fracao divide(int numero) {
        return divide(new Fracao(numero, 1));
    }

    public int getNumerator() {
        return this.numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Fracao)) {
            return false;
        }
        Fracao fracao = (Fracao) o;
        return numerator == fracao.numerator && denominator == fracao.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return getNumerator() + "/" + getDenominator();
    }
}
