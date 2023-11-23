package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);

		int opcao;
		
		// Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
				
		// Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
		cp1.visualizar();
		cp1.sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();
	
		while (true) {

			System.out.println(Cores.TEXT_WHITE_BRIGHT+Cores.ANSI_BLUE_BACKGROUND+"*****************************************************");
			System.out.println("*                                                   *");
			System.out.println("*              BNS - BANCO NACIONAL SIB             *");
			System.out.println("*                                                   *");
			System.out.println("*****************************************************");
			System.out.println("*                                                   *");
			System.out.println("*            1 - Criar Conta                        *");
			System.out.println("*            2 - Listar todas as Contas             *");
			System.out.println("*            3 - Buscar Conta por Numero            *");
			System.out.println("*            4 - Atualizar Dados da Conta           *");
			System.out.println("*            5 - Apagar Conta                       *");
			System.out.println("*            6 - Sacar                              *");
			System.out.println("*            7 - Depositar                          *");
			System.out.println("*            8 - Transferir valores entre Contas    *");
			System.out.println("*            9 - Sair                               *");
			System.out.println("*                                                   *");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     "+Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD+"\nBanco Nacional Sib - O seu Futuro começa aqui!");
				sobre();
                 leia.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Criar Conta\n\n");
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as Contas\n\n");
					keyPress();
					break;
				case 3:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Consultar dados da Conta - por número\n\n");
					keyPress();
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Atualizar dados da Conta\n\n");
					keyPress();
					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Apagar a Conta\n\n");
					keyPress();
					break;
				case 6:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Saque\n\n");
					keyPress();
					break;
				case 7:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Depósito\n\n");
					keyPress();
					break;
				case 8:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Transferência entre Contas\n\n");
					keyPress();
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD+"\nOpção Inválida!\n");
					keyPress();
					break;
			}
		}
	}
    
	public static void sobre() {
		System.out.println(Cores.ANSI_WHITE_BACKGROUND+Cores.TEXT_BLACK_BOLD+"\n-------------------------------------------------");
		System.out.println(Cores.TEXT_BLACK_BOLD+"| Projeto Desenvolvido por: Luis Felipe Sibim   |");
		System.out.println(Cores.TEXT_BLACK_BOLD+"| Generation Brasil - generation@generation.org |");
		System.out.println(Cores.TEXT_BLACK_BOLD+"| github.com/lfsibim/genbr-projeto-contabancaria|");
		System.out.println("-------------------------------------------------");
	}
	
	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}	
}
