package pessoal;

import enumSistema.tipoUsuario;

public class Gerente extends Usuario {
	int agencia;
	
	//construtores
	public Gerente() {
		setFuncao(tipoUsuario.GERENTE.name());
	}

	public Gerente(String cpf, String senha, int agencia) {
		setCpf(cpf);
		setSenha(senha);
		setFuncao(tipoUsuario.GERENTE.name());
		this.agencia = agencia;
	}

	//getters e setters
	public int getAgencia() {
		return agencia;
	}

	
}
