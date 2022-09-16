package registro;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import conta.Conta;

public class RegistrosDoPrograma {

	static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	static String date = LocalDateTime.now().format(format);

	public static void registroMovimentacoes() throws IOException {

		BufferedWriter registro = new BufferedWriter(new FileWriter("./Temp/"));

		for (int i = 0; i < Conta.getQtdMovimentacao(); i++) {

			if (Conta.getVetorTipoDaMovimentacao(i).equals("Sacar")) {
				registro.append("==========Saque=========\n");
				registro.append("Realizador do Saque: \n" + Conta.getVetorCPF(i) + "\n");
				registro.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				registro.append("Valor sacado: \nR$ " + Conta.getVetorValor(i) + "\n");
				registro.append("Taxa cobrada para movimentações: \nR$ 0.10\n");
				registro.append("Novo saldo: \nR$ " + Conta.getVetorSaldo(i) + "\n");
				registro.append("Data: \n" + Conta.getVetorTempo(i) + "\n");
			} else if (Conta.getVetorTipoDaMovimentacao(i).equals("Depositar")) {
				registro.append("==========Deposito==========\n");
				registro.append("Realizador do Deposito: \n" + Conta.getVetorCPF(i) + "\n");
				registro.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				registro.append("Valor depositado: \nR$ " + Conta.getVetorValor(i) + "\n");
				registro.append("Taxa cobrada para movimentações: \nR $0.10\n");
				registro.append("Novo saldo: \nR$ " + Conta.getVetorSaldo(i) + "\n");
				registro.append("Data: \n" + Conta.getVetorTempo(i) + "\n");
			} else if (Conta.getVetorTipoDaMovimentacao(i).equals("Transferência")) {
				registro.append("=======Transferência=======\n");
				registro.append("Realizador da transferência: \n" + Conta.getVetorCPF(i) + "\n");
				registro.append("Agência da conta: " + Conta.getVetorAgencia(i) + "\n");
				registro.append("Valor transferido: \nR$ " + Conta.getVetorValor(i) + "\n");
				registro.append("Taxa cobrada para transferências: \nR$ 0.20\n");
				registro.append("Novo saldo: \nR$ " + Conta.getVetorSaldo(i) + "\n");
				registro.append("Data: \n" + Conta.getVetorTempo(i) + "\n");

			}
		}
		registro.close();
	}
	
	public static void registroRelatorioDeSaldo(String nome, String cpf, double saldo) throws IOException {
		
		BufferedWriter registro = new BufferedWriter(new FileWriter("./Temp1/"));
		
		registro.append("===========Saldo===========\n");
		registro.append("O seu saldo é de: R$ " + saldo +"\n");
		registro.append("Data: \n" + date + "\n");
		registro.close();
	}
	
	public static void registroRelatorioDeTributacao(String cpf) throws IOException {
		
		BufferedWriter registro = new BufferedWriter(new FileWriter("./Temp2/"));
		
		registro.append("=========Tributação=========\n");
		registro.append("Para cada saque é cobrado o valor de R$0.10 (dez centavos).\n");
		registro.append("Para cada depósito é cobrado o valor de R$0.10 (dez centavos).\n");
		registro.append("Para cada transferência é cobrado o valor de R$0.20 (vinte centavos).\n");
		registro.append("O total gasto foi de: R$"+ Conta.getQtdMovimentacao()*0.10+".\n");
		registro.close();
	}
	
	public static void registroPoupanca(double valor, int dias) throws IOException {
		
		BufferedWriter registro = new BufferedWriter(new FileWriter("./Temp3/"));
		
		registro.append("=====Aplicação da Poupança (Simulação)=====\n");
		registro.append("Com uma aplicação de " + valor + " por " + dias + " dias, \nseu rendimento será de R$" + valor*dias*0.003/30 +" !\n");
		registro.append("Data: \n" + date + "\n");
		registro.close();
	}
	
	public static void registroNumeroDeContas(int count, int agencia) throws IOException {
		
		BufferedWriter registro = new BufferedWriter(new FileWriter("./Temp4/"));
		
		registro.append("====Quantidade de contas por Agencia====\n");
		registro.append("A quantidade de contas na agência " + agencia + " \né igual a: " + count+".\n");
		registro.append("Data: \n" + date + "\n");
		registro.close();
	}
	
	public static void registroContas () throws IOException {
		
		BufferedWriter registro = new BufferedWriter(new FileWriter("./Temp5/"));
		
		registro.append("======Registro de Contas======\n");
		for (Conta value : listas.MapConta.getMapaContaOrdem().values()) {
			registro.append("\n"+value.getNome()+" "+value.getCpf()+" "+value.getAgencia()+"\n");
		}
		registro.append("Data: " + date + "\n");
		registro.close();
	}
	
	public static void registroOurbank(double total) throws IOException {
		
		BufferedWriter registro = new BufferedWriter(new FileWriter("./Temp6/"));
		
		registro.append("=====Capital armazenado no banco======\n");
		registro.append("\nO valor do capital armazenado no banco é de: R$"+ total +".\n");
		registro.append("Data: \n" + date + "\n");
		registro.close();
	}

}
