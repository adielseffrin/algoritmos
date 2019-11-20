import java.util.Scanner;

public class Arvore_AVL {

	private static class ARVORE{
		public int num, altd, alte;
		public ARVORE dir, esq;
	}

	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);
		ARVORE raiz = null;
		ARVORE aux, aux1;
		int op, achou, numero;

		do {
			System.out.println("MENU");
			System.out.println("1 - Inserir");
			System.out.println("2 - Constular");
			System.out.println("3 - Listar em order");
			System.out.println("4 - Listar em pre order");
			System.out.println("5 - Listar em pos order");
			System.out.println("6 - excluir");
			System.out.println("7 - Esvaziar");

			op= entrada.nextInt();

			switch(op) {
			case 1:
				System.out.println("numero:");
				numero = entrada.nextInt();
				raiz = inserir(raiz, numero);
				System.out.println("ok");
				break;
			case 2:
				if(raiz == null) {
					System.out.println("vazio");
				}else {
					System.out.println("numero: ");
					numero = entrada.nextInt();
					achou = 0;
					achou = consultar(raiz, numero,achou);
					if(achou == 0)
						System.out.println("não achei");
					else
						System.out.println("ta la");
				}
				break;
			case 3:
				if(raiz == null) {
					System.out.println("vazio");
				}else {
					System.out.println("em ordem");
					mostraremordem(raiz);
				}
				break;
			case 4:
				if(raiz == null) {
					System.out.println("vazio");
				}else {
					System.out.println("pre ordem");
					mostrarpreordem(raiz);
				}
				break;
			case 5:
				if(raiz == null) {
					System.out.println("vazio");
				}else {
					System.out.println("pos ordem");
					aux = raiz;
					mostrarposordem(aux);
				}
				break;
			case 6:
				if(raiz == null) {
					System.out.println("vazio");
				}else {
					System.out.println("numero: ");
					numero = entrada.nextInt();
					achou = 0;
					achou = consultar(raiz, numero, achou);
					if(achou == 0)
						System.out.println("não achei");
					else {
						raiz = remover(raiz, numero);
						raiz = atualiza(raiz);
						System.out.println("foi");
					}
				}
				break;
			case 7:
				if(raiz == null) {
					System.out.println("vazio");
				}else {
					raiz = null;
					System.out.println("foi");
				}
				break;
			}
		}while(op > 0  && op < 8);
	}

	public static ARVORE inserir(ARVORE aux, int num) {
		ARVORE novo;
		if(aux == null) {
			novo  = new ARVORE();
			novo.num = num;
			novo.altd = 0;
			novo.alte = 0;
			novo.esq = null;
			novo.dir = null;
			aux = novo;
		}else if(num < aux.num) {
			aux.esq = inserir(aux.esq, num);
			if(aux.esq.altd > aux.esq.alte)
				aux.alte = aux.esq.altd + 1;
			else
				aux.alte = aux.esq.alte + 1;
			aux = balanceamento(aux);
		}else {
			aux.dir = inserir(aux.dir, num);
			if(aux.dir.altd > aux.dir.alte)
				aux.altd = aux.dir.altd + 1;
			else
				aux.altd = aux.dir.alte + 1;
			aux = balanceamento(aux);
		}
		return aux;

	}

	public static ARVORE balanceamento(ARVORE aux) {
		int d, df;
		d = aux.altd - aux.alte;
		if(d == 2) {
			df = aux.dir.altd - aux.dir.alte;
			if(df >= 0) {
				aux = rotacao_esquerda(aux);
			}else {
				aux.dir = rotacao_direita(aux.dir);
				aux =rotacao_esquerda(aux);
			}
		}else if(d == -2) {
			df = aux.esq.altd - aux.esq.alte;
			if(df <= 0) {
				aux = rotacao_direita(aux);
			}else {
				aux.esq = rotacao_esquerda(aux.esq);
				aux = rotacao_direita(aux);
			}
		}
		return aux;
	}


	public static ARVORE rotacao_esquerda(ARVORE aux) {
		//implementar
	}


	public static ARVORE rotacao_direita(ARVORE aux) {
		//implementar
	}
	
	
	public static int consultar(ARVORE aux, int num, int achou) {
		if(aux != null && achou == 0) {
			if(aux.num == num) achou = 1;
			else if(num < aux.num) achou = consultar(aux.esq, num, achou);
			else achou = consultar(aux.dir, num, achou);
		}
		return achou;
	}
	
	public static void mostraremordem(ARVORE aux) {
		if(aux != null) {
			mostraremordem(aux.esq);
			System.out.print(aux.num+" ");
			mostraremordem(aux.dir);
		}
	}
	
	public static void mostrarpreordem(ARVORE aux) {
		if(aux != null) {
			System.out.print(aux.num+" ");
			mostrarpreordem(aux.esq);
			mostrarpreordem(aux.dir);
			
		}
	}
	
	public static void mostrarposordem(ARVORE aux) {
		if(aux != null) {
			mostrarposordem(aux.esq);
			mostrarposordem(aux.dir);
			System.out.print(aux.num+" ");
		}
	}
	
	public static ARVORE remover(ARVORE aux, int num) {
		ARVORE p,p2;
		if(aux.num == num) {
			if(aux.esq == aux.dir) {
				return null;
			}else if(aux.esq == null) {
				return aux.dir;
			}else if (aux.dir == null) {
				return aux.esq;
			}else {
				p2 = aux.dir;
				p = aux.dir;
				while(p.esq != null) {
					p = p.esq;
				}
				p.esq = aux.esq;
				return p2;
			}
		}else if(aux.num < num)
			aux.dir = remover(aux.dir, num);
		else
			aux.esq = remover(aux.esq, num);
		
		return aux;
	}
	
	public static ARVORE atualiza(ARVORE aux) {
		if(aux!=null) {
			aux.esq = atualiza(aux.esq);
			if(aux.esq == null) aux.alte = 0;
			else if(aux.esq.alte > aux.esq.altd) aux.alte = aux.esq.alte + 1;
			else aux.alte = aux.esq.altd + 1;
			
			aux.dir = atualiza(aux.dir);
			if(aux.dir == null) aux.altd = 0;
			else if(aux.dir.alte > aux.dir.altd) aux.altd = aux.dir.alte + 1;
			else aux.altd = aux.dir.altd + 1;
			
			aux = balanceamento(aux);
			
		}
		return aux;
	}
	
	
	

}
