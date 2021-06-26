// Author: Bruno Waldvogel

package Aula1TM;

import java.util.Scanner;

public class Exercicio1 {

    private static void printEvenNumbers(int n) {
        int counter = 0, i = 0;

        while (counter < n) {
            if (i % 2 == 0) {
                System.out.println(i);
                counter++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Insira n (número de pares): ");
            int number = scanner.nextInt();
    
            printEvenNumbers(number);
    
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Por favor, digite apenas números!");
        }
    }
}