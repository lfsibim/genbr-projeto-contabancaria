package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import conta.util.Cores;
import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;
		
		System.out.println("\nCriar Conta\n");
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.0f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Juliana Ramos", 8000f, 1);
		contas.cadastrar(cp2);
		
		contas.listarTodas();
		

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
					System.out.println("Digite o número da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					do {
						System.out.println("Digite o tipo da Conta (1-CC ou 2-CP): ");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
					
					System.out.println("Digite o Saldo da Conta (R$): ");
					saldo = leia.nextFloat();
					
					switch(tipo) {
						case 1 -> {
							System.out.println("Digite o Limite de Crédito (R$): ");
							limite = leia.nextFloat();
							contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
						}
						case 2 -> {
							System.out.println("Digite o dia do Aniversário da Conta: ");
							aniversario = leia.nextInt();
							contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
						}
					}
					keyPress();
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE_BOLD+"Listar todas as Contas\n\n");
					contas.listarTodas();
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
