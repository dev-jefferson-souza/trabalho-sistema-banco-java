package conta;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import listas.MapConta;
import registro.RegistrosDoPrograma;

public abstract class Conta {
	
	Scanner leia = new Scanner(System.in);
	
	DecimalFormat df = new DecimalFormat("0.00"); //escolher quantas casas decimais 
	
	private int numeroConta;
	private int agencia;
	private double saldo;
	private String nome;
	private String cpf;
	private String senha;
	private static int qtdMovimentacao;
	private double taxaSeguroVida = 0;
	private double tarifa;
	
	private static String vetorTipoDaMovimentacao[] = new String[100];
    private static String vetorCPF[] = new String[100];
    private static String vetorAgencia[] = new String[100];
    private static String vetorValor[] = new String[100];
    private static String vetorSaldo[] = new String[100];
    private static String vetorTempo[] = new String[100];
	
	//métodos
	public double sacar() {
		DateTimeFormatter Format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		System.out.println("Quanto você deseja sacar?");
		double valorDigitado = leia.nextDouble();
		
		if(this.saldo < (valorDigitado + 0.10)) {
			System.out.println("Saldo insuficiente.");
			
		}
		else {
			double novoSaldo = this.saldo - (valorDigitado + 0.10);
			saldo = novoSaldo;
			System.out.println("Saque concluído.");
			
			vetorTipoDaMovimentacao[qtdMovimentacao] = "Sacar";
			vetorCPF[qtdMovimentacao] = this.getNome();
			vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia()));
			vetorValor[qtdMovimentacao] = (String.valueOf(valorDigitado));
	        vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
	        vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(Format2);
			qtdMovimentacao++;
			
			return this.tarifa += 0.10;
		}
		return this.tarifa;
	}
	
	//EFETUANDO DEPÓSITO
	public double depositar() {
		DateTimeFormatter Format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			System.out.println("Digite o valor que você deseja depositar: ");
			double valorDigitado = leia.nextDouble();
		
			if(valorDigitado >= 0.10) {
				double novoSaldo = this.saldo + valorDigitado - 0.10;
				saldo = novoSaldo;
				System.out.println("\nDepósito concluído.");
				
				vetorTipoDaMovimentacao[qtdMovimentacao] = "Depositar";
				vetorCPF[qtdMovimentacao] = this.getNome();
				vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia()));
				vetorValor[qtdMovimentacao] = (String.valueOf(valorDigitado));
		        vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
		        vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(Format2);
				qtdMovimentacao++;
				
				return this.tarifa += 0.10;
				
			} else {
				System.out.println("Depósito mal sucedido. A quantia digitada não é válida.");
			}
			return this.tarifa;
	}
	
	public double transferir() {
		DateTimeFormatter Format2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
			System.out.println("Digite o valor que gostaria de transferir: ");
			double valor = leia.nextDouble();
			System.out.println("Digite o cpf da conta que gostaria \nde transferir para: ");
			String cpf = leia.next();
			
			if (valor < 0.20) {
				System.out.println("O valor digitado não é válido.");
			} else if (this.saldo >= valor + 0.20) {
			this.saldo = this.saldo - valor - 0.20;
			MapConta.getMapaConta().get(cpf).setSaldo(MapConta.getMapaConta().get(cpf).getSaldo() + valor);
			System.out.println("Transferência feita com sucesso na conta " + MapConta.getMapaConta().get(cpf).getNumeroConta());
			
			vetorTipoDaMovimentacao[qtdMovimentacao] = "Transferência";
			vetorCPF[qtdMovimentacao] = this.getNome();
			vetorAgencia[qtdMovimentacao] = (String.valueOf(this.getAgencia()));
			vetorValor[qtdMovimentacao] = (String.valueOf(valor));
	        vetorSaldo[qtdMovimentacao] = (String.valueOf(this.getSaldo())); 
	        vetorTempo[qtdMovimentacao] = LocalDateTime.now().format(Format2);
	        qtdMovimentacao++;
	        
	        return this.tarifa += 0.20;
		} else {
			System.out.println("Não há saldo suficiente para transfer�ncia");
		}
			return this.tarifa;
	}
	
	//SEGURO DE VIDA
		public void seguroVida() {
			System.out.println("Seguro de Vida\n");
			System.out.println("Atenção: 20% (vinte por cento) do valor segurado será debitádo de sua conta.");
			System.out.println("Qual o valor você deseja segurar?");
			double valorSegurado = leia.nextDouble();
			double seguroTaxa = valorSegurado * 0.20;
			double novoSaldo = this.saldo - seguroTaxa;
			
			if(valorSegurado <= 0){
				System.out.println("\nO valor digitado é inválido.");
			}
			else if(this.saldo >= seguroTaxa) {
				this.taxaSeguroVida += seguroTaxa;
				this.saldo = novoSaldo;
				System.out.println("\nO seguro foi contratado com sucesso.");
			}
				else {
					System.out.println("Não há saldo o suficiente para a contratação do seguro.");
			}
		}
	
	//MOSTRANDO RELATÓRIO DE TRIBUTAÇÃO DA CONTA CORRENTE
	public void relatorioTributacaoCorrente() {
			System.out.println("Relatório de Tributação da Conta Corrente");
			System.out.println("\nAté o momento foram gastos com tarifas: R$" + df.format(tarifa));
			System.out.println("Para cada saque efetuado, será descontado de sua conta R$ 0,10 (dez centavos).");
			System.out.println("Para cada depósito efetuado, será descontado de sua conta R$ 0,10 (dez centavos).");
			System.out.println("Para cada transferência efetuada, será descontado da conta do remetente R$ 0,20 (vinte centavos).");
		if(this.taxaSeguroVida > 0 ) {
			System.out.println("Taxa tributada referente ao seguro de vida: R$" + df.format(this.taxaSeguroVida));
		}
	}	
		//SIMULANDO OS RENDIMENTOS DE UMA CONTA POUPANÇA
	public void relatorioRendimentos() throws IOException {
			System.out.println("Relatório de rendimento da Conta Poupança\n");
			
			System.out.println("Quantos dias você deseja utilizar nessa simulação?");
			int dias = leia.nextInt();
			
			System.out.println("\nE qual o valor você deseja utilizar?");
			double valor = leia.nextDouble();
			
			double renda = valor * (0.020/100) * dias ;
			System.out.println("\nA poupança possuí uma média de renda diária de 0,022%.");
			System.out.println("O valor de R$ " + valor + " durante " + dias + " dias renderia: R$" +df.format(renda) );
			RegistrosDoPrograma.registroPoupanca(valor, dias);
	}
	//construtore
	public Conta() {

	}

	public Conta(int numeroConta, int agencia, double saldo, String nome, String cpf, String senha) {
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
	public static int getQtdMovimentacao() {
		return qtdMovimentacao;
	}

	public static String getVetorTipoDaMovimentacao(int posicao) {
		return vetorTipoDaMovimentacao[posicao];
	}
	
	public static String getVetorCPF(int posicao) {
		return vetorCPF[posicao];
	}
	
	public static String getVetorAgencia(int posicao) {
		return vetorAgencia[posicao];
	}
	
	public static String getVetorValor(int posicao) {
		return vetorValor[posicao];
	}
	
	public static String getVetorSaldo(int posicao) {
		return vetorSaldo[posicao];
	}
	
	public static String getVetorTempo(int posicao) {
		return vetorTempo[posicao];
	}
	
}
