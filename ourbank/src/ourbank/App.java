package ourbank;

import conta.Conta;
import conta.ContaCorrente;
import menu.Menu;
import pessoal.Gerente;
import pessoal.Usuario;

public class App {

	public static void main(String[] args) {
		
		//criando conta
		Conta conta1 = new ContaCorrente();
		conta1.setCpf("0");
		conta1.setNome("Rafael");
		conta1.setAgencia(401);
		conta1.setNumeroConta(2934);
		conta1.setSenha("1");
		
		Menu menu = new Menu();
		menu.limparConsole();
		menu.login(conta1);
	}
}
