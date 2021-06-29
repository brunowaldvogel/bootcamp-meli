package Aula2TT;

import java.math.BigDecimal;

public abstract class FuncionarioCLT extends Funcionario {

    public FuncionarioCLT(String nome, String cpf) {
        super(nome, cpf);
    }

    public abstract void pagarSalario();
}
