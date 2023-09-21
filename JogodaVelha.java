package arrays;

import java.util.Scanner;

public class JogodaVelha {

	static boolean apenasNumeros(String entrada) {
		return entrada.matches("\\d+");
	}

	static boolean opcaoValida(int escolhadoUsuario) {
		if (escolhadoUsuario > 0 && escolhadoUsuario < 10) {
			return true;
		} else {
			return false;
		}
	}

	static void atualizarCampo(int escolha, int jogador, int[][] campoIni, String[][] campoAtt) {
		for (int i = 0; i < campoIni.length; i++) {
			for (int j = 0; j < campoIni[0].length; j++) {
				if (campoIni[i][j] == escolha && campoAtt[i][j] == "") {
					if (jogador == 1) {
						campoAtt[i][j] = "X";
					} else {
						campoAtt[i][j] = "O";
					}
				}

				if (campoAtt[i][j] == "") {
					System.out.print(campoIni[i][j] + " ");
				} else {
					System.out.print(campoAtt[i][j] + " ");
				}
			}

			System.out.println();
		}
	}

	static boolean checarVitoria(String[][] campo) {
		if (campo[0][0].equals(campo[0][1]) && campo[0][0].equals(campo[0][2]) && !campo[0][0].equals("")) {
			return true;
		} else if (campo[1][0].equals(campo[1][1]) && campo[1][0].equals(campo[1][2]) && !campo[1][0].equals("")) {
			return true;
		} else if (campo[2][0].equals(campo[2][1]) && campo[2][0].equals(campo[2][2]) && !campo[2][0].equals("")) {
			return true;
		} else if (campo[0][0].equals(campo[1][1]) && campo[0][0].equals(campo[2][2]) && !campo[0][0].equals("")) {
			return true;
		} else if (campo[0][2].equals(campo[1][1]) && campo[0][2].equals(campo[2][0]) && !campo[0][2].equals("")) {
			return true;
		} else if (campo[0][0].equals(campo[1][0]) && campo[0][0].equals(campo[2][0]) && !campo[0][0].equals("")) {
			return true;
		} else if (campo[0][1].equals(campo[1][1]) && campo[0][1].equals(campo[2][1]) && !campo[0][1].equals("")) {
			return true;
		} else if (campo[0][2].equals(campo[1][2]) && campo[0][2].equals(campo[2][2]) && !campo[0][2].equals("")) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] campoInicial = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
			};
		
		String[][] campoAtualizado = {
				{"", "", ""},
				{"", "", ""},
				{"", "", ""}
		};
		
		for(int i = 0; i < campoInicial.length; i++) {
			for(int j = 0; j < campoInicial[0].length; j++) {
				System.out.print(campoInicial[i][j] + " ");
			}
			System.out.println();
		}
		
		String strJogada = "";
		boolean verificarEntrada = false;
		boolean escolhaValida = false;
		int numJogada = 0;
		int p1 = 1;
		int p2 = 2;
		boolean fimdeJogo = false;
		int velha = 0;
		
		while(fimdeJogo == false) {
			while(escolhaValida == false) {
				while(verificarEntrada == false) {
					System.out.print("Escolha onde deseja jogar (Jogador 1/X): ");
					strJogada = scan.nextLine();
					verificarEntrada = apenasNumeros(strJogada);
					
					if(verificarEntrada == true) {
						numJogada = Integer.parseInt(strJogada);
					} else {
						System.out.println("Digite apenas números!");
					}
				}
				
				escolhaValida = opcaoValida(numJogada);
				
				if(escolhaValida == false) {
					System.out.println("Escolha uma opção válida!");
					verificarEntrada = false;
				}
			}
			
			atualizarCampo(numJogada, p1, campoInicial, campoAtualizado);
			velha++;
			fimdeJogo = checarVitoria(campoAtualizado);
			verificarEntrada = false;
			escolhaValida = false;
			
			if(fimdeJogo == false && !(velha == 9)) {
				while(escolhaValida == false) {
					while(verificarEntrada == false) {
						System.out.print("Escolha onde deseja jogar (Jogador 2/O): ");
						strJogada = scan.nextLine();
						verificarEntrada = apenasNumeros(strJogada);
						
						if(verificarEntrada == true) {
							numJogada = Integer.parseInt(strJogada);
						} else {
							System.out.println("Digite apenas números!");
						}
					}
					
					escolhaValida = opcaoValida(numJogada);
					
					if(escolhaValida == false) {
						System.out.println("Escolha uma opção válida!");
						verificarEntrada = false;
					}
				}
				
				atualizarCampo(numJogada, p2, campoInicial, campoAtualizado);
				velha++;
			}
			
			fimdeJogo = checarVitoria(campoAtualizado);
			verificarEntrada = false;
			escolhaValida = false;
			
			if(fimdeJogo == false && velha == 9) {
				System.out.println("Partida Encerrada!");
				System.out.println("Deu Velha!");
				fimdeJogo = true;
			} else if(fimdeJogo == true) {
				System.out.println("Partida Encerrada!");				
			}
		}

	scan.close();
}}
