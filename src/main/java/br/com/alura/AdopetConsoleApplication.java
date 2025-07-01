package br.com.alura;

import br.com.alura.commands.*;

import java.util.Scanner;

public class AdopetConsoleApplication {

    public static void main(String[] args) {

        System.out.println("##### BOAS VINDAS AO SISTEMA ADOPET CONSOLE #####");
        try {
            int opcaoEscolhida = 0;
            while (opcaoEscolhida != 5) {
                System.out.println("\nDIGITE O NÚMERO DA OPERAÇÃO DESEJADA:");
                System.out.println("1 -> Listar abrigos cadastrados");
                System.out.println("2 -> Cadastrar novo abrigo");
                System.out.println("3 -> Listar pets do abrigo");
                System.out.println("4 -> Importar pets do abrigo");
                System.out.println("5 -> Sair");

                String textoDigitado = new Scanner(System.in).nextLine();
                opcaoEscolhida = Integer.parseInt(textoDigitado);

                CommandExecutor executor = new CommandExecutor();

                if (opcaoEscolhida == 1) {
                    executor.executeCommand(new ListarAbrigosCommand());
                } else if (opcaoEscolhida == 2) {
                    executor.executeCommand(new CadastrarAbrigoCommand());
                } else if (opcaoEscolhida == 3) {
                    executor.executeCommand(new ListarPetsAbrigoCommand());
                } else if (opcaoEscolhida == 4) {
                    executor.executeCommand(new ImportarPetsAbrigoCommand());
                } else if (opcaoEscolhida == 5) {
                    break;
                } else {
                    System.out.println("NÚMERO INVÁLIDO!");
                    opcaoEscolhida = 0;
                }
            }
            System.out.println("Finalizando o programa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
