// Author: Bruno Waldvogel

package Aula1TM;

import java.util.Scanner;

public class Exercicio3 {
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

    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Insira o número: ");
            long number = scanner.nextLong();
    
            if (isPrime(number)) {
                System.out.println("O número é primo!");
            } else {
                System.out.println("O número não é primo!");
            }
    
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Por favor, digite apenas números!");
        }
    }
}
