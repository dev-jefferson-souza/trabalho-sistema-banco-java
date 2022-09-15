package menu;

import java.util.Scanner;

import conta.Conta;
import enumSistema.tipoUsuario;
import listas.MapConta;
import listas.MapUsuario;

public class Menu {

	static Scanner leia = new Scanner(System.in);
	
	int tentativasFalhas = 0;
	int opcao = 0;

	// método para checar o login
	public static void login(String cpfDigitado, String senhaDigitada) {
		
		//equals compara o conteúdo da String, não sua referência em memória.
		//Verificação do CPF e da senha para efutuar o login.
		
		if(MapUsuario.getMapaUsuario().containsKey(cpfDigitado) && MapUsuario.getMapaUsuario().get(cpfDigitado).getSenha().equals(senhaDigitada)) {
			System.out.println("Login efetuado com sucesso!\n\n");
			abreMenu(cpfDigitado);
			
		//} else if(MapUsuario.getMapaUsuario() == null  && tentativasFalhas >= 2) {
			//System.out.println("Devido as tentativas falhas, sua conta será bloqueada para sua segurança.\nPor favor, entre em contato com a agência OurBank mais próxima.");
		} else {
			System.out.println("\nCPF ou senha incorreta.\nTente novamente.");
			//this.tentativasFalhas += 1;
			System.out.println();
		}
	}
	
	public static void abreMenu(String cpfDigitado) {
		
		if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.CLIENTE.name())) {
			Menu.menuBase(MapConta.getMapaConta().get(cpfDigitado));
		} else if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.GERENTE.name())) {
			//Menu.menuGerente(MapConta.getMapaConta().get(cpfDigitado));
			System.out.println("Funcionando gerenmte");
		} else if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.DIRETOR.name())) {
			//Menu.menuDiretor(MapConta.getMapaConta().get(cpfDigitado));
			System.out.println("Funcionando diretor");
		} else if (MapUsuario.getMapaUsuario().get(cpfDigitado).getFuncao().equals(tipoUsuario.PRESIDENTE.name())) {
			//Menu.menuPresidente(MapConta.getMapaConta().get(cpfDigitado));
			System.out.println("Funcionando presidente");
		}
	}

	// menu de base
	public static void menuBase( Conta conta) {
		boolean sair = false;
		do {
			System.out.println("\n\n\n\n\n\n\n\n\n\nOlá, ");
			System.out.println("Escolha uma opção:\n");
			System.out.println("[ 1 ] Movimentação de Conta \t[ 0 ] Sair");
			System.out.println("[ 2 ] Relatório");
			
			int opcao = leia.nextInt();
			
			
			switch (opcao) {
			case 0:
				
				System.out.println("Obrigado por usar nossos serviços. Tenha um bom dia!");
				limparConsoleManual();
				
				sair = true;
				break;
			case 1:
				
			

				break;
			case 2:
				
				System.out.println("[Menu de relatórios aberto]");
				break;
			default:
				System.out.println("Opção inválida.");
				limparConsoleManual();
				
				break;
			}
		} while (sair == false);
	}

	// menu base de movimentação de conta
	public void movimentacaoBase(Conta usuario) {
		System.out.println("Movimentação de Conta\n");
		System.out.println("[ 1 ] Saldo \t\t\t[ 0 ] Voltar");
		System.out.println("[ 2 ] Depósito");
		System.out.println("[ 3 ] Sacar");
		System.out.println("[ 4 ] Transferência Bancária");
		opcao = leia.nextInt();

		switch (opcao) {
		case 0:
			limparConsole();
			menuBase(usuario);
			break;
		case 1:
			limparConsole();
			usuario.getSaldo();
			limparConsoleManual();
			break;
		case 2:
			limparConsole();
			usuario.depositar();
			limparConsoleManual();
			break;
		case 3:
			limparConsole();
			usuario.sacar();
			limparConsoleManual();
			break;
		case 4:
			System.out.println("[Menu de Transferência Bancária]");
			limparConsoleManual();
			menuBase(usuario);
			break;
		}

	}

	// métodos para manipuação do console
	public static void limparConsoleManual() {
		System.out.println("\n--------------------------------------\n");
		System.out.println("Pressione uma tecla para continuar...");
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public void limparConsole() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public static void bemVindo() {
		System.out.println("===============================\n");
		System.out.println("==== BEM VINDO AO OurBank =====\n");
		System.out.println("===============================\n\n\n\n");
	}
}
