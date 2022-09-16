package listas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import conta.Conta;
import conta.ContaCorrente;
import conta.ContaPoupanca;

public class MapConta {

	public static Map<String, Conta> mapaConta = new HashMap<>();
	public static Comparador comparador = new Comparador(mapaConta);
	public static TreeMap<String, Conta> mapaAlfabetico = new TreeMap<String, Conta>(comparador);

	public static void leitorDasContas(String path) throws IOException {

		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";

		while (true) {
			linha = buffRead.readLine();

			if (linha != null) {

				String[] lerLinha = linha.split(";");

				if (lerLinha[0].equalsIgnoreCase("Poupanca")) {
					Conta poupanca = new ContaPoupanca(Integer.parseInt(lerLinha[1]), Integer.parseInt(lerLinha[2]),
							Double.parseDouble(lerLinha[3]), lerLinha[4], lerLinha[5], lerLinha[6]);
					MapConta.getMapaConta().put(lerLinha[5], poupanca);
				} else if (lerLinha[0].equalsIgnoreCase("Corrente"))
					;
				{
					Conta corrente = new ContaCorrente(Integer.parseInt(lerLinha[1]), Integer.parseInt(lerLinha[2]),
							Double.parseDouble(lerLinha[3]), lerLinha[4], lerLinha[5], lerLinha[6]);
					MapConta.getMapaConta().put(lerLinha[5], corrente);
				}
			} else
				break;
		}
		buffRead.close();
	}

	public static Map<String, Conta> getMapaConta() {
		return mapaConta;
	}

	public static Map<String, Conta> getMapaContaOrdem() {
		mapaAlfabetico.putAll(mapaConta);
		return mapaAlfabetico;
	}
}
