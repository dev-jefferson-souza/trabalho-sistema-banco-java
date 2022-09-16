package ourbank;

import java.io.IOException;
import java.util.Scanner;

import listas.MapConta;
import listas.MapUsuario;
import menu.Menu;

public class App {

	public static void main(String[] args) throws IOException {
		
		try {
			
			Scanner leia = new Scanner(System.in);
			
			MapConta.leitorDasContas(".\\arquivosText\\Contas.txt");
			MapUsuario.leitorDosUsuarios(".\\arquivosText\\Clientes.txt");
			
			Menu.bemVindo();
			
			System.out.println("Digite seu CPF:");
			String cpfDigitado = leia.next();
			System.out.println("\nDigite sua senha:");
			String senhaDigitada = leia.next();
					
			Menu.login(cpfDigitado,senhaDigitada);
			
			
			leia.close();
				
		
		} catch ( ArithmeticException e) {
			System.out.println("Houve um problema");
		}
		catch (Exception e) {
			System.out.println("Aconteceu um erro no sistema. Tente novamente e se o erro persistir entre em contato com o suporte");
		}
		
		
	}
}