package Aula2TM.Exercicio5;

import java.time.DateTimeException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Data dateNow = new Data();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite uma data (formato dd/MM/yyyy): ");
            String inputDate = scanner.nextLine();
            scanner.close();
            dateNow.setDate(inputDate);
        } catch (DateTimeException ex) { 
            System.out.println("Por favor, digite uma data válida!");
            return;
        }
        System.out.println("Data setada no formato ISO: " + dateNow);

        dateNow.incrementDay();
        System.out.println("Data com dia incrementado: " + dateNow);
    }
}
