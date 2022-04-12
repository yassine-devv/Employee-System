package com.company.backend;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ModificaDipendente{
    private String nome;
    int index;
    int cont=0;
    private final String pathDatabaseId = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\idDip.txt";
    private final String pathDatabaseReparto = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\repartoDip.txt";
    private final String pathDatabseNome = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\nomeDip.txt";

    public ModificaDipendente(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return true if the name of employee inserted was found
     * @throws FileNotFoundException
     */
    public boolean ceDipendente() throws FileNotFoundException {
        boolean ris=false;

        File file = new File(pathDatabseNome);
        Scanner scFile = new Scanner(file); // scan the file

        while(scFile.hasNextLine()) { //while there are to read
            if (getNome().equals(scFile.nextLine())) { // if the name inserted is equal to the line
                index = cont; //initialize the variable index with the cont
                ris = true; //return true
            }
            cont++;
        }

        return ris;
    }

    // this method search the id, skip all the lines of the file, and keep the id with the sae index of the line
    public String trovaId() throws IOException {
        String line = Files.lines(Paths.get(pathDatabaseId))
                .skip(index)
                .findFirst()
                .get();

        return line;
    }

    public String trovaReparto() throws IOException {
        String line = Files.lines(Paths.get(pathDatabaseReparto))
                .skip(index)
                .findFirst()
                .get();
        return line;
    }
    // set the id with the new id
    public void setId(String id) throws IOException {
        replaceMet(pathDatabaseId, id);
    }

    //set the name
    public void replaceNome(String nome) throws IOException {
        replaceMet(pathDatabseNome, nome);
    }

    public void setReaprto(String reparto) throws IOException {
        replaceMet(pathDatabaseReparto, reparto);
    }

    public void replaceMet(String path, String newLine) throws IOException {
        Scanner sc = new Scanner(new File(path));
        StringBuffer buffer = new StringBuffer();
        //Legge le righe del file e le appende nel StringBuffer
        while (sc.hasNextLine()) { //reading the lines while there are lines
            buffer.append(sc.nextLine()); //adding in the buffer the lines
        }
        String fileContents = buffer.toString();
        //keep the old element
        String old = Files.lines(Paths.get(path))
                .skip(index)
                .findFirst()
                .get();

        //replace the old element with the new
        fileContents = fileContents.replaceAll(old, newLine+"\n");
        FileWriter writer = new FileWriter(path);
        writer.append(fileContents); //append the content
        writer.flush();
    }

}
