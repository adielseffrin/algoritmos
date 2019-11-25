package com.vetores.sort;

public class Insertion extends Sort{
	
	public Insertion(int size) {
		super(size);
	}
	
	public void ordenaVetor() {
		int i,j,eleito;
		for(i = 1 ; i< this.getVetor().length ; i++) {
			eleito = this.getValor(i);
			j = i - 1;
			while(j >= 0 && this.getValor(j) < eleito) {
				this.setValor(j+1, this.getValor(j));
				j--;
			}
			this.setValor(j+1, eleito);
		}
		
	}
	
}
