package gov.cia;

import java.util.Scanner;

public class NextFit {
	
	private static Scanner in;
	
	public static void main(String[] args) {
		
		in = new Scanner(System.in);
		
		System.out.println("Digite o número de processos: ");
		
		int proc = in.nextInt();
		
		System.out.println("Digite o número de blocos de memória: ");
		int mem = in.nextInt();
		
		int procArray[] = new int[proc];
		int memArray[] = new int[mem];
		int memArrayAux[] = new int[mem];
		
		for (int i = 0; i < proc; i++) {
			
			System.out.println("Tamanho do processo (" + (i + 1) + "):");
			procArray[i] = in.nextInt();
			
		}
		
		for (int i = 0; i < mem; i++) {
			
			System.out.println("Tamanho da memória [" + (i + 1) + "]:");
			memArray[i] = in.nextInt();
			memArrayAux[i] = 0;
			
		}
		
		int j = 0;
		int i;
		int shallNotPass = 0;
		
		for (i = 0; i < mem; i++) {
			
			if (memArray[i] > procArray[j] && memArray[i] == 0) {
				
				memArray[i] -= procArray[j];
				System.out.println("Alocado processo " + (j + 1) + " para memória " + (i + 1) + " depois de alocar ficou " + memArray[i]);
				j = j + 1;
				shallNotPass = 1;
				memArrayAux[i] = 1;
				if (j == proc)
					i = mem;
				
			}
			if (i == (mem - 1)) {
				
				if (shallNotPass == 1)
					i = 0;
				else
					System.out.println("Acabou a memória, fera.");
			}
			
		}
		if (j < proc)
			System.out.println("Acabou a memória, pow!");
		
	}

}
