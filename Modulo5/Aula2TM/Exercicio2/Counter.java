// Author: Bruno Waldvogel
// Exercise: Exercicio 2

package Aula2TM.Exercicio2;

import java.util.Objects;

public class Counter {
    private long value;

    public Counter() {
        this.value = 0;
    }

    public Counter(long value) {
        this.value = value;
    }

    public Counter(Counter other) {
        this.value = other.value;
    }

    public void increment() {
        setValue(value + 1);
    }

    public void decrement() {
        if (value > 0) {
            setValue(value - 1);
        } else {
            System.out.println("O valor do contador é zero!");
        }
    }

    public long getValue() {
        return this.value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Counter)) {
            return false;
        }
        Counter counter = (Counter) o;
        return value == counter.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "Valor do Contador: " + getValue() + "\n";
    }
}
