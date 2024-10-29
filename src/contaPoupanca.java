public class contaPoupanca extends Conta {
    public contaPoupanca(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double saldoComJuros = getSaldo() - (valor * 1.05); // Cobrança de 5% de juros
        if (saldoComJuros >= 0) {
            setSaldo(saldoComJuros);
            System.out.println("Saque realizado. Novo saldo: " + getSaldo());
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        double valorComAcrescimo = valor * 1.10; // Acréscimo de 10%
        setSaldo(getSaldo() + valorComAcrescimo);
        System.out.println("Depósito realizado. Novo saldo: " + getSaldo());
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (contaDestino instanceof contaCorrente) {
            sacar(valor);
            if (getSaldo() >= 0) { // Verifica se o saque foi realizado
                contaDestino.depositar(valor);
            }
        } else {
            System.out.println("Transferências só podem ser feitas para Conta Corrente.");
        }
    }
}
