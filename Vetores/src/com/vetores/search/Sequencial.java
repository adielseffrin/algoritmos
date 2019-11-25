package com.vetores.search;
import com.vetores.sort.Sort;

public class Sequencial extends Sort {

	private int posicao;
	private boolean encontrado;
	private boolean ordenado;
	
	public Sequencial(int size, boolean o) {
		super(size);
		ordenado = o;
	}
	
	public int getPosicao() {
		return posicao;
	}
	public boolean isEncontrado() {
		return encontrado;
	}
	
	public void search(int p) {
		encontrado = false;
		if(ordenado) searchO(p);
		else searchR(p);
	}

	private void searchR(int p) {
		for(int i = 0; i < this.getVetor().length; i++){
			if(this.getValor(i) == p) {
				encontrado = true;
				posicao = i;
			}
		}
	}
	private void searchO(int p) {
		int i = 0;
		while(i < this.getVetor().length && this.getValor(i) <= p){
			if(this.getValor(i) == p) {
				encontrado = true;
				posicao = i;
			}
			i++;
		}
	}

}
