package pessoal;

import enumSistema.tipoUsuario;

public class Presidente extends Usuario{
	public Presidente() {
		setFuncao(tipoUsuario.PRESIDENTE.name());
	}

	public Presidente(String cpf, String senha) {
		setCpf(cpf);
		setSenha(senha);
		setFuncao(tipoUsuario.PRESIDENTE.name());
	}
}
