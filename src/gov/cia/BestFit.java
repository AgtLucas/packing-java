package gov.cia;

import java.util.Scanner;

public class BestFit {
	
	private static Scanner in;

	public static void main(String[] args) {
		
		int p, m;
		
		in = new Scanner(System.in);

		System.out.println("Nº processos:");
		p = in.nextInt();
		System.out.println("Nº blocos de memória:");
		m = in.nextInt();

		int tamProcessos[] = new int[p];
		BestFitMem segMemoria[] = new BestFitMem[m];

		int i;

		for (i = 0; i < p; i++) {
			System.out.println("Tamanho do processo " + (i+1));
			tamProcessos[i] = in.nextInt();
		}

		for (i = 1; i <= m; i++) {
			System.out.println("Entre o tamanho do segmento de memória "
					+ i);
			BestFitMem seg = new BestFitMem();
			seg.id = i;
			seg.size = in.nextInt();
			segMemoria[i-1] = seg;
		}

		int j;
		for (i = 0; i < m; i++) {
			for (j = i + 1; j < m; j++) {
				if (segMemoria[i].size > segMemoria[j].size) {
					BestFitMem t = segMemoria[i];
					segMemoria[i] = segMemoria[j];
					segMemoria[j] = t;
				}
			}
		}

		for (i = 0; i < p; i++) {
			for (j = 0; j < m; j++) {
				if (segMemoria[j].size >= tamProcessos[i]) {
					segMemoria[j].size -= tamProcessos[i];
					
					System.out.println("Processo " + (i + 1)
							+ " alocado no espaço de memória " + segMemoria[j].id);
					System.out.println("Espaço restante após a alocação "
							+ segMemoria[j].size);
					System.out.println();
					
					break;
				}

			}
			if (j == m) {
				System.out.println("Não há mais memória para o processo " + i);
				break;
			}
		}
		
	}

}
