package Aula2TT;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Diretor extends FuncionarioCLT {

    private final float participacaoLucros = 0.03f;
    private final BigDecimal salarioBase = new BigDecimal(15000);

    public Diretor(String nome, String cpf) {
        super(nome, cpf);
    }

    public float getParticipacaoLucros() {
        return participacaoLucros;
    }

    @Override
    public void pagarSalario() {
        BigDecimal montanteParticipacaoLucros = BigDecimal.valueOf(participacaoLucros * Empresa.lucroMensal.doubleValue());
        BigDecimal salarioTotal = montanteParticipacaoLucros.add(salarioBase);
        salarioTotal = salarioTotal.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Salário pago ao Diretor " + this.nome + " de R$" + salarioTotal.doubleValue() + ".");
    }
}
