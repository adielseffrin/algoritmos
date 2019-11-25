package com.vetores.sort;

public class Bubble extends Sort{

	public Bubble(int size) {
		super(size);
	}
	
	public void ordenaVetor() {
		int aux;
		for(int n=1;n<=this.getVetor().length;n++) {
			for(int i = 0; i < this.getVetor().length-1; i++) {
				if(this.getValor(i) > this.getValor(i+1)) {
					aux = this.getValor(i);
					this.setValor(i, this.getValor(i+1));
					this.setValor(i+1,aux);
				}
			}
		}
	}
	
	
	
}
