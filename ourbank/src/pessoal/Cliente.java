package pessoal;

import enumSistema.tipoUsuario;

public class Cliente extends Usuario{

	//setando o tipo de usuario
	public Cliente() {
		setFuncao(tipoUsuario.CLIENTE.name());
	}

	public Cliente(String cpf, String senha) {
		setCpf(cpf);
		setSenha(senha);
		setFuncao(tipoUsuario.CLIENTE.name());
	}
	
}
