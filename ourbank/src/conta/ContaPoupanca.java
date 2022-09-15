package conta;

public class ContaPoupanca extends Conta {
	
	private int tipoConta = 2;
	
	
	//construtores
	public ContaPoupanca() {
		
	}

	public ContaPoupanca(int numeroConta, int agencia, double saldo, String nome, String cpf, String senha) {
		setNumeroConta(numeroConta);
		setAgencia(agencia);
		setSaldo(saldo);
		setNome(nome);
		setCpf(cpf);
		setSenha(senha);
	}

	//getters e setters
	public int getTipoConta() {
		return tipoConta;
	}
	
}
