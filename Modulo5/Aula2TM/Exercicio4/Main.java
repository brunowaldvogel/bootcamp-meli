package Aula2TM.Exercicio4;

public class Main {
    public static void main(String[] args) {
        Fracao fracao1 = new Fracao(2, 3);
        Fracao fracao2 = new Fracao(7, 3);
        Fracao fracao3 = new Fracao(1, 3);

        Fracao sumResult = fracao1.add(fracao2);
        System.out.println(fracao1 + " + " + fracao2 + " = " + sumResult);

        Fracao subtractResult = fracao1.subtract(fracao3);
        System.out.println(fracao1 + " - " + fracao3 + " = " + subtractResult);

        Fracao multiplyResult = fracao1.multiply(fracao2);
        System.out.println(fracao1 + " x " + fracao2 + " = " + multiplyResult);

        Fracao divideResult = fracao1.divide(fracao2);
        System.out.println(fracao1 + " / " + fracao2 + " = " + divideResult);
    }
}
