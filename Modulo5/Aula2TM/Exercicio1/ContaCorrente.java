// Author: Bruno Waldvogel
// Exercise: Exercicio 1

package Aula2TM.Exercicio1;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaCorrente {
    public int numero;
    public String cpfTitular;
    public BigDecimal saldo;

    public ContaCorrente() {
        saldo = new BigDecimal(0);
        cpfTitular = "";
        numero = 0;
    }

    public ContaCorrente(int numero, String cpfTitular) {
        this.numero = numero;
        this.cpfTitular = cpfTitular;
        this.saldo = new BigDecimal(0);
    }

    public ContaCorrente(ContaCorrente conta) {
        this.numero = conta.numero;
        this.cpfTitular = conta.cpfTitular;
        this.saldo = conta.saldo;
    }

    public void saque(BigDecimal quantia) {
        if (quantia.doubleValue() > 0) {
            BigDecimal quantidadeSaldoAposSaque = saldo.subtract(quantia);

            if (quantidadeSaldoAposSaque.doubleValue() >= 0) {
                System.out.println("Sacando " + quantia.doubleValue() + " da conta " + this.numero);
                setSaldo(quantidadeSaldoAposSaque);
            }
            else {
                System.out.println("Não existe o montante desejado na conta!");
            }
        } else {
            System.out.println("Informe valores positivos!");
        }
    } 

    public void deposito(BigDecimal quantia) {
        if (quantia.doubleValue() > 0) {
            System.out.println("Depositando " + quantia.doubleValue() + " na conta " + this.numero);
            setSaldo(saldo.add(quantia));
        } else {
            System.out.println("Informe valores positivos!");
        }
    }

    public void devolucao(ContaCorrente origem, BigDecimal valorDevolucao) {
        BigDecimal valorRestanteContaOrigem = origem.getSaldo().subtract(valorDevolucao);

        if (valorRestanteContaOrigem.doubleValue() >= 0) {
            System.out.println("Devolvendo " + valorDevolucao.doubleValue() + 
                " da conta " + origem.getNumero() + " para a conta " + this.numero);
            origem.setSaldo(origem.getSaldo().subtract(valorDevolucao));
            setSaldo(saldo.add(valorDevolucao));
        } else {
            System.out.println("A conta origem não possui o montante para realizar a devolução!");
        }
    }

    public void transferencia(ContaCorrente destino, BigDecimal valorTransferencia) {
        BigDecimal valorRestanteConta = saldo.subtract(valorTransferencia);

        if (valorRestanteConta.doubleValue() >= 0) {
            System.out.println("Transferindo " + valorTransferencia.doubleValue() +
                 " da conta " + this.numero + " para a conta " + destino.getNumero());
            destino.setSaldo(destino.getSaldo().add(valorTransferencia));
            setSaldo(saldo.subtract(valorTransferencia));
        } else {
            System.out.println("A conta origem não possui o montante para realizar a transferência!");
        }
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCpfTitular() {
        return this.cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ContaCorrente)) {
            return false;
        }
        ContaCorrente contaCorrente = (ContaCorrente) o;
        return numero == contaCorrente.numero && 
                Objects.equals(cpfTitular, contaCorrente.cpfTitular) && Objects.equals(saldo, contaCorrente.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, cpfTitular, saldo);
    }

    @Override
    public String toString() {
        return "{" +
            " numero='" + getNumero() + "'" +
            ", cpfTitular='" + getCpfTitular() + "'" +
            ", saldo='" + getSaldo() + "'" +
            "}";
    }
}
