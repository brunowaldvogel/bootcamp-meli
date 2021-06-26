package Aula2TM.Exercicio3;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", "123", "J.K. Rowling");
        System.out.println(book1);

        book1.emprestimo();
        System.out.println(book1);

        book1.devolver();
        System.out.println(book1);
    }
}
