package com.company.backend;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Registrazione {
    String nome;
    String password;
    public Registrazione(String nome, String password){
        this.nome = nome;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addNameDatabase(){
        String pathFile = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\addetti\\namesList.txt";
        try {
            FileWriter file = new FileWriter(pathFile, true);
            file.write(getNome()+"\n");
            file.close();
        }catch(Exception e){
            //System.out.println(e);
            System.out.println("Registrazione fallita, prova in un altro moemnto, grazie!");
        }
    }

    public void addPasswordDatabase(){
        String pathFile = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\addetti\\passwordsList.txt";
        try {
            FileWriter file = new FileWriter(pathFile, true);
            file.write(getPassword()+"\n");
            file.close();
        }catch(Exception e){
            //System.out.println(e);
            System.out.println("Registrazione fallita, prova in un altro moemnto, grazie!");
        }
    }
}
