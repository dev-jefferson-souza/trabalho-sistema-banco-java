package listas;

import java.util.Comparator;
import java.util.Map;

import conta.Conta;

public class Comparador implements Comparator<String> {
	
		Map<String, Conta> base;

	    public Comparador(Map<String, Conta> base) {
	        this.base = base;
	    }

	    public int compare(String a, String b) {
	        return base.get(a).getNome().compareToIgnoreCase(base.get(b).getNome());
	    }
	}


