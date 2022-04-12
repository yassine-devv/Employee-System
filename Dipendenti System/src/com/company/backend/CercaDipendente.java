package com.company.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class CercaDipendente {
    private String nome;
    private int id;
    int cont=0, index=0;

    public CercaDipendente(String nome){
        this.nome = nome;
        //this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public int getId() {
        return id;
    }
    /**
     * this method read the file, while the file is reading, a var cont increment, and when the name is equal a string in a line, a var index is equal of the line of the name
     * @return true if the name was found
     * @throws FileNotFoundException
     */
    public boolean cercaDipendenteNome() throws FileNotFoundException {
        File file = new File("C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\nomeDip.txt");
        Scanner scFile = new Scanner(file);
        boolean ris=false;

        while (scFile.hasNextLine()) {
            if (getNome().equals(scFile.nextLine())){
                index=cont;
                ris = true;
            }

            cont++;
        }

        return ris;
    }

    /**
     * this method search the id of the employee, the method skip all the lines, and stops in the same line where the name is
     * @return the id
     * @throws IOException
     */
    public String cercaDipendenteId() throws IOException {
        String id = Files.lines(Paths.get("C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\idDip.txt"))
                .skip(index)
                .findFirst()
                .get();

        return id;
    }
    /**
     * this method search the department where the employee work, the method skip all the lines, and stops in the same line where the name is
     * @return the department
     * @throws IOException
     */
    public String repartoDipendente() throws IOException {
        String reparto = Files.lines(Paths.get("C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\repartoDip.txt"))
                .skip(index)
                .findFirst()
                .get();

        return reparto;
    }
}
