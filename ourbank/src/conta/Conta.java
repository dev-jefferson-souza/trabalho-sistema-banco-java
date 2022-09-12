package conta;

import java.text.DecimalFormat;

public abstract class Conta {
	
	DecimalFormat df = new DecimalFormat("0.00"); //escolher quantas casas decimais 
	
	private int numeroConta;
	private int agencia;
	private double saldo = 0;
	private String nome;
	private String cpf;
	private String senha;
	
	//métodos
	public boolean sacar(double valor) {
		if(this.saldo < (valor + 0.10)) {
			System.out.println("Saldo insuficiente.");
			return false;
		}
		else {
			double novoSaldo = this.saldo - (valor + 0.10);
			saldo = novoSaldo;
			System.out.println("Saque concluído.");
			return true;
		}
	}
	
	public void depositar(double valor) {
		double novoSaldo = this.saldo + valor - 0.10;
		saldo = novoSaldo;
	}
	
	//construtores
	public Conta() {
		super();
	}
	
	public Conta(int numeroConta, int agencia, double saldo, Cliente cliente) {
		super();
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.senha = cliente.getSenha();
	}

	//getters e setters
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public double getSaldo() {
		System.out.println("O seu saldo é: " + df.format(saldo));
		return saldo;
	}
	public void setSaldo(double saldo) {
		
		this.saldo = saldo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String string) {
		this.nome = string;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Conta[\n\tnumeroConta=" + numeroConta + ", \n\tagencia=" + agencia + ", \n\tsaldo=" + df.format(saldo) + ", \n\tnome=" + nome
				+ ", \n\tcpf=" + cpf + ", \n\tsenha=" + senha + "\n]";
	}
	

	
	
	
}
