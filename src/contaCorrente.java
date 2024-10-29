public class contaCorrente extends Conta {
    public contaCorrente(String titular, double saldo) {
        super(titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double saldoComJuros = getSaldo() - (valor * 1.01); // Cobrança de 1% de juros
        if (saldoComJuros >= 0) {
            setSaldo(saldoComJuros);
            System.out.println("Saque realizado. Novo saldo: " + getSaldo());
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void depositar(double valor) {
        setSaldo(getSaldo() + valor); // Sem acréscimo no valor do depósito
        System.out.println("Depósito realizado. Novo saldo: " + getSaldo());
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (contaDestino instanceof contaPoupanca) {
            sacar(valor);
            if (getSaldo() >= 0) { // Verifica se o saque foi realizado
                contaDestino.depositar(valor);
            }
        } else {
            System.out.println("Transferências só podem ser feitas para Conta Poupança.");
        }
    }
}