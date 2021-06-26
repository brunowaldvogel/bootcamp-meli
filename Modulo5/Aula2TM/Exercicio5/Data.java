// Author: Bruno Waldvogel
// Exercise: Exercicio 5

package Aula2TM.Exercicio5;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Data {
    private LocalDate localDate;

    public Data() {
        localDate = LocalDate.now();
    }

    public Data(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setDate(String targetDate) throws DateTimeException {
        try {
            localDate = LocalDate.parse(targetDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (DateTimeException ex) {
            throw ex;
        }
    }

    public void incrementDay() {
        setLocalDate(localDate.plusDays(1));
    }

    public LocalDate getLocalDate() {
        return this.localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Data)) {
            return false;
        }
        Data data = (Data) o;
        return Objects.equals(localDate, data.localDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(localDate);
    }

    @Override
    public String toString() {
        return "{" +
            " Data: '" + getLocalDate() + "'" +
            "}";
    }

}
