package pessoal;

import enumSistema.tipoUsuario;

public class Diretor extends Usuario {
	
	public Diretor() {
		setFuncao(tipoUsuario.DIRETOR.name());
	}

	public Diretor(String cpf, String senha) {
		setCpf(cpf);
		setSenha(senha);
		setFuncao(tipoUsuario.DIRETOR.name());
	}
}
