package com.vetores.sort;

public class Bubble2alt extends Sort{
	
	public Bubble2alt(int size) {
		super(size);
	}
	
	public void ordenaVetor() {
		int aux;
		for(int n=0;n<this.getVetor().length - 1;n++) {
			for(int i = 0; i < this.getVetor().length - 1 -n; i++) {
				if(this.getValor(i) > this.getValor(i+1)) {
					aux = this.getValor(i);
					this.setValor(i, this.getValor(i+1));
					this.setValor(i+1,aux);
				}
			}
		}
	}
	
}
