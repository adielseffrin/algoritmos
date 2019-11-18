package com.arvoreBREc;

import java.util.Scanner;


public class Main {
	private static class ARVORE {
		public int num;
		public ARVORE dir, esq;
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		ARVORE raiz = null;
		ARVORE aux;
		int op, achou, numero;

		do {
			System.out.println("\nMenu de opções\n");
			System.out.println("1 - Inserir");
			System.out.println("2 - Consulta nó");
			System.out.println("3 - Consulta em ordem");
			System.out.println("4 - Consulta em pré-ordem");
			System.out.println("5 - Consulta em pós-ordem");
			System.out.println("6 - Excluir");
			System.out.println("7 - Esvaziar");
			System.out.println("8 - Sair");

			System.out.println("Digite uma opção");
			op = entrada.nextInt();
			switch (op) {
			case 1:
				System.out.println("Digite o número a ser inserido:");
				numero = entrada.nextInt();
				raiz = inserir(raiz, numero);
				System.out.println("Numero inserido.");
				break;
			case 2:
				if (raiz == null)
					System.out.println("Arvore vazia");
				else {
					System.out.println("numero consulta");
					numero = entrada.nextInt();
					achou = 0;
					achou = consultar(raiz, numero, achou);
					if (achou == 0) {
						System.out.println("Não achei");
					} else
						System.out.println("Achei");
				}
				break;
			case 3:
				if (raiz == null) {
					System.out.println("arvore vazia");
				} else {
					System.out.println("Listando em ordem");
					mostraEmOrdem(raiz);
				}
				break;
			case 4:
				if (raiz == null) {
					System.out.println("arvore vazia");
				} else {
					System.out.println("listando pre ordem");
					mostraPreOrdem(raiz);
				}
				break;
			case 5:
				if (raiz == null) {
					System.out.println("arvore vazia");
				} else {
					System.out.println("listando pos ordem");
					aux = raiz;
					mostraPosOrdem(aux);
				}
				break;
			case 6:
				if (raiz == null)
					System.out.println("arvore vazia");
				else {
					System.out.println("numero para excluir");
					numero = entrada.nextInt();
					achou = 0;
					achou = consultar(raiz, numero, achou);
					if (achou == 0)
						System.out.println("não achei");
					else {
						raiz = remover(raiz, numero);
						System.out.println("numero excluido");
					}
				}
				break;
			case 7:
				raiz = null;
				break;
			}// fim switch
		} while (op > 0 && op < 8); // fim do

	}

	public static ARVORE inserir(ARVORE aux, int num) {
		if (aux == null) {
			aux = new ARVORE();
			aux.num = num;
			aux.esq = null;
			aux.dir = null;
		} else if (num < aux.num)
			aux.esq = inserir(aux.esq, num);
		else
			aux.dir = inserir(aux.dir, num);

		return aux;
	}

	public static int consultar(ARVORE aux, int num, int achou) {
		if (aux != null && achou == 0) {
			if (aux.num == num)
				achou = 1;
			else if (num < aux.num)
				achou = consultar(aux.esq, num, achou);
			else
				achou = consultar(aux.dir, num, achou);
		}
		return achou;
	}
	
	public static void mostraEmOrdem(ARVORE aux) {
		if(aux != null) {
			mostraEmOrdem(aux.esq);
			System.out.println(aux.num+" ");
			mostraEmOrdem(aux.dir);
		}
	}
	
	public static void mostraPreOrdem(ARVORE aux) {
		if(aux != null) {
			System.out.println(aux.num+" ");
			mostraPreOrdem(aux.esq);
			mostraPreOrdem(aux.dir);
		}
	}
	
	public static void mostraPosOrdem(ARVORE aux) {
		if(aux != null) {
			mostraPosOrdem(aux.esq);
			mostraPosOrdem(aux.dir);
			System.out.println(aux.num+" ");
		}
	}
	
	public static ARVORE remover(ARVORE aux, int num) {
		ARVORE p,p2;
		if(aux.num == num) {
			if(aux.esq == aux.dir) return null;
			else if(aux.esq == null) return aux.dir;
			else if(aux.dir == null) return aux.esq;
			else {
				p2 = aux.dir;
				p = aux.dir;
				while(p.esq != null) {
					p = p.esq;
				}
				p.esq = aux.esq;
				return p2;
			}
		}else if(aux.num < num)
			aux.dir = remover(aux.dir,num);
		else
			aux.esq = remover(aux.esq,num);
	
		return aux;
	}
}