package com.vetores.sort;

public class Quick2 extends Sort{

	public Quick2(int size) {
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
		pivo = v[r];
		
		i = p-1;
		for(j=p;j<r;j++) {	
			if(v[j]<= pivo) {
				i++;
				troca(v,i,j);
			}
		}
		troca(v,i+1,r);
		return i+1;
		
	}
	
	public void quick(int v[], int p, int r) {
		int q;
		if(p<r) {
			q = particao(v,p,r);
			quick(v,p,q-1);
			quick(v,q+1,r);
		}
	}

}
