package com.vetores.sort;

public class Bubble3 extends Sort{

	public Bubble3(int size) {
		super(size);
	}

	public void ordenaVetor() {
		int aux, j=1, troca = 1;

		while(j <= this.getVetor().length && troca == 1) {
			troca = 0;
			for(int i = 0; i < this.getVetor().length - 1; i++) {
				if(this.getValor(i) > this.getValor(i+1)) {
					troca = 1;
					aux = this.getValor(i);
					this.setValor(i, this.getValor(i+1));
					this.setValor(i+1,aux);
				}
			}
			j++;
		}
	}
}
