package Aula2TT;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Empresa mercadoLivre = new Empresa("Mercado Livre");
        Empresa.setLucroMensal(new BigDecimal(150000));

        Funcionario tecnico = new Tecnico("Maria Luiza", "452.123.487-19", 2);
        Funcionario analista = new Analista("Luis Felipe", "452.878.983-23", 3);
        Funcionario gerente = new Gerente("Laura Lima", "462.871.282-32", 4);
        Funcionario diretor = new Diretor("Joao Pedro", "427.392.799-78");
        Funcionario pj = new FuncionarioPJ("Marcos Jim", "462.312.987-65", 40, new BigDecimal(60));

        mercadoLivre.addFuncionario(tecnico);
        mercadoLivre.addFuncionario(analista);
        mercadoLivre.addFuncionario(gerente);
        mercadoLivre.addFuncionario(diretor);
        mercadoLivre.addFuncionario(pj);

        mercadoLivre.getFuncionarios().forEach(Funcionario::pagarSalario);
    }
}
