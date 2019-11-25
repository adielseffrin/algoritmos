package com.vetores.search;
import com.vetores.sort.Sort;

public class Binaria extends Sort{

	private int posicao;
	private boolean encontrado;
	
	public Binaria(int size) {
		super(size);
	}
	
	public int getPosicao() {
		return posicao;
	}
	public boolean isEncontrado() {
		return encontrado;
	}
	
	public void search(int p) {
		int inicio = 0, fim = this.getVetor().length-1, meio;
		while(inicio <= fim && !encontrado) {
			meio = (inicio+fim)/2;
			if(this.getValor(meio) == p) {
				encontrado = true;
				posicao = meio;
			}else if(this.getValor(meio) < p) {
				inicio = meio+1;
			}else
				fim = meio-1;
		}
	}

}
