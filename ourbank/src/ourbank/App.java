package ourbank;

import conta.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//cliente 1
		Cliente cliente1 = new Cliente();
		cliente1.setCpf("000.000.000-00");
		
		Conta conta1 = new ContaCorrente();
		conta1.setCpf(cliente1.cpf);
		conta1.setNome("Rafael");
		conta1.setAgencia(401);
		conta1.setNumeroConta(2934);
		conta1.setSenha("123456");
		conta1.setSaldo(1000.00);
		conta1.depositar(1000.0);
		conta1.sacar(1000.00);
		
		conta1.getSaldo();
		System.out.println(conta1.toString());
		
		
		//cliente 2
		Cliente cliente2 = new Cliente();
		cliente2.setCpf("111.111.111-11");
		
		Conta conta2 = new ContaCorrente();
		conta2.setCpf(cliente2.cpf);
		conta2.setNome("Jefferson");
		conta2.setAgencia(401);
		conta2.setNumeroConta(2936);
		conta2.setSenha("456654");
		conta2.setSaldo(1000.00);
		conta2.depositar(1000.0);
		conta2.sacar(1000.00);
		
		conta2.getSaldo();
		System.out.println(conta2.toString());
		
		
		//cliente 3
		Cliente cliente3 = new Cliente();
		cliente3.setCpf("333.333.333-33");
		
		Conta conta3 = new ContaCorrente();
		conta3.setCpf(cliente3.cpf);
		conta3.setNome("Pedro");
		conta3.setAgencia(401);
		conta3.setNumeroConta(2938);
		conta3.setSenha("456789");
		conta3.setSaldo(1500.00);
		conta3.depositar(1000.0);
		conta3.sacar(1000.00);
		
		conta3.getSaldo();
		System.out.println(conta3.toString());
		
		
		//cliente 4
		Cliente cliente4 = new Cliente();
		cliente4.setCpf("444.444.444-44");
		
		Conta conta4 = new ContaPoupanca();
		conta4.setCpf(cliente2.cpf);
		conta4.setNome("Manuela");
		conta4.setAgencia(402);
		conta4.setNumeroConta(3930);
		conta4.setSenha("789987");
		conta4.setSaldo(30000.00);
		conta4.depositar(2000.0);
		conta4.sacar(1000.00);
		
		conta4.getSaldo();
		System.out.println(conta4.toString());
		
		
		//cliente 5
		Cliente cliente5 = new Cliente();
		cliente5.setCpf("555.555.555-55");
		
		Conta conta5 = new ContaPoupanca();
		conta5.setCpf(cliente2.cpf);
		conta5.setNome("Marcelle");
		conta5.setAgencia(402);
		conta5.setNumeroConta(3932);
		conta5.setSenha("454693");
		conta5.setSaldo(20000.00);
		conta5.depositar(5000.0);
		conta5.sacar(1000.00);
		
		conta5.getSaldo();
		System.out.println(conta5.toString());
		
	}
}

