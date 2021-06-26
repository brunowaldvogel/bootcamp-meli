// Author: Bruno Waldvogel

package Aula1TM;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio5 {
    private static boolean hasSpecificNumberOfDigits(int number, int digitCount, int digit) {
        int counterOfDigits = 0;
        
        while (number > 0 && counterOfDigits < digitCount)
        {
            if (number % 10 == digit) {
                counterOfDigits++;
            }
            number = number / 10;
        }

        if (counterOfDigits >= digitCount) {
            return true;
        }
    
        return false;
    }

    private static void printNaturalNumbers(int firstNaturalNumbers, int digitCount, int digit) {
        List<String> naturalNumbers = new ArrayList<>();
        int counter = 0;
        int i = Integer.parseInt(Integer.toString(digit).repeat(digitCount));

        while (counter < firstNaturalNumbers) {
            if (hasSpecificNumberOfDigits(i, digitCount, digit)) {
                naturalNumbers.add(Integer.toString(i));
                counter++;
            }
            i++;
        }

        System.out.println(String.join(", ", naturalNumbers));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Insira n (n primeiros números naturais): ");
            int firstNaturalNumbers = scanner.nextInt();
            System.out.print("Insira m (quantidade de dígitos): ");
            int digitCount = scanner.nextInt();
            System.out.print("Insira d (dígito): ");
            int digit = scanner.nextInt();

            printNaturalNumbers(firstNaturalNumbers, digitCount, digit);

            scanner.close();
        } catch (Exception ex) {
            System.out.println("Por favor, digite números e números positivos!");
        }
    }
}
