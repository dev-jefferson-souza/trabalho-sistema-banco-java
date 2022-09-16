package menu;

import java.io.IOException;
import java.util.Scanner;

import conta.Conta;
import enumSistema.tipoUsuario;
import listas.MapConta;
import listas.MapUsuario;
import registro.RegistrosDoPrograma;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	static boolean sair = false;
	static int opcao = 0;
	static String cpfConta;

	// método para checar o login
	public static void login(String cpfDigitado, String senhaDigitada) throws IOException {

		// equals compara o conteúdo da String, não sua referência em memória.
		// Verificação do CPF e da senha para efutuar o login.

		if (MapUsuario.getMapaUsuario().containsKey(cpfDigitado)
				&& MapUsuario.getMapaUsuario().get(cpfDigitado).getSenha().equals(senhaDigitada)) {
			System.out.println("Login efetuado com sucesso!\n\n");
			abreMenu(cpfDigitado);
			cpfConta = cpfDigitado;

		} else {
			System.out.println("\nCPF ou senha incorreta.\nTente novamente.");
			System.out.println();
		}
	}

	public static void abreMenu(String cpfDigitado) throws IOException {

		if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.CLIENTE.name())) {
			menuBase(MapConta.getMapaConta().get(cpfDigitado), cpfDigitado);
		} else if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.GERENTE.name())) {
			menuBase(MapConta.getMapaConta().get(cpfDigitado), cpfDigitado);
		} else if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.DIRETOR.name())) {
			menuBase(MapConta.getMapaConta().get(cpfDigitado), cpfDigitado);
		} else if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.PRESIDENTE.name())) {
			menuBase(MapConta.getMapaConta().get(cpfDigitado), cpfDigitado);
		}
	}

	// [MENU BASE]
	public static void menuBase(Conta conta, String cpfDigitado) throws IOException {
		
		cpfConta = cpfDigitado;
		do {
			System.out.println("\n\n\n\n\n\n\n\n\n\nOlá, " + MapConta.getMapaConta().get(cpfDigitado).getNome());
			System.out.println("Escolha uma opção:\n");
			System.out.println("[ 1 ] Movimentação de Conta \t[ 0 ] Sair");
			System.out.println("[ 2 ] Relatório");

			opcao = leia.nextInt();

			switch (opcao) {
			case 0:
				System.out.println("\n\n\n\nObrigado por usar nossos serviços. Tenha um bom dia!");
				limparConsoleManual();
				sair = true;
				break;
			case 1:
				movimentacaoCliente(conta, cpfConta);
				limparConsole();
				break;
			case 2:
				if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.CLIENTE.name())) {
					relatorioCliente(conta, cpfDigitado);
				} else if ((MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao()
						.equals(tipoUsuario.GERENTE.name()))) {
					relatorioGerente(conta, cpfDigitado);
				} else if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao()
						.equals(tipoUsuario.DIRETOR.name())) {
					relatorioDiretor(conta, cpfDigitado);
				} else if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao()
						.equals(tipoUsuario.PRESIDENTE.name())) {
					relatorioPresidente(conta, cpfDigitado);
				}
				break;
			default:
				System.out.println("Opção inválida.");
				limparConsoleManual();
				break;
			}
		} while (sair == false);
	}

	// [MENU CLIENTE] Movimentação de Conta
	public static void movimentacaoCliente(Conta usuario, String cpfConta) throws IOException {
		limparConsole();
		System.out.println("Movimentação de Conta\n");
		System.out.println("[ 1 ] Depósito \t\t\t[ 0 ] Voltar");
		System.out.println("[ 2 ] Sacar");
		System.out.println("[ 3 ] Transferência Bancária");
		opcao = leia.nextInt();

		switch (opcao) {
		case 0:
			limparConsole();
			menuBase(usuario, cpfConta);
			break;
		case 1:
			limparConsole();
			usuario.depositar();
			limparConsoleManual();
			break;
		case 2:
			limparConsole();
			usuario.sacar();
			limparConsoleManual();
			break;
		case 3:
			limparConsole();
			usuario.transferir();
			limparConsoleManual();
			break;
		}
	}

	public static void relatorioCliente(Conta usuario, String cpfConta) throws IOException {
		
			limparConsole();
			System.out.println("Relatórios da Conta\n");
			System.out.println("[ 1 ] Saldo\t\t\t\t\t\t\t\t\t\t\t[ 0 ] Voltar");
			System.out.println("[ 2 ] Relatório de tributação da Conta Corrente");
			System.out.println("[ 3 ] Relatório de rendimento da Conta Poupança");
			System.out.println("[ 4 ] Seguro de vida");
			opcao = leia.nextInt();
			
			switch (opcao) {
			case 0:
				menuBase(usuario, cpfConta);
				break;
			case 1:
				limparConsole();
				usuario.getSaldo();
				RegistrosDoPrograma.registroRelatorioDeSaldo(usuario.getNome(), usuario.getCpf(), usuario.getSaldo());
				limparConsoleManual();
				break;
			case 2:
				limparConsole();
				usuario.relatorioTributacaoCorrente();
				RegistrosDoPrograma.registroRelatorioDeTributacao(usuario.getCpf());
				limparConsoleManual();
				break;
			case 3:
				limparConsole();
				usuario.relatorioRendimentos();
				limparConsoleManual();
				break;
			case 4:
				limparConsole();
				usuario.seguroVida();
				limparConsoleManual();
				break;
			default:
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
				relatorioCliente(usuario, cpfConta);
				break;
			}
		} 
	// [MENU GERENTE] Relatórios
	public static void relatorioGerente(Conta usuario, String cpfConta) throws IOException {

			limparConsole();
			System.out.println("Relatórios da Conta\n");
			System.out.println("[ 1 ] Saldo\t\t\t\t\t\t\t\t\t\t\t[ 0 ] Voltar");
			System.out.println("[ 2 ] Relatório de tributação da Conta Corrente");
			System.out.println("[ 3 ] Relatório de rendimento da Conta Poupança");
			System.out.println("[ 4 ] Seguro de vida");
			System.out.println("[ 5 ] Número de contas existentes em sua agência.");
			opcao = leia.nextInt();
			
			switch (opcao) {
			case 0:
				menuBase(usuario, cpfConta);
				break;
			case 1:
				limparConsole();
				usuario.getSaldo();
				RegistrosDoPrograma.registroRelatorioDeSaldo(usuario.getNome(), usuario.getCpf(), usuario.getSaldo());
				limparConsoleManual();
				break;
			case 2:
				limparConsole();
				usuario.relatorioTributacaoCorrente();
				RegistrosDoPrograma.registroRelatorioDeTributacao(usuario.getCpf());
				limparConsoleManual();
				break;
			case 3:
				limparConsole();
				usuario.relatorioRendimentos();
				limparConsoleManual();
				break;
			case 4:
				limparConsole();
				usuario.seguroVida();
				limparConsoleManual();
				break;
			case 5:
				limparConsole();
				int contas = 0;
				
				for (Conta numero : MapConta.getMapaConta().values()){
					if (numero.getAgencia() == usuario.getAgencia()) {
						contas++;
					}
				}
				System.out.println("Esta agência possui " + contas + " de contas.");
				RegistrosDoPrograma.registroNumeroDeContas(contas, usuario.getAgencia());
				limparConsoleManual();
				break;
			default:
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
				relatorioCliente(usuario, cpfConta);
				break;
			}
		}
	
	// [MENU DIRETOR] Relatórios
	public static void relatorioDiretor(Conta usuario, String cpfConta) throws IOException {
		
			limparConsole();
			System.out.println("Relatórios da Conta\n");
			System.out.println("[ 1 ] Saldo\t\t\t\t\t\t\t\t\t\t\t[ 0 ] Voltar");
			System.out.println("[ 2 ] Relatório de tributação da Conta Corrente");
			System.out.println("[ 3 ] Relatório de rendimento da Conta Poupança");
			System.out.println("[ 4 ] Seguro de vida");
			System.out.println("[ 5 ] Relatório de quantidade de contas existentes em sua agência.");
			System.out.println("[ 6 ] Relatório com informação de nome, CPF e Agência de todos os cliente.");
			opcao = leia.nextInt();
			
			switch (opcao) {
			case 0:
				menuBase(usuario, cpfConta);
				break;
			case 1:
				usuario.getSaldo();
				RegistrosDoPrograma.registroRelatorioDeSaldo(usuario.getNome(), usuario.getCpf(), usuario.getSaldo());
				break;
			case 2:
				limparConsole();
				usuario.relatorioTributacaoCorrente();
				RegistrosDoPrograma.registroRelatorioDeTributacao(usuario.getCpf());
				limparConsoleManual();
				break;
			case 3:
				limparConsole();
				usuario.relatorioRendimentos();
				limparConsoleManual();
				break;
			case 4:
				limparConsole();
				usuario.seguroVida();
				limparConsoleManual();
				break;
			case 5:
				limparConsole();
				int contas = 0;
				
				for (Conta numero : MapConta.getMapaConta().values()){
					if (numero.getAgencia() == usuario.getAgencia()) {
						contas++;
					}
				}
				System.out.println("Esta agência possui " + contas + " de contas.");
				RegistrosDoPrograma.registroNumeroDeContas(contas, usuario.getAgencia());
				limparConsoleManual();
				break;
			case 6:
				limparConsole();
				for (Conta texto : MapConta.getMapaContaOrdem().values()) {
					System.out.println(texto.getNome() + "\t\t" + texto.getCpf() + "\t\t" + texto.getAgencia());
					RegistrosDoPrograma.registroContas();	
				}
				limparConsoleManual();
				break;
			default:
				System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
				relatorioCliente(usuario, cpfConta);
				break;
			}
		} 
	public static void relatorioPresidente(Conta usuario, String cpfConta) throws IOException {
		limparConsole();
		System.out.println("Relatórios da Conta\n");
		System.out.println("[ 1 ] Saldo\t\t\t\t\t\t\t\t\t\t\t[ 0 ] Voltar");
		System.out.println("[ 2 ] Relatório de tributação da Conta Corrente");
		System.out.println("[ 3 ] Relatório de rendimento da Conta Poupança");
		System.out.println("[ 4 ] Seguro de vida");
		System.out.println("[ 5 ] Relatório de quantidade de contas existentes em sua agência.");
		System.out.println("[ 6 ] Relatório com informação de nome, CPF e Agência de todos os cliente.");
		System.out.println("[ 7 ] Relatório do capital total armazenado no banco.");
		opcao = leia.nextInt();
		
		switch (opcao) {
		case 0:
			menuBase(usuario, cpfConta);
			break;
		case 1:
			usuario.getSaldo();
			RegistrosDoPrograma.registroRelatorioDeSaldo(usuario.getNome(), usuario.getCpf(), usuario.getSaldo());
			break;
		case 2:
			limparConsole();
			usuario.relatorioTributacaoCorrente();
			RegistrosDoPrograma.registroRelatorioDeTributacao(usuario.getCpf());
			limparConsoleManual();
			break;
		case 3:
			limparConsole();
			usuario.relatorioRendimentos();
			limparConsoleManual();
			break;
		case 4:
			limparConsole();
			usuario.seguroVida();
			limparConsoleManual();
			break;
		case 5:
			limparConsole();
			int contas = 0;
			
			for (Conta numero : MapConta.getMapaConta().values()){
				if (numero.getAgencia() == usuario.getAgencia()) {
					contas++;
				}
			}
			System.out.println("Esta agência possui " + contas + " de contas.");
			RegistrosDoPrograma.registroNumeroDeContas(contas, usuario.getAgencia());
			limparConsoleManual();
			break;
		case 6:
			limparConsole();
			for (Conta texto : MapConta.getMapaContaOrdem().values()) {
				System.out.println(texto.getNome() + "\t\t" + texto.getCpf() + "\t\t" + texto.getAgencia());
				RegistrosDoPrograma.registroContas();	
			}
			limparConsoleManual();
			break;
		case 7:
			limparConsole();
			double soma = 0;
			for (Conta valor : MapConta.getMapaConta().values()) {
					soma = soma + valor.getSaldo();
			}
			System.out.println("\n\n\n\n\n\n\nO valor total do capital armazenado no banco é: R$" + soma);
			RegistrosDoPrograma.registroOurbank(soma);
			limparConsoleManual();
			break;
		}
	}

	// métodos para manipuação do console
	public static void limparConsoleManual() {
		System.out.println("\n--------------------------------------\n");
		System.out.println("Pressione uma tecla para continuar...");
		leia.next();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");		
	}

	public static void limparConsole() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public static void bemVindo() {
		System.out.println("===============================\n");
		System.out.println("==== BEM VINDO AO OurBank =====\n");
		System.out.println("===============================\n\n\n\n");
	}
}
