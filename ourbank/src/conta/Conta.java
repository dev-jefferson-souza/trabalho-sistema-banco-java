package conta;

import java.text.DecimalFormat;
import java.util.Scanner;

import enumSistema.tipoUsuario;
import listas.MapUsuario;

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
	//EFETUANDO O SAQUE
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
	
	//EFETUANDO DEPÓSITO
	public void depositar() {
		System.out.println("Digite o valor que você deseja depositar: ");
		double valorDigitado = leia.nextDouble();
		if(valorDigitado >= 0.10) {
			double novoSaldo = this.saldo + valorDigitado - 0.10;
			saldo = novoSaldo;
			System.out.println("\nDepósito concluído.");
		} else {
			System.out.println("Depósito mal sucedido. A quantia digitada não é válida.");
		}
	}
	
	//MOSTRANDO RELATÓRIO DE TRIBUTAÇÃO DA CONTA CORRENTE
	public void relatorioTributacaoCorrente() {
		System.out.println("Relatório de Tributação da Conta Corrente");
		System.out.println("\nAté o momento foram gastos:\n[GASTOS ATÉ O MOMENTO]\n");
		System.out.println("Para cada saque efetuado, será descontado de sua conta R$ 0,10 (dez centavos).");
		System.out.println("Para cada depósito efetuado, será descontado de sua conta R$ 0,10 (dez centavos).");
		System.out.println("Para cada transferência efetuada, será descontado da conta do remetente R$ 0,20 (vinte centavos).");
	}
	
	//SIMULANDO OS RENDIMENTOS DE UMA CONTA POUPANÇA
	public void relatorioRendimentos() {
		System.out.println("Relatório de rendimento da Conta Poupança\n");
		
		System.out.println("Quantos dias você deseja utilizar nessa simulação?");
		int dias = leia.nextInt();
		
		System.out.println("\nE qual valor o valor você deseja utilizar?");
		double valor = leia.nextDouble();
		
		double renda = valor * (0.020/100) * dias ;
		System.out.println("\nA poupança possuí uma média de renda diária de 0,022%.");
		System.out.println("O valor de R$ " + valor + " durante " + dias + " dias renderia: R$" +df.format(renda) );
	}
	
	//FAZENDO TRANSFERÊNCIA PARA OUTRA CONTA [PARA FAZER]
	public void transferir() {
		double valor = leia.nextInt();
		String contaCpf = leia.next();
		Conta destino;
		if (this.saldo >= valor) {
			this.saldo = this.saldo - valor;
			destino.saldo = destino.saldo + valor;
			System.out.println("Transferência feita com sucesso.");
		} else {
			System.out.println("Não há saldo suficiente para transfer�ncia");
		}
	}
	
	//construtores
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
