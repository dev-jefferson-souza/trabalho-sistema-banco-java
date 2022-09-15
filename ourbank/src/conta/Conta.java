package conta;

import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class Conta {
	
	Scanner leia = new Scanner(System.in);
	
	DecimalFormat df = new DecimalFormat("0.00"); //escolher quantas casas decimais 
	
	private int numeroConta;
	private int agencia;
	private double saldo = 0;
	private String nome;
	private String cpf;
	private String senha;
	
	//métodos
	public boolean sacar() {
		System.out.println("Quanto você deseja sacar?");
		double valorDigitado = leia.nextDouble();
		if(this.saldo < (valorDigitado + 0.10)) {
			System.out.println("Saldo insuficiente.");
			return false;
		}
		else {
			double novoSaldo = this.saldo - (valorDigitado + 0.10);
			saldo = novoSaldo;
			System.out.println("Saque concluído.");
			return true;
		}
	}
	
	public void depositar() {
		System.out.println("Digite o valor que você deseja depositar: ");
		double valorDigitado = leia.nextDouble();
		if(valorDigitado >= 0.10) {
			double novoSaldo = this.saldo + valorDigitado - 0.10;
			saldo = novoSaldo;
		} else {
			System.out.println("Depósito mal sucedido. A quantia digitada não é válida.");
		}
	}
	
	//construtore
	public Conta() {
		super();
	}

	public Conta(int numeroConta, int agencia, double saldo, String nome, String cpf, String senha) {
		super();
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
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
