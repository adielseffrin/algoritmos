package com.arvore;

import java.util.Scanner;

public class Main {
	private static class ARVORE {
		public int num;
		public ARVORE dir, esq;
	}

	private static class PILHA {
		public ARVORE arv;
		public PILHA prox;
	}

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);
		ARVORE raiz = null;
		ARVORE aux, aux1, novo, anterior;
		PILHA topo, aux_pilha;
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
				novo = new ARVORE();
				novo.num = entrada.nextInt();
				novo.dir = null;
				novo.esq = null;
				if (raiz == null)
					raiz = novo;
				else {
					aux = raiz;
					achou = 0;
					while (achou == 0) {
						if (novo.num < aux.num) {
							if (aux.esq == null) {
								aux.esq = novo;
								achou = 1;
							} else
								aux = aux.esq;
						} else if (novo.num >= aux.num) {
							if (aux.dir == null) {
								aux.dir = novo;
								achou = 1;
							} else
								aux = aux.dir;
						}
					}
				}
				System.out.println("Numero inserido.");
				break;
			case 2:
				if (raiz == null)
					System.out.println("Arvore vazia");
				else {
					System.out.println("numero consulta");
					numero = entrada.nextInt();
					achou = 0;
					aux = raiz;
					while (aux != null && achou == 0) {
						if (aux.num == numero) {
							System.out.println("Achei");
							achou = 1;
						} else if (numero < aux.num) {
							aux = aux.esq;
						} else {
							aux = aux.dir;
						}
					}
					if (achou == 0) {
						System.out.println("Não achei");
					}
				}
				break;
			case 3:
				if (raiz == null) {
					System.out.println("arvore vazia");
				} else {
					System.out.println("Listando em ordem");
					aux = raiz;
					topo = null;
					do {
						while (aux != null) {
							aux_pilha = new PILHA();
							aux_pilha.arv = aux;
							aux_pilha.prox = topo;
							topo = aux_pilha;
							aux = aux.esq;
						}
						if (topo != null) {
							aux_pilha = topo;
							System.out.println(aux_pilha.arv.num + " ");
							aux = topo.arv.dir;
							topo = topo.prox;
						}
					} while (topo != null || aux != null);
				}

				break;
			case 4:
				if (raiz == null) {
					System.out.println("arvore vazia");
				} else {
					System.out.println("listando pre ordem");
					aux = raiz;
					topo = null;
					do {
						while (aux != null) {
							aux_pilha = new PILHA();
							System.out.println(aux.num + " ");
							aux_pilha.arv = aux;
							aux_pilha.prox = topo;
							topo = aux_pilha;
							aux = aux.esq;
						}
						if (topo != null) {
							aux_pilha = topo;
							topo = topo.prox;
							aux = aux_pilha.arv.dir;
						}
					} while (topo != null || aux != null);
				}
				break;
			case 5:
				if (raiz == null) {
					System.out.println("arvore vazia");
				} else {
					System.out.println("listando pos ordem");
					aux = raiz;
					topo = null;
					do {
						do {
							while (aux != null) {
								aux_pilha = new PILHA();
								aux_pilha.arv = aux;
								aux_pilha.prox = topo;
								topo = aux_pilha;
								aux = aux.esq;
							}
							if (topo.arv.dir != null) {
								aux = topo.arv.dir;
							}
						} while (aux != null);
						if (topo != null) {
							System.out.println(topo.arv.num + " ");
							if (topo.prox != null) {
								if (topo.prox.arv.dir != null && topo.prox.arv.dir != topo.arv) {
									aux = topo.prox.arv.dir;
									topo = topo.prox;
								} else {
									while (topo.prox != null && topo.prox.arv.dir == topo.arv) {
										topo = topo.prox;
										System.out.println(topo.arv.num + " ");
									}
									topo = topo.prox;
									if (topo != null)
										aux = topo.arv.dir;
									else
										aux = null;
								}
							} else {
								topo = topo.prox;
								aux = null;
							}
						}
					} while (topo != null || aux != null);
				}
				break;
			case 6:
				if (raiz == null)
					System.out.println("arvore vazia");
				else {
					System.out.println("numero para excluir");
					numero = entrada.nextInt();
					aux = raiz;
					achou = 0;
					while (achou == 0 && aux != null) {
						if (aux.num == numero)
							achou = 1;
						else if (aux.num > numero)
							aux = aux.esq;
						else
							aux = aux.dir;
					}
					if (achou == 0)
						System.out.println("não achei");
					else {
						if (aux != raiz) {
							anterior = raiz;
							while (anterior.dir != aux && anterior.esq != aux) {
								if (anterior.num > numero)
									anterior = anterior.esq;
								else
									anterior = anterior.dir;
							}
							if (aux.dir == null && aux.esq == null) {
								if (anterior.dir == aux)
									anterior.dir = null;
								else
									anterior.esq = null;
							} else {
								if (aux.dir != null && aux.esq == null) {
									if (anterior.esq == aux)
										anterior.esq = aux.dir;
									else
										anterior.dir = aux.dir;
								} else if (aux.dir == null && aux.esq != null) {
									if (anterior.esq == aux)
										anterior.esq = aux.esq;
									else
										anterior.dir = aux.esq;
								} else {
									if (anterior.dir == aux) {
										anterior.dir = aux.dir;
										aux1 = aux.esq;
									} else {
										anterior.esq = aux.esq;
										aux1 = aux.dir;
									}
									aux = anterior;
									while (aux != null) {
										if (aux.num < aux1.num) {
											if (aux.dir == null) {
												aux.dir = aux1;
												aux = null;
											} else
												aux = aux.dir;
										} else {
											if (aux.esq == null) {
												aux.esq = aux1;
												aux = null;
											} else
												aux = aux.esq;
										}
									}

								}
							}
							// é raiz
						} else {
							if (aux.dir == null && aux.esq == null) {
								raiz = null;
							}else {
								if (aux.dir != null && aux.esq == null) {
									raiz = aux.dir;
								} else if (aux.dir == null && aux.esq != null) {
									raiz = aux.esq;
								} else {
									raiz = aux.dir;
									aux1 = aux.esq;
									
								
									aux = raiz;
									while (aux != null) {
										if (aux.num < aux1.num) {
											if (aux.dir == null) {
												aux.dir = aux1;
												aux = null;
											} else
												aux = aux.dir;
										} else {
											if (aux.esq == null) {
												aux.esq = aux1;
												aux = null;
											} else
												aux = aux.esq;
										}
									}

								}
							}
						}
					}
					System.out.println("numero excluido");
				}
				break;
			case 7:
				raiz = null;
				break;
			}// fim switch
		} while (op > 0 && op < 8); // fim do

	}
}
