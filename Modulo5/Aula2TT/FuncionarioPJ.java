package Aula2TT;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FuncionarioPJ extends Funcionario {

    private int horasMensaisTrabalhadas;
    private BigDecimal pagamentoPorHoraTrabalhada;

    public FuncionarioPJ(String nome, String cpf, int horasMensaisTrabalhadas, BigDecimal pagamentoPorHoraTrabalhada) {
        super(nome, cpf);
        this.horasMensaisTrabalhadas = horasMensaisTrabalhadas;
        this.pagamentoPorHoraTrabalhada = pagamentoPorHoraTrabalhada;
    }

    public int getHorasMensaisTrabalhadas() {
        return horasMensaisTrabalhadas;
    }

    public void setHorasMensaisTrabalhadas(int horasMensaisTrabalhadas) {
        this.horasMensaisTrabalhadas = horasMensaisTrabalhadas;
    }

    @Override
    public void pagarSalario() {
        BigDecimal salarioTotal = pagamentoPorHoraTrabalhada.multiply(BigDecimal.valueOf(horasMensaisTrabalhadas));
        salarioTotal = salarioTotal.setScale(2, RoundingMode.HALF_UP);

        System.out.println("Salário pago ao Funcionario PJ  " + this.nome + " de R$" + salarioTotal.doubleValue() + ".");
    }
}
