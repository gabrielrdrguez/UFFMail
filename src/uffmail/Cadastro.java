/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uffmail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cadastro {

    private ArrayList<Aluno> alunos;
    private String header;

    public Cadastro(String filepath) {
        this.alunos = new ArrayList<>(); // inicializa o array
        File csv = new File(filepath);
        BufferedReader input;
        try {
            input = new BufferedReader(new FileReader(csv));
            String line = null;
            String[] infoArray;
            this.header = input.readLine();
            while ((line = input.readLine()) != null) { //lê cada linha até o fim do arquivo          
                infoArray = line.split(","); // divide a linha em elementos de um array de string pelo caractere ,
                if (infoArray[0].compareToIgnoreCase("nome") != 0) { // ignora cabeçalho
                    this.alunos.add(new Aluno(infoArray[0], infoArray[1], infoArray[2], infoArray[3], infoArray[4], infoArray[5]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo alunos.csv não encontrado. Insira-o na mesma pasta do  .jar");
            System.exit(1);
        } catch (IOException e) {
            System.out.println("Não foi possível ler o arquivo");
            System.exit(2);
        }
    }

    public void listaCadastro() {
        String[] aHeader = this.header.split(",");
        for (Aluno a : this.alunos) { // adiciona cabeçalho e letras maiúsculas
            System.out.println(aHeader[0].substring(0, 1).toUpperCase() + aHeader[0].substring(1) + ": " + a.getNome());
            System.out.println(aHeader[1].substring(0, 1).toUpperCase() + aHeader[1].substring(1) + ": " + a.getMatricula());
            System.out.println(aHeader[2].substring(0, 1).toUpperCase() + aHeader[2].substring(1) + ": " + a.getTelefone());
            System.out.println(aHeader[3].substring(0, 1).toUpperCase() + aHeader[3].substring(1) + ": " + a.getEmail());
            System.out.println(aHeader[4].substring(0, 1).toUpperCase() + aHeader[4].substring(1) + ": " + a.getUffmail());
            System.out.println(aHeader[5].substring(0, 1).toUpperCase() + aHeader[5].substring(1) + ": " + a.getStatus());
            System.out.println("");
        }
    }

    public void exportCSV() {

        FileWriter writer;
        try {
            writer = new FileWriter("alunos.csv");
            writer.write(header);
            writer.append("\n");
            for (Aluno a : this.alunos) {
                writer.append(a.getNome() + "," + a.getMatricula() + "," + a.getTelefone() + "," + a.getEmail() + "," + a.getUffmail() + "," + a.getStatus() + "\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("Não foi possível salvar o arquivo");
        }
    }

    public Aluno buscaAluno(String matriculaProcurada) {
        for (Aluno a : this.alunos) {
            if ((matriculaProcurada.compareToIgnoreCase(a.getMatricula())) == 0) {
                return a;
            }
        }
        return null;
    }

    public void add(Aluno a) {
        this.alunos.add(a);
    }

    public List getAluno() {
        return alunos;
    }

}
