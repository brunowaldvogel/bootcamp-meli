// Author: Bruno Waldvogel
// Java - Aula 3 - Exercício 2 -> Exercício 2

package Aula1TM;

import java.util.Objects;

public class Company {
    public String name;
    public double annualGrowth;
    public double valuation;

    public Company() {
    }

    public Company(double annualGrowth, double valuation) {
        this.annualGrowth = annualGrowth;
        this.valuation = valuation;
    }

    public Company(String name, double annualGrowth, double valuation) {
        this.name = name;
        this.annualGrowth = annualGrowth;
        this.valuation = valuation;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company name(String name) {
        setName(name);
        return this;
    }

    public double getAnnualGrowth() {
        return this.annualGrowth;
    }

    public void setAnnualGrowth(double annualGrowth) {
        this.annualGrowth = annualGrowth;
    }

    public double getValuation() {
        return this.valuation;
    }

    public void setValuation(double valuation) {
        this.valuation = valuation;
    }

    public Company annualGrowth(double annualGrowth) {
        setAnnualGrowth(annualGrowth);
        return this;
    }

    public Company valuation(double valuation) {
        setValuation(valuation);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Company)) {
            return false;
        }
        Company company = (Company) o;
        return annualGrowth == company.annualGrowth && valuation == company.valuation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(annualGrowth, valuation);
    }

    @Override
    public String toString() {
        return "{" +
            " annualGrowth='" + getAnnualGrowth() + "'" +
            ", valuation='" + getValuation() + "'" +
            "}";
    }
}
