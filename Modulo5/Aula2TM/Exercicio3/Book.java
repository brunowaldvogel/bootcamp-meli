// Author: Bruno Waldvogel
// Exercise: Exercicio 3

package Aula2TM.Exercicio3;

import java.util.Objects;

public class Book {
    private String titulo;
    private String isbn;
    private String autor;
    private boolean emprestado;

    public Book() {
        this.emprestado = false;
    }

    public Book(String titulo, String isbn, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.emprestado = false;
    }

    public Book emprestimo() {
        this.emprestado = true;
        return this;
    }

    public void devolver() {
        if (emprestado)
            this.emprestado = false;
        else
            System.out.println("O livro não está emprestado!");
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(titulo, book.titulo) && 
               Objects.equals(isbn, book.isbn) && 
               Objects.equals(autor, book.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, isbn, autor);
    }

    @Override
    public String toString() {
        return titulo + ", " + isbn + ", " + autor + ", Emprestado: " + emprestado;
    }

    // Erro! Mensagem: The method tostring() of type Book must override or implement a supertype method
    // Isto acontece pois a superclasse dessa classe não possui a funcao tostring() para ser "overriden"
    // @Override
    // public String tostring() {
    //     return getTitulo() + ", " + getIsbn() + ", " + getAutor();
    // }
}
