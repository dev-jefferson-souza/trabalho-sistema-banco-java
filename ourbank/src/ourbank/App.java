package ourbank;

import conta.Cliente;
import conta.Conta;
import conta.ContaCorrente;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
	}
	
	

}
