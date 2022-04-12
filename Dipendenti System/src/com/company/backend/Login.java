package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {
    private String nome;
    private String password;

    public Login(String nome, String password){
        this.nome = nome;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return true if th name was found
     * @throws FileNotFoundException
     */
    public boolean cercaNomeUtente() throws FileNotFoundException {
        boolean ris=false;

        File file = new File("C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\addetti\\namesList.txt");
        Scanner scFile = new Scanner(file); //ope the file

        while(scFile.hasNextLine()){ //while there are lines to read
            if(getNome().equals(scFile.nextLine())) //if a line is equal to the name inserted
                ris=true; //initialize
        }
        return ris;
    }
    /**
     * @return true if th password was found
     * @throws FileNotFoundException
     */
    public boolean cercaPasswordUtente() throws FileNotFoundException {
        boolean ris=false;

        File file = new File("C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\addetti\\passwordsList.txt");
        Scanner scFile = new Scanner(file);

        while(scFile.hasNextLine()){
            if(getPassword().equals(scFile.nextLine()))
                ris=true;
        }
        return ris;
    }
}
