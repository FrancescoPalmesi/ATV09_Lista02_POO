public class Main {
    public static void main(String[] args) {
        Conta ContaCorrente = new contaCorrente("João", 1000);
        Conta ContaPoupanca = new contaPoupanca("Maria", 2000);

        System.out.println("Saldo inicial da Conta Corrente: " + ContaCorrente.getSaldo());
        System.out.println("Saldo inicial da Conta Poupança: " + ContaPoupanca.getSaldo());

        ContaCorrente.sacar(100);
        ContaPoupanca.sacar(100);

        ContaCorrente.depositar(200);
        ContaPoupanca.depositar(200);

        ContaPoupanca.transferir(ContaCorrente, 300);

        System.out.println("Saldo final da Conta Corrente: " + ContaCorrente.getSaldo());
        System.out.println("Saldo final da Conta Poupança: " + ContaPoupanca.getSaldo());
    }
}
