package com.vetores.sort;

import java.util.Scanner;

public class Sort {

	private int[] vetor;
	Scanner leitor = new Scanner(System.in);
	
	public Sort(int size) {
		vetor = new int[size];
	}
	
	public int[] getVetor() {
		return vetor;
	}
	public void setVetor(int[] vetor) {
		this.vetor = vetor;
	}
	
	public int getValor(int pos) {
		return vetor[pos];
	}
	
	public void setValor(int pos, int val) {
		vetor[pos] = val;
	}
	
	public void setValoresInput() {
		for(int i=0; i<vetor.length;i++) {
			System.out.println("Digite o "+(i+1)+"º número: ");
			vetor[i] = leitor.nextInt();
		}
	}
	
	public void imprimeVetor() {
		for(int i=0;i<vetor.length;i++) {
			System.out.println((i+1)+"º número: "+vetor[i]);
		}
		System.out.println("----------------------------\n");
	}
	
}
