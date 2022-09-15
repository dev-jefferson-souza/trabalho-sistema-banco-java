package ourbank;

import java.io.IOException;
import java.util.Scanner;

import listas.MapConta;
import listas.MapUsuario;
import menu.Menu;

public class App {

	public static void main(String[] args) throws IOException {
		
		Scanner leia = new Scanner(System.in);
		//boolean sair = false;
		
		MapConta.leitorDasContas(".\\arquivosText\\Contas.txt");
		MapUsuario.leitorDosUsuarios(".\\arquivosText\\Clientes.txt");
		
			
		
		Menu.bemVindo();
		
		System.out.println("Digite seu CPF:");
		String cpfDigitado = leia.next();
		System.out.println("\nDigite sua senha:");
		String senhaDigitada = leia.next();
		
		//do {			
			Menu.login(cpfDigitado,senhaDigitada);
		//} while (sair == false);
		
	}
}
