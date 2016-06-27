/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uffmail;

import java.io.IOException;
import java.util.Scanner;

public class UFFMail {

    private static void menu(Cadastro cadastro) throws IOException { //exception apenas para o pressionamento do enter, não é importante
        Aluno aluno;
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.contentEquals("4")) {
            System.out.println("Escolha uma opcao:\n1.Listar alunos\n2.Criar UFFMail\n3.Buscar aluno\n4.Sair");
            input = scanner.nextLine().trim();
            switch (input) {
                case "1": {
                    cadastro.listaCadastro();
                    break;
                }
                case "2": {
                    do {
                        System.out.println("Digite sua matricula: ");
                        input = scanner.nextLine().trim();
                        aluno = cadastro.buscaAluno(input);
                        if (aluno == null) {
                            System.out.println("Matricula inexistente");
                        }
                    } while (aluno == null);
                    System.out.println("Confira seus dados e aperte enter para continuar.");
                    aluno.exibeInfoAluno();
                    System.in.read();
                    aluno.criaUffmail();
                    cadastro.exportCSV();
                    break;
                }
                case "3": {
                    do {
                        System.out.println("Digite sua matricula: ");
                        input = scanner.nextLine().trim();
                        aluno = cadastro.buscaAluno(input);
                        if (aluno == null) {
                            System.out.println("Matricula inexistente");
                        }
                    } while (aluno == null);
                    aluno.exibeInfoAluno();
                    break;
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Cadastro cadastro = new Cadastro("alunos.csv");
        menu(cadastro);
    }
}
