package gov.cia;

import java.util.Scanner;

public class BestFit {
	
	private static Scanner in;

	public static void main(String[] args) {
		
		int proc, mem;
		
		in = new Scanner(System.in);
		
		System.out.println("Número de processos: ");
		proc = in.nextInt();
		System.out.println("Número de blocos de memória: ");
		mem = in.nextInt();
		
		int tamProcessos[] = new int[proc];
		BestFitMem bestFitMem[] = new BestFitMem[mem];
		
		int i;
		
		for (i = 0; i < proc; i++) {
			System.out.println("Tamanho do processo " + (i + 1));
			tamProcessos[i] = in.nextInt();
		}
		
		for (i = 0; i < mem; i++) {
			System.out.println("Entre o tamanho do segmento de memória: " + i);
			
			BestFitMem segMem = new BestFitMem();
			segMem.id = i;
			segMem.size = in.nextInt();
			bestFitMem[i - 1] = segMem;
			
		}
		
		int j;
		
		for (i = 0; i < mem; i++) {
			for (j = i + 1; j < mem; j++) {
				if (bestFitMem[i].size > bestFitMem[j].size) {
					BestFitMem t = bestFitMem[i];
					bestFitMem[i] = bestFitMem[j];
					bestFitMem[j] = t;
				}
			}
		}
		
		for (i = 0; i < proc; i++) {
			for (j = 0; j < mem; j++) {
				if (bestFitMem[j].size >= tamProcessos[i]) {
					bestFitMem[j].size -= tamProcessos[i];
					System.out.println("Processo " + (i + 1) + " alocado no espaço de memória " + (j + 1));
					System.out.println("Espaço restante após a alocação " + bestFitMem[j]);
					System.out.println("AEHOOOOOO");
					break;
				}
			}
			if (j == mem) {
				System.out.println("Erro! Acabou! Não há mais memória para o processo " + i);
				break;
			}
		}
		
	}

}
