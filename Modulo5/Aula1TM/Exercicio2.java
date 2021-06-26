// Author: Bruno Waldvogel

package Aula1TM;

import java.util.Scanner;

public class Exercicio2 {
    private static void printMultipleNumbers(int number, int nFirstNumbers) {
        for (int i = 0; i < nFirstNumbers; i++) {
            System.out.println(number * i);
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Insira n (número): ");
            int n = scanner.nextInt();
            System.out.print("Insira m (quantidade de múltiplos): ");
            int m = scanner.nextInt();
    
            printMultipleNumbers(n, m);
    
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Por favor, digite apenas números!");
        }
    }
}
