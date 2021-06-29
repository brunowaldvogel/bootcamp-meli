package Aula2TT;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Gerente extends FuncionarioCLT {

    private int metasBatidas;
    private final float bonificacao = 0.125f;
    private final BigDecimal salarioBase = new BigDecimal(6000);
    private final int jornadaHorasSemanais = 36;
    private final int horasDescansoRemuneradas = 4;

    public Gerente(String nome, String cpf, int metasBatidas) {
        super(nome, cpf);
        this.metasBatidas = metasBatidas;
    }

    public int getMetasBatidas() {
        return metasBatidas;
    }

    public void setMetasBatidas(int metasBatidas) {
        this.metasBatidas = metasBatidas;
    }

    public float getBonificacao() {
        return bonificacao;
    }

    @Override
    public void pagarSalario() {
        BigDecimal bonificacaoRecebida = BigDecimal.valueOf(salarioBase.doubleValue() * (bonificacao * metasBatidas));
        BigDecimal salarioTotal = salarioBase.add(bonificacaoRecebida);
        salarioTotal = salarioTotal.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Salário pago ao Gerente " + this.nome + " de R$" + salarioTotal.doubleValue() + ".");
    }
}
