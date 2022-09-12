package pessoal;

public class Funcionario {
	private String nomeFuncionario;
	private String cpfFuncionario;
	private String senha;
	
	
	
	//construtores
	public Funcionario() {
		super();
	}

	public Funcionario(String nomeFuncionario, String cpfFuncionario, String senha) {
		super();
		this.nomeFuncionario = nomeFuncionario;
		this.cpfFuncionario = cpfFuncionario;
		this.senha = senha;
	}


	//getters e setters
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public void setCpfFuncionario(String cpfFuncionario) {
		this.cpfFuncionario = cpfFuncionario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	

	
}
