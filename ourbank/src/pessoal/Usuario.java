package pessoal;

public abstract class Usuario {
	
	private String nome;
	private int idade;
	public String cpf;
	private String senha;
	private String funcao;
	
	
	
	//construtores
	public Usuario() {
	}
	
	public Usuario(String nome, int idade, String cpf, String senha) {
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.senha = senha;
	}
	
	//getters e setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	
}
