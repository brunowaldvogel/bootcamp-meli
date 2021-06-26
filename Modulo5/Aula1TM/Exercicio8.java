// Author: Bruno Waldvogel
// Java - Aula 3 - Exercício 2 -> Exercício 3

package Aula1TM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio8 {
    private static double calculateTotalPrice(List<Product> products) {
        double totalPrice = 0.0;

        for (Product product : products) {
            totalPrice += product.getPrice() * product.getQuantity();
        }

        return totalPrice;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        int nProducts = 3;

        try {
            for (int i = 0; i < nProducts; i++) {
                System.out.println(String.format("%s %d", "Produto", i + 1));
                System.out.print("Nome: ");
                String name = scanner.nextLine().trim();
                System.out.print("Preço: R$");
                double price = Double.parseDouble(scanner.nextLine().trim());
                System.out.print("Quantidade: ");
                int quantity = scanner.nextInt();
                // Necessary to get the Enter key on the previous line
                scanner.nextLine();
                System.out.println();
                
                Product product = new Product(name, price, quantity);
                products.add(product);
            }
    
            System.out.println("Valor total: R$" + calculateTotalPrice(products));
            scanner.close();
        } catch (Exception ex) {
            System.out.println("Por favor, digite os dados corretamente!");
        }
    }
}
