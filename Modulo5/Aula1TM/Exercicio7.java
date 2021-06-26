// Author: Bruno Waldvogel
// Java - Aula 3 - Exercício 2 -> Exercício 2

package Aula1TM;

import java.text.DecimalFormat;

public class Exercicio7 {
    private static DecimalFormat df2 = new DecimalFormat("#.##");

    private static void printAnnualValuationsUntilFirstLessThanSecond(Company a, Company b) {
        int year = 2021;

        if (b.getValuation() > a.getValuation() && b.getAnnualGrowth() > a.getAnnualGrowth()) {
            System.out.println("A primeira empresa nunca chegará no valuation da segunda");
            return;
        }

        while (a.getValuation() < b.getValuation()) {
            System.out.println(a.getName() + " - " + "01/01/" + year + " - Valor da empresa: " + df2.format(a.getValuation()) + "m");
            System.out.println();
            System.out.println(b.getName() + " - " + "01/01/" + year + " - Valor da empresa: " + df2.format(b.getValuation()) + "m");
            System.out.println();

            a.setValuation(a.getValuation() * (1 + a.getAnnualGrowth()));
            b.setValuation(b.getValuation() * (1 + b.getAnnualGrowth()));
            year++;
        }

        System.out.println(a.getName() + " - " + "01/01/" + year + " - Valor da empresa: " + df2.format(a.getValuation()) + "m");
        System.out.println();
        System.out.println(b.getName() + " - " + "01/01/" + year + " - Valor da empresa: " + df2.format(b.getValuation()) + "m");
    }

    public static void main(String[] args) {
        Company empresaX = new Company("Empresa X", 1.48, 1.3);
        Company empresaY = new Company("Empresa Y", 0.32, 18.4);

        printAnnualValuationsUntilFirstLessThanSecond(empresaX, empresaY);
    }
}
