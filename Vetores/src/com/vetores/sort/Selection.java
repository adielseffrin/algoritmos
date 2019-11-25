package com.vetores.sort;

public class Selection extends Sort{

	public Selection(int size) {
		 super(size);
	}
	
	public void ordenaVetor() {
		int i,j,eleito, menor, pos;
		
		for(i = 0 ; i< this.getVetor().length -1; i++) {
			eleito = this.getValor(i);

			//Encontra o menor a direita
			pos = i+1;
			menor = this.getValor(pos);
			for(j = i + 2; j < this.getVetor().length; j++) {
				if(this.getValor(j) < menor) {
					pos = j;
					menor = this.getValor(pos);
				}
			}
			
			//realiza a troca
			if(menor < eleito) {
				this.setValor(i, this.getValor(pos));
				this.setValor(pos, eleito);
			}
			
		}
		
	}

}
