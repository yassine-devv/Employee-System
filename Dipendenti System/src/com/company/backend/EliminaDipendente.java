package com.company.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;

public class EliminaDipendente {
    private String nome;
    private String id;
    private String reparto;
    ArrayList<String> listNome = new ArrayList<>();
    ArrayList<String> listId = new ArrayList<>();
    ArrayList<String> listReparto = new ArrayList<>();

    boolean ris=false;

    public EliminaDipendente(String nome, String id, String reparto){
        this.nome = nome;
        this.id = id;
        this.reparto = reparto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReparto() {
        return reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    /**
     * @return true if the name of the employee is deleted successful
     * @throws FileNotFoundException
     */
    public boolean eliminaNome() throws FileNotFoundException {
        final String pathFile = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\nomeDip.txt";
        File file = new File(pathFile);
        Scanner scFile = new Scanner(file);

        //pulisciArraylist(listNome);
        while (scFile.hasNextLine()) { // while there are lines to read
            listNome.add(scFile.nextLine()); //add in arraylist all the elements in the database txt
        }

        for(int i=0; i<listNome.size(); i++){ //a for to cicle in the arraylist
            if(getNome().equals(listNome.get(i))) //if the name inserted with the input is equal to a element in the arraylist
                listNome.remove(i); //delete the element
        }

        pulisciFile(file);
        return appendiData(listNome, pathFile, ris);
    }

    public boolean eliminaReparto() throws FileNotFoundException {
        final String pathFile = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\repartoDip.txt";
        File file = new File(pathFile);
        Scanner scFile = new Scanner(file);

        //pulisciArraylist(listReparto);
        while (scFile.hasNextLine()) {
            listReparto.add(scFile.nextLine()); //add the line in the arraylist
        }

        for(int i=0; i<listReparto.size(); i++){
            if(getReparto().equals(listReparto.get(i))) //if the name inserted is the same of the element i in the arraylist
                listReparto.remove(i); //delete the element requested
        }

        pulisciFile(file);
        return appendiData(listReparto, pathFile, ris);
    }

    public boolean eliminaId() throws FileNotFoundException {
        final String pathFile = "C:\\Users\\bouzi\\OneDrive\\Desktop\\Programs\\Java\\Dipendenti System\\src\\com\\company\\database\\dipendenti\\idDip.txt";
        File file = new File(pathFile);
        Scanner scFile = new Scanner(file);

        while (scFile.hasNextLine()) {
            listId.add(scFile.nextLine()); //aggiunge la linea nell'arraylist
        }

        for(int i=0; i<listId.size(); i++){
            if(getId().equals(listId.get(i))) //se il nome inserito è uguale all'elemento i della lista
                listId.remove(i); //elimina l'elemento richiesto
        }

        pulisciFile(file);
        return appendiData(listId, pathFile, ris);
    }

    public static void pulisciFile(File file) throws FileNotFoundException {
        //clean the file
        PrintWriter writer = new PrintWriter(file);
        writer.print(""); //print the file whit nothing
        writer.close(); //close the file
    }

    /**
     *
     * @param list
     * @param pathFile
     * @param ris
     * @return true if all the elements of arraylist was appendend without the element that you want to delete
     */
    public static boolean appendiData(ArrayList<String> list, String pathFile, boolean ris){
        for(int i=0; i<list.size(); i++){
            try {
                String lineToAppend = list.get(i)+"\n";
                byte[] byteArr = lineToAppend.getBytes();
                Files.write(Paths.get(pathFile), byteArr, StandardOpenOption.APPEND);
                ris=true;
            }catch(Exception e){
                ris=false;
            }
        }
        return ris;
    }
}
