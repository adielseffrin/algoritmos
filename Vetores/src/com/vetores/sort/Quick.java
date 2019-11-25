package com.vetores.sort;

public class Quick extends Sort{

	public Quick(int size) {
		super(size);
	}
	
	public void ordenaVetor() {
		quick(this.getVetor(),0,this.getVetor().length-1);		
	}
	
	public void troca(int v[], int i, int j) {
		int aux;
		aux = v[i];
		v[i]=v[j];
		v[j] = aux;
	}
	
	public int particao(int v[], int p, int r) {
		int pivo, i, j;
		pivo = v[(p+r)/2];
		
			i = p-1;
			j=r+1;
		
		while(i<j) {
				do {
					j--;
				}while(v[j] > pivo);
			
				do {
					i++;
				}while(v[i]< pivo);
			
			
			if(i<j)troca(v,i,j);
		}
		return j;
	}
	
	public void quick(int v[], int p, int r) {
		int q;
		if(p<r) {
			q = particao(v,p,r);
			quick(v,p,q);
			quick(v,q+1,r);
		}
	}

}
