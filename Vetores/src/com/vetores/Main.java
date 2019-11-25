package com.vetores;

import com.vetores.search.Binaria;
import com.vetores.search.Sequencial;
import com.vetores.sort.Heap;
//import com.vetores.sort.Bubble;
//import com.vetores.sort.Bubble2;
//import com.vetores.sort.Bubble2alt;
//import com.vetores.sort.Bubble3;
//import com.vetores.sort.Insertion;
//import com.vetores.sort.Selection;
//import com.vetores.sort.Merge;
import com.vetores.sort.Quick;
import com.vetores.sort.Quick2;


public class Main {

	public static void main(String[] args) {
		/*** Métodos de ordenação ***/
//		Bubble sort = new Bubble(5);
//		Bubble2 sort = new Bubble2(5);
//		Bubble2alt sort = new Bubble2alt(5);
//		Bubble3 sort = new Bubble3(5);
//		Insertion sort = new Insertion(5);
//		Selection sort = new Selection(5);
//		Merge sort = new Merge(10);
		Quick2 sort = new Quick2(5);
//		Heap sort = new Heap(5);
		/*** Métodos de busca ***/
//		Sequencial busca = new Sequencial(10,false);
//		Sequencial busca = new Sequencial(10,true);
//		Binaria busca = new Binaria(10);
		
		
		/*Chamadas*/
		sort.setValoresInput();
		sort.imprimeVetor();
//		busca.setVetor(sort.getVetor());
//		busca.search(7);
//		if(busca.isEncontrado()) System.out.printf("Número encontrado na posição %d%n", busca.getPosicao());
		sort.ordenaVetor();
		sort.imprimeVetor();
//		busca.search(7);
//		if(busca.isEncontrado()) System.out.printf("Número encontrado na posição %d%n", busca.getPosicao());
	}

}
