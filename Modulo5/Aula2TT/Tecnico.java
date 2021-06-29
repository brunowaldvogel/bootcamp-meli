package Aula2TT;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Tecnico extends FuncionarioCLT {

    private int metasBatidas;
    private final float bonificacao = 0.05f;
    private final BigDecimal salarioBase = new BigDecimal(3200);
    private final int jornadaHorasSemanais = 40;
    private final int horasDescansoRemuneradas = 0;

    public Tecnico(String nome, String cpf, int metasBatidas) {
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

        System.out.println("Salário pago ao Técnico " + this.nome + " de R$" + salarioTotal.doubleValue() + ".");
    }
}
