package br.com.wmitrut;

import android.widget.TextView;

/**
 * @author byivo
 * 
 */
public class Node {

	private TextView container;

	private Node maior;
	private Node menor;

	private Integer numero;

	public Node() {
	}

	public void inserir(int numero) {

		try {
			if (this.numero < numero) {

				if (maior == null) {
					maior = new Node();
				}

				inserir(numero, maior);
			} else {

				if (menor == null) {
					menor = new Node();
				}

				inserir(numero, menor);
			}
		} catch (NullPointerException e) {
			this.numero = numero;
		}
	}

	private void inserir(int numero, Node node) {
		if (node.getNumero() == null) {
			node.setNumero(numero);
		} else {
			node.inserir(numero);
		}
	}

	public Integer getNumero() {
		return numero;
	}

	public Node getMaior() {
		return maior;
	}

	public void setMaior(Node maior) {
		this.maior = maior;
	}

	public Node getMenor() {
		return menor;
	}

	public void setMenor(Node menor) {
		this.menor = menor;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public TextView getContainer() {
		return container;
	}

	public void setContainer(TextView container) {
		this.container = container;
	}

	@Override
	public String toString() {
		return "Maior: " + (maior == null ? maior : maior.getNumero())
				+ "; Valor: " + numero + "; Menor: "
				+ (menor == null ? menor : menor.getNumero());
	}

}
