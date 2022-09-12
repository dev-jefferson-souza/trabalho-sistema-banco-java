package pessoal;

public class Gerente extends Funcionario {
	int agencia;
	
	//construtores
	public Gerente() {
		super();
	}
	
	public Gerente(String nomeFuncionario, String cpfFuncionario, String senha, int agencia) {
		super(nomeFuncionario, cpfFuncionario, senha);
		this.agencia = agencia;
	}

	//getters e setters
	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	
}
