package Aula2TM.Exercicio1;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente(1, "452.312.312-23");
        ContaCorrente conta2 = new ContaCorrente(2, "450.713.833-25");
        
        conta1.deposito(new BigDecimal(2000));
        conta1.saque(new BigDecimal(1000));

        conta2.deposito(new BigDecimal(5000));
        conta2.saque(new BigDecimal(1000));

        conta2.transferencia(conta1, new BigDecimal(1000));

        conta2.transferencia(conta1, new BigDecimal(500));
        conta2.devolucao(conta1, new BigDecimal(500));

        System.out.println("\nConta 1 depois: " + conta1 + "\n");
        System.out.println("Conta 2 depois: " + conta2 + "\n");
    }
}
