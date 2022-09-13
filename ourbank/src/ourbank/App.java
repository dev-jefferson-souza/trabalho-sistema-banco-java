package ourbank;

import conta.Cliente;
import conta.Conta;
import conta.ContaCorrente;
import menuInterativo.MenuBase;

public class App {

	public static void main(String[] args) {
		
		//criando conta
		Conta conta1 = new ContaCorrente();
		conta1.setCpf("0");
		conta1.setNome("Rafael");
		conta1.setAgencia(401);
		conta1.setNumeroConta(2934);
		conta1.setSenha("1");
		
		System.out.println(conta1.toString());
		
		MenuBase menu = new MenuBase();
		menu.limparConsole();
		menu.login(conta1);
	}
}
