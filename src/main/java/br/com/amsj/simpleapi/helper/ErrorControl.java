package br.com.amsj.simpleapi.helper;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ErrorControl {

	private int contador = 1;

	public int getContador() {
		return contador;
	}

	public void incrementaContador() {
		contador++;
		if (contador == 5) {
			contador = 1;
		}
	}
}
