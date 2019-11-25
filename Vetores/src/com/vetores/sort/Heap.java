package com.vetores.sort;

public class Heap extends Sort{
	
	public Heap(int size) {
		super(size+1);
	}
	
	@Override
	public void setValoresInput() {
		for(int i=1; i<this.getVetor().length;i++) {
			System.out.println("Digite o "+(i)+"º número: ");
			this.setValor(i,leitor.nextInt());
		}
	}
	
	@Override
	public void imprimeVetor() {
		for(int i=1;i<this.getVetor().length;i++) {
			System.out.println((i)+"º número: "+this.getValor(i));
		}
		System.out.println("----------------------------\n");
	}
	
	private void transforma_heap(int qtde) {
		int i, pai, aux;
		for(i =qtde/2; i>=1;i--) {
			heap_fica(i,qtde);
		}
	}
	
	private void heap_fica(int i, int qtde) {
		int f_esq, f_dir, maior, aux;
		maior = i;
		if(2*i+1 <= qtde) {
			f_esq = 2*i;
			f_dir = 2*i+1;
			if(this.getValor(f_esq) >= this.getValor(f_dir) && this.getValor(f_esq) > this.getValor(i))
				maior = 2*i;
			else if(this.getValor(f_dir) > this.getValor(f_esq) && this.getValor(f_dir) > this.getValor(i))
				maior = 2*i+1;
		}else if(2*i <= qtde) {
			f_esq = 2*i;
			if(this.getValor(f_esq) > this.getValor(i))
				maior = 2*i;
		}
		if(maior != i) {
			aux = this.getValor(i);
			this.setValor(i, this.getValor(maior));
			this.setValor(maior, aux);
			heap_fica(maior,qtde);
		}
	}
	
	public void ordenaVetor() {
		int i, aux, ultima_pos, qtde = this.getVetor().length-1;
		transforma_heap(qtde);
		for(i = qtde; i >= 2;i--) {
			aux=this.getValor(1);
			this.setValor(1, this.getValor(i));
			this.setValor(i, aux);
			ultima_pos= i-1;
			heap_fica(1,ultima_pos);
		}
	}
	
}
