package menuInterativo;

import java.util.Scanner;

import conta.Conta;

public class MenuBase {
	
	Scanner leia = new Scanner(System.in);
	int tentativasFalhas = 0;
	int opcao = 0;
	

	//método para checar o login
	public void login(Conta usuario) {
		bemVindo();
		System.out.println("Digite seu CPF:");
		String cpfDigitado = leia.next();
		
		System.out.println("\nDigite sua senha:");
		String senhaDigitada = leia.next();
		
		
		//equals compara o conteúdo da String, não sua referência em memória.
		if(cpfDigitado.equals(usuario.getCpf()) && senhaDigitada.equals(usuario.getSenha())) {
			System.out.println("Login efetuado com sucesso!");
			menuBase(usuario);
		}
		else if(cpfDigitado.equals(usuario.getCpf()) && this.tentativasFalhas >= 2) {
			System.out.println("Devido as tentativas falhas, sua conta será bloqueada para sua segurança.\nPor favor, entre em contato com a agência OurBank mais próxima.");
		}
		else {
			System.out.println("\nCPF ou senha incorreta.\nTente novamente.");
			this.tentativasFalhas += 1;
			limparConsoleManual();
			login(usuario);
		}
	}
	
	
	//menu de base
	public void menuBase(Conta usuario) {
		boolean sair = false;
		do {
		System.out.println("\n\n\n\n\n\n\n\n\n\nOlá, " + usuario.getNome() + "!\n" );
		System.out.println("Escolha uma opção:\n");
		System.out.println("[ 1 ] Movimentação de Conta \t[ 0 ] Sair");
		System.out.println("[ 2 ] Relatório");
		
		 opcao = leia.nextInt();
			switch (opcao) {
			case 0:
				limparConsole();
				System.out.println("Obrigado por usar nossos serviços. Tenha um bom dia!");
				limparConsoleManual();
				login(usuario);
				sair = true;
				break;
			case 1:
				limparConsole();
				movimentacaoBase(usuario);
				
				break;
			case 2:
				limparConsole();
				System.out.println("[Menu de relatórios aberto]");
				break;
			default:
				System.out.println("Opção inválida.");
				limparConsoleManual();
				menuBase(usuario);
				break;
			}
		} while(sair == false);
	}
	
	//menu base de movimentação de conta
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
		public void limparConsoleManual() {
			System.out.println("\n--------------------------------------\n");
			System.out.println("Pressione uma tecla para continuar...");
			String enter = leia.next();
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		
		public void limparConsole() {
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}
		
		public void bemVindo() {
			System.out.println("===============================\n");
			System.out.println("==== BEM VINDO AO OurBank =====\n");
			System.out.println("===============================\n\n\n\n");
		}
}
