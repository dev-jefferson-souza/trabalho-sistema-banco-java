package conta;

public class ContaCorrente extends Conta {
	
	private int tipoConta = 1;
	
	
	//construtores
	public ContaCorrente() {
		
	}

	public ContaCorrente(int numeroConta, int agencia, double saldo, String nome, String cpf, String senha) {
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
