package conta;

import pessoal.Usuario;

public class ContaCorrente extends Conta {
	
	private String tipoConta;
	
	
	//construtores
	public ContaCorrente() {
		super();
	}
	
	public ContaCorrente(int numeroConta, int agencia, double saldo, Usuario cliente, String tipoConta) {
		super(numeroConta, agencia, saldo, cliente);
		this.tipoConta = tipoConta;
	}

	//getters e setters
	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	
}
