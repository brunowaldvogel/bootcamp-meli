package Aula2TT;

public abstract class Funcionario {

    protected String nome;
    protected String cpf;

    public Funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public abstract void pagarSalario();
}
