/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uffmail;

import java.util.Scanner;

public class Aluno {

    private String nome;
    private String matricula; // string para poder conter valores que comecem com 0
    private String telefone;
    private String email;
    private String uffmail;
    private String status;

    public Aluno(String nome, String matricula, String telefone, String email, String uffmail, String status) {
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.uffmail = uffmail;
        this.status = status;
    }

    public void criaUffmail() {

        //declaracao
        String[] nomeSplit = this.nome.split(" ");
        String sufix = "@id.uff.br";
        String[] sugestao = new String[7];
        boolean matriculaStatus = this.status.toLowerCase().contentEquals("ativo");
        boolean uffmailValido = this.uffmail.toLowerCase().contains(sufix);
        Scanner teclado = new Scanner(System.in);
        //verificacao e escolha
        if (matriculaStatus && (!uffmailValido)) { // verifica status e se o uffmail não é de um formato valido
            int rand = (int) (Math.random() * 10000 + 1000);
            String random = Integer.toString(rand);
            System.out.println("Olá, " + this.nome + "\nEscolha dentre as opcoes abaixo uma que será seu UFFMail:");
            switch (nomeSplit.length) {
                case 2: // nome e sobrenome
                    sugestao[0] = (nomeSplit[0].substring(0, 2) + "_" + nomeSplit[nomeSplit.length - 1] + random + sufix).toLowerCase();
                    sugestao[1] = (nomeSplit[0] + nomeSplit[nomeSplit.length - 1].substring(0, 2) + random + sufix).toLowerCase();
                    sugestao[2] = (nomeSplit[0].substring(0, 1) + nomeSplit[nomeSplit.length - 1] + random + sufix).toLowerCase();
                    sugestao[3] = (nomeSplit[nomeSplit.length - 1] + nomeSplit[0] + random + sufix).toLowerCase();
                    sugestao[4] = (nomeSplit[0] + nomeSplit[1] + random + sufix).toLowerCase();

                    System.out.println("1." + sugestao[0]);
                    System.out.println("2." + sugestao[1]);
                    System.out.println("3." + sugestao[2]);
                    System.out.println("4." + sugestao[3]);
                    System.out.println("5." + sugestao[4]);
                    break;

                default: //nome, 2 sobrenomes ou + (espera-se que o aluno nunca tenha apenas um nome) 

                    sugestao[0] = (nomeSplit[0].substring(0, 2) + "_" + nomeSplit[nomeSplit.length - 2] + random + sufix).toLowerCase();
                    sugestao[1] = (nomeSplit[0].substring(0, 2) + "_" + nomeSplit[nomeSplit.length - 1] + random + sufix).toLowerCase();
                    sugestao[2] = (nomeSplit[0] + nomeSplit[1].substring(0, 2) + nomeSplit[2].substring(0, 2) + random + sufix).toLowerCase();
                    sugestao[3] = (nomeSplit[0].substring(0, 1) + nomeSplit[nomeSplit.length - 2] + random + sufix).toLowerCase();
                    sugestao[4] = (nomeSplit[0].substring(0, 1) + nomeSplit[nomeSplit.length - 1] + random + sufix).toLowerCase();
                    sugestao[5] = (nomeSplit[nomeSplit.length - 2] + nomeSplit[0] + random + sufix).toLowerCase();
                    sugestao[6] = (nomeSplit[0] + nomeSplit[1] + nomeSplit[2] + random + sufix).toLowerCase();

                    System.out.println("1." + sugestao[0]);
                    System.out.println("2." + sugestao[1]);
                    System.out.println("3." + sugestao[2]);
                    System.out.println("4." + sugestao[3]);
                    System.out.println("5." + sugestao[4]);
                    System.out.println("6." + sugestao[5]);
                    System.out.println("7." + sugestao[6]);
                    break;
            }
            int escolha = 0;
            do {
                escolha = teclado.nextInt();
                if ((escolha > 7) || (escolha < 1)) {
                    System.out.println("Opcao inválida, escolha outra: ");
                }
            } while ((escolha > 7) || (escolha < 1));
            this.uffmail = sugestao[escolha - 1];
            System.out.println("Seu email " + this.uffmail + " foi criado com sucesso.\n" + "Um SMS foi enviado para " + this.telefone + " com a sua senha de acesso.");
        } else if ((!matriculaStatus) && (uffmailValido)) {
            System.out.println("Você já tem um UFFMail, seu UFFMail é: " + this.uffmail + ", porém sua matricula está inativa.");
        } else if ((matriculaStatus) && (uffmailValido)) {
            System.out.println("Você já tem um UFFMail, seu UFFMail é: " + this.uffmail);
        } else if ((matriculaStatus == false) && (!uffmailValido)) {
            System.out.println("Sua matrícula está inativa, você não pode criar um UFFMail");
        }
    }

    public void exibeInfoAluno(){
       System.out.println("Nome: "+this.nome); 
            System.out.println("Matricula: "+this.matricula);
            System.out.println("Telefone: "+this.telefone);
            System.out.println("Email: "+this.email);
            System.out.println("UFFMail: "+this.uffmail);
            System.out.println("Status: "+this.status);
            System.out.println("");
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUffmail() {
        return uffmail;
    }

    public void setUffmail(String uffmail) {
        this.uffmail = uffmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
