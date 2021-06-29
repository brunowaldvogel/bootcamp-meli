package Aula2TT;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nome;
    private List<Funcionario> funcionarios;
    public static BigDecimal lucroMensal = new BigDecimal(15000000);

    public Empresa(String nome) {
        this.nome = nome;
        this.funcionarios = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void addFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public static void setLucroMensal(BigDecimal lucroMensal) {
        Empresa.lucroMensal = lucroMensal;
    }
}
