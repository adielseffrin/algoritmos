package com.vetores.sort;

public class Bubble2 extends Sort{

	public Bubble2(int size) {
		super(size);
	}
	
	public void ordenaVetor() {
		int aux;
		for(int n=1;n<=4;n++) {
			for(int i = 4; i >= n; i--) {
				if(this.getValor(i) < this.getValor(i-1)) {
					aux = this.getValor(i);
					this.setValor(i, this.getValor(i-1));
					this.setValor(i-1,aux);
				}
			}
		}
	}
	
}
