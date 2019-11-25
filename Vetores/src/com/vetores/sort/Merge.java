package com.vetores.sort;

public class Merge extends Sort{

	public Merge(int size) {
		super(size);
	}
	
	public void ordenaVetor() {
		separa(this.getVetor(),0,this.getVetor().length-1);		
	}
	
	public void separa(int[] v, int inicio, int fim) {
		int meio;
		if(inicio < fim) {
			meio = (inicio + fim)/2;
			separa(v, inicio, meio);
			separa(v, meio+1, fim);
			intercala(v, inicio, fim, meio);
		}
		
	}
	
	public void intercala (int[] v, int inicio, int fim, int meio) {
		int posLivre, inicio_vetor1, inicio_vetor2;
		int aux[] = new int[v.length];
		inicio_vetor1 = inicio;
		inicio_vetor2 = meio+1;
		posLivre = inicio;
		
		while(inicio_vetor1 <= meio && inicio_vetor2 <= fim) {
			if(v[inicio_vetor1] <= v[inicio_vetor2]) {
				aux[posLivre] = v[inicio_vetor1];
				inicio_vetor1++;
			}else {
				aux[posLivre] = v[inicio_vetor2];
				inicio_vetor2++;
			}
			posLivre++;
		}
		//se o vetor 1 ainda tem elementos
		for(int i = inicio_vetor1;i<=meio;i++){
			aux[posLivre] = v[i];
			posLivre++;
		}
		
		//se o vetor 2 ainda tem elementos
		for(int i = inicio_vetor2;i<=fim;i++){
			aux[posLivre] = v[i];
			posLivre++;
		}
		
		//retorna o valores de aux para v
		for(int i = inicio; i <= fim; i++) {
			v[i]=aux[i];
		}
		
	}

}
