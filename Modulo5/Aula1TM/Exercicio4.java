// Author: Bruno Waldvogel

package Aula1TM;

import java.util.Scanner;

public class Exercicio4 {
    private static boolean isPrime(long number) {
        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void printFirstPrimeNumbers(long quantityOfPrimes) {
        long counter = 0;
        int i = 2;

        while (counter < quantityOfPrimes) {
            if (isPrime(i)) {
                System.out.println(i);
                counter++;
            }
            i++;
        }
    }

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Insira n (quantidade de números primos): ");
            long quantityOfPrimes = scanner.nextLong();
    
            printFirstPrimeNumbers(quantityOfPrimes);
    
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Por favor, digite apenas números!");
        }
    }
}
