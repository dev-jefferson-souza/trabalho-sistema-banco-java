package listas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import enumSistema.tipoUsuario;
import pessoal.Cliente;
import pessoal.Diretor;
import pessoal.Gerente;
import pessoal.Presidente;
import pessoal.Usuario;

public class MapUsuario {

	public static Map<String, Usuario> mapaUsuario = new HashMap<>();

	public static void leitorDosUsuarios(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		
		while (true) {
			linha = buffRead.readLine();
			
			if (linha != null) {
				String [] lerLinha = linha.split(";");
				
				if (lerLinha[0].equalsIgnoreCase(tipoUsuario.CLIENTE.name())) {
					Usuario cliente = new Cliente(lerLinha[1], lerLinha[2]);
					MapUsuario.getMapaUsuario().put(lerLinha[1], cliente);
				} else if (lerLinha[0].equalsIgnoreCase(tipoUsuario.GERENTE.name())) {
					Usuario gerente = new Gerente(lerLinha[1], lerLinha[2], Integer.parseInt(lerLinha[3]));
					MapUsuario.getMapaUsuario().put(lerLinha[1], gerente);
				} else if (lerLinha[0].equalsIgnoreCase(tipoUsuario.DIRETOR.name())) {
					Usuario diretor = new Diretor(lerLinha[1], lerLinha[2]);
					MapUsuario.getMapaUsuario().put(lerLinha[1], diretor);
				} else if (lerLinha[0].equalsIgnoreCase(tipoUsuario.PRESIDENTE.name())) {
					Usuario presidente = new Presidente(lerLinha[1], lerLinha[2]);
					MapUsuario.getMapaUsuario().put(lerLinha[1], presidente);
				}
			} else
				break;
		}
		buffRead.close();
	}

	public static Map<String, Usuario> getMapaUsuario() {
		return mapaUsuario;
	}

}
