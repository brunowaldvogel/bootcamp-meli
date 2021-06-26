package Aula2TM.Exercicio2;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        System.out.println(counter);
        
        counter.increment();
        System.out.println(counter);

        counter.decrement();
        System.out.println(counter);
    }
}
